package com.peregrine.quizmaster.data.repository

import com.google.firebase.firestore.firestore
import com.google.firebase.Firebase
import com.peregrine.quizmaster.data.model.Category
import com.peregrine.quizmaster.data.model.Question
import kotlinx.coroutines.tasks.await

class FirestoreQuizRepository : QuizRepository {

    private val db = Firebase.firestore

    override suspend fun getCategories(): List<Category> {
        return try {
            db.collection("categories")
                .whereEqualTo("isActive", true)
                .orderBy("order")
                .get()
                .await()
                .documents
                .mapNotNull { doc ->
                    doc.toObject(Category::class.java)?.copy(id = doc.id)
                }
        } catch (e: Exception) {
            emptyList()
        }
    }

    override suspend fun getQuestions(categoryId: String): List<Question> {
        return try {
            db.collection("questions")
                .whereEqualTo("categoryId", categoryId)
                .whereEqualTo("isActive", true)
                .orderBy("order")
                .get()
                .await()
                .documents
                .mapNotNull { doc ->
                    doc.toObject(Question::class.java)?.copy(id = doc.id)
                }
        } catch (e: Exception) {
            emptyList()
        }
    }
}
