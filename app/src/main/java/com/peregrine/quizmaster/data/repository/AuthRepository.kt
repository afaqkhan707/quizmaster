package com.peregrine.quizmaster.data.repository

import com.google.firebase.auth.FirebaseUser
import com.peregrine.quizmaster.data.model.User

interface AuthRepository {
    fun getCurrentUser(): FirebaseUser?
    fun isLoggedIn(): Boolean
    suspend fun signInWithGoogle(idToken: String): Result<FirebaseUser>
    suspend fun saveUserToFirestore(user: User)
    suspend fun getUserFromFirestore(uid: String): User?
    suspend fun updateQuizStats(uid: String, questionsAnswered: Int, correctAnswers: Int, categoryId: String)
    fun signOut()
}
