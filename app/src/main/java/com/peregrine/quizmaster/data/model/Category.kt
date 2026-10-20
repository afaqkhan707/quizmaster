package com.peregrine.quizmaster.data.model

import com.google.firebase.firestore.PropertyName

data class Category(
    val id: String = "",
    val name: String = "",
    val description: String = "",
    @get:PropertyName("isActive") @set:PropertyName("isActive")
    var isActive: Boolean = true,
    val order: Int = 0
)
