package com.peregrine.quizmaster.data.model

import com.google.firebase.firestore.PropertyName

data class Question(
    @get:PropertyName("id") @set:PropertyName("id")
    var id: Any = "",
    val categoryId: String = "",
    val question: String = "",
    val options: List<String> = emptyList(),
    val correctAnswer: String = "",
    val explanation: String = "",
    @get:PropertyName("isActive") @set:PropertyName("isActive")
    var isActive: Boolean = true,
    val order: Int = 0
) {
    val stringId: String
        get() = id.toString()
}
