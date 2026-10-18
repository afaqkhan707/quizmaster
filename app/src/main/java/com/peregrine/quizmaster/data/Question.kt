package com.peregrine.quizmaster.data

data class Question(
    val id: String,
    val categoryId: String,
    val question: String,
    val options: List<String>,
    val correctAnswerIndex: Int,
    val explanation: String = ""
)