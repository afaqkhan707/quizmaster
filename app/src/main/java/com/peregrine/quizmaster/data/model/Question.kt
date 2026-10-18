package com.peregrine.quizmaster.data.model

data class Question(
    val id: String = "",
    val categoryId: String = "",
    val question: String = "",
    val options: List<String> = emptyList(),
    val correctAnswerIndex: Int = 0,
    val explanation: String = "",
    val isActive: Boolean = true,
    val order: Int = 0
)
