package com.peregrine.quizmaster.ui.quiz

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.peregrine.quizmaster.data.DummyQuestions
import com.peregrine.quizmaster.data.Question

data class QuizUiState(
    val questions: List<Question> = emptyList(),
    val currentIndex: Int = 0,
    val selectedAnswer: Int? = null,
    val score: Int = 0
) {
    val currentQuestion: Question?
        get() = questions.getOrNull(currentIndex)

    val isLastQuestion: Boolean
        get() = currentIndex == questions.lastIndex
}

class QuizViewModel : ViewModel() {

    var uiState by mutableStateOf(QuizUiState())
        private set

    fun startQuiz(categoryId: String) {
        uiState = QuizUiState(
            questions = DummyQuestions.all.filter {
                it.categoryId == categoryId
            }
        )
    }

    fun selectAnswer(index: Int) {
        if (uiState.selectedAnswer != null) return

        uiState = uiState.copy(selectedAnswer = index)
    }

    fun nextQuestion() {
        val question = uiState.currentQuestion ?: return
        val answer = uiState.selectedAnswer ?: return

        val updatedScore = uiState.score +
                if (answer == question.correctAnswerIndex) 1 else 0

        uiState = if (uiState.isLastQuestion) {
            uiState.copy(score = updatedScore)
        } else {
            uiState.copy(
                currentIndex = uiState.currentIndex + 1,
                selectedAnswer = null,
                score = updatedScore
            )
        }
    }

    fun resetQuiz() {
        uiState = QuizUiState()
    }
}