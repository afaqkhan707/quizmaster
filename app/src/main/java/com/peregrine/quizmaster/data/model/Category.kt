package com.peregrine.quizmaster.data.model

data class Category(
    val id: String = "",
    val name: String = "",
    val description: String = "",
    val isActive: Boolean = true,
    val order: Int = 0
)
