package com.peregrine.quizmaster.data.model

import com.google.firebase.firestore.PropertyName

data class Question(
    val id: String = "",
    val categoryId: String = "",
    val question: String = "",
    val options: List<String> = emptyList(),
    val correctAnswerIndex: Int = 0,
    val explanation: String = "",
    @get:PropertyName("isActive") @set:PropertyName("isActive")
    var isActive: Boolean = true,
    val order: Int = 0
)
