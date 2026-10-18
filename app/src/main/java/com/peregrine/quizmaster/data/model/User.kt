package com.peregrine.quizmaster.data.model

data class User(
    val uid: String = "",
    val name: String = "",
    val email: String = "",
    val photoUrl: String = "",
    val quizzesPlayed: Int = 0,
    val questionsAnswered: Int = 0,
    val correctAnswers: Int = 0,
    val bestCategory: String = ""
)
