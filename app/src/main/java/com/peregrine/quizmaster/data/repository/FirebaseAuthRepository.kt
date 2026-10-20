package com.peregrine.quizmaster.data.repository

import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.firestore.firestore
import com.google.firebase.auth.auth
import com.google.firebase.Firebase
import com.peregrine.quizmaster.data.model.User
import kotlinx.coroutines.tasks.await

class FirebaseAuthRepository : AuthRepository {

    private val auth = Firebase.auth
    private val db = Firebase.firestore

    override fun getCurrentUser(): FirebaseUser? = auth.currentUser

    override fun isLoggedIn(): Boolean = auth.currentUser != null

    override suspend fun signInWithGoogle(idToken: String): Result<FirebaseUser> {
        return try {
            val credential = GoogleAuthProvider.getCredential(idToken, null)
            val result = auth.signInWithCredential(credential).await()
            val user = result.user ?: return Result.failure(Exception("Sign-in failed"))
            Result.success(user)
        } catch (e: Exception) {
            println(" check$e")
            Result.failure(e)
        }
    }

    override suspend fun saveUserToFirestore(user: User) {
        try {
            db.collection("users")
                .document(user.uid)
                .set(user)
                .await()
        } catch (_: Exception) { }
    }

    override suspend fun getUserFromFirestore(uid: String): User? {
        return try {
            db.collection("users")
                .document(uid)
                .get()
                .await()
                .toObject(User::class.java)
        } catch (_: Exception) {
            null
        }
    }

    override suspend fun updateQuizStats(
        uid: String,
        questionsAnswered: Int,
        correctAnswers: Int,
        categoryId: String
    ) {
        try {
            val docRef = db.collection("users").document(uid)
            db.runTransaction { transaction ->
                val snapshot = transaction.get(docRef)
                val current = snapshot.toObject(User::class.java) ?: return@runTransaction

                val newQuizzesPlayed = current.quizzesPlayed + 1
                val newQuestionsAnswered = current.questionsAnswered + questionsAnswered
                val newCorrectAnswers = current.correctAnswers + correctAnswers

                // Determine best category by tracking which category user scored highest in
                val bestCategory = if (questionsAnswered > 0 &&
                    correctAnswers.toFloat() / questionsAnswered >=
                    current.correctAnswers.toFloat().coerceAtLeast(1f) / current.questionsAnswered.coerceAtLeast(1)
                ) categoryId else current.bestCategory

                transaction.update(
                    docRef,
                    mapOf(
                        "quizzesPlayed" to newQuizzesPlayed,
                        "questionsAnswered" to newQuestionsAnswered,
                        "correctAnswers" to newCorrectAnswers,
                        "bestCategory" to bestCategory
                    )
                )
            }.await()
        } catch (_: Exception) { }
    }

    override fun signOut() {
        auth.signOut()
    }
}
