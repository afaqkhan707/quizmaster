package com.peregrine.quizmaster.data.repository

import android.util.Log
import com.google.firebase.firestore.firestore
import com.google.firebase.Firebase
import com.peregrine.quizmaster.data.model.Category
import com.peregrine.quizmaster.data.model.Question
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await

class FirestoreQuizRepository : QuizRepository {

    private val db = Firebase.firestore
    private val TAG = "FirestoreQuizRepository"

    override suspend fun getCategories(): List<Category> {
        return try {
            val snapshot = db.collection("categories")
                .whereEqualTo("isActive", true)
                .orderBy("order")
                .get()
                .await()

            val categories = snapshot.documents.mapNotNull { doc ->
                doc.toObject(Category::class.java)?.copy(id = doc.id)
            }
            Log.d(TAG, "Fetched ${categories.size} categories: $categories")
            categories
        } catch (e: Exception) {
            Log.e(TAG, "Error fetching categories", e)
            emptyList()
        }
    }

    override fun getCategoriesFlow(): Flow<List<Category>> = callbackFlow {
        val listener = db.collection("categories")
            .whereEqualTo("isActive", true)
            .orderBy("order")
            .addSnapshotListener { snapshot, error ->
                if (error != null) {
                    Log.e(TAG, "Listen failed", error)
                    trySend(emptyList())
                    return@addSnapshotListener
                }

                val categories = snapshot?.documents?.mapNotNull { doc ->
                    doc.toObject(Category::class.java)?.copy(id = doc.id)
                } ?: emptyList()

                Log.d(TAG, "Realtime snapshot received ${categories.size} categories")
                trySend(categories)
            }

        awaitClose { listener.remove() }
    }

    override suspend fun getQuestions(categoryId: String): List<Question> {
        return try {
            val snapshot = db.collection("questions")
                .whereEqualTo("categoryId", categoryId)
                .whereEqualTo("isActive", true)
                .orderBy("order")
                .get()
                .await()

            val questions = snapshot.documents.mapNotNull { doc ->
                doc.toObject(Question::class.java)?.copy(id = doc.id)
            }
            Log.d(TAG, "Fetched ${questions.size} questions for categoryId='$categoryId': $questions")
            questions
        } catch (e: Exception) {
            Log.e(TAG, "Error fetching questions for categoryId='$categoryId'", e)
            emptyList()
        }
    }

    override suspend fun seedSampleData(): Result<Unit> {
        return try {
            val batch = db.batch()

            for (categoryMap in QuizSampleData.Categories) {
                val categoryId = categoryMap["id"].toString()
                val ref = db.collection("categories").document(categoryId)
                batch.set(ref, categoryMap)
            }

            for (questionMap in QuizSampleData.Questions) {
                val questionId = questionMap["id"].toString()
                val ref = db.collection("questions").document(questionId)
                batch.set(ref, questionMap)
            }

            batch.commit().await()
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
