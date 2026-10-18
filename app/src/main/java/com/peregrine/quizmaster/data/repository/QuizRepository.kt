package com.peregrine.quizmaster.data.repository

import com.peregrine.quizmaster.data.model.Category
import com.peregrine.quizmaster.data.model.Question

interface QuizRepository {
    suspend fun getCategories(): List<Category>
    suspend fun getQuestions(categoryId: String): List<Question>
}
