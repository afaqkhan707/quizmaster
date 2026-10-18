package com.peregrine.quizmaster.data

object DummyQuestions {

    val all = listOf(
        Question(
            id = "s1",
            categoryId = "science",
            question = "Which planet is known as the Red Planet?",
            options = listOf("Earth", "Mars", "Jupiter", "Venus"),
            correctAnswerIndex = 1,
            explanation = "Mars appears red because of iron oxide."
        ),
        Question(
            id = "s2",
            categoryId = "science",
            question = "Which gas do plants absorb?",
            options = listOf("Oxygen", "Nitrogen", "Carbon dioxide", "Hydrogen"),
            correctAnswerIndex = 2
        ),
        Question(
            id = "g1",
            categoryId = "general",
            question = "What is the capital of Japan?",
            options = listOf("Seoul", "Tokyo", "Beijing", "Bangkok"),
            correctAnswerIndex = 1
        ),
        Question(
            id = "g2",
            categoryId = "general",
            question = "How many days are in a leap year?",
            options = listOf("364", "365", "366", "367"),
            correctAnswerIndex = 2
        ),
        Question(
            id = "t1",
            categoryId = "technology",
            question = "What does CPU stand for?",
            options = listOf(
                "Central Processing Unit",
                "Computer Personal Unit",
                "Central Program Utility",
                "Core Processing User"
            ),
            correctAnswerIndex = 0
        ),
        Question(
            id = "t2",
            categoryId = "technology",
            question = "Which language is officially used for Android development?",
            options = listOf("Kotlin", "Swift", "Ruby", "PHP"),
            correctAnswerIndex = 0
        )
    )
}