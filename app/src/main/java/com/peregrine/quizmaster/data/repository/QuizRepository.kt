package com.peregrine.quizmaster.data.repository

import com.peregrine.quizmaster.data.model.Category
import com.peregrine.quizmaster.data.model.Question
import kotlinx.coroutines.flow.Flow

interface QuizRepository {
    suspend fun getCategories(): List<Category>
    fun getCategoriesFlow(): Flow<List<Category>>
    suspend fun getQuestions(categoryId: String): List<Question>
    suspend fun seedSampleData(): Result<Unit>
}
