package com.peregrine.quizmaster.ui.quiz

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.peregrine.quizmaster.data.model.Question
import com.peregrine.quizmaster.data.repository.AuthRepository
import com.peregrine.quizmaster.data.repository.FirebaseAuthRepository
import com.peregrine.quizmaster.data.repository.FirestoreQuizRepository
import com.peregrine.quizmaster.data.repository.QuizRepository
import kotlinx.coroutines.launch

data class QuizUiState(
    val questions: List<Question> = emptyList(),
    val currentIndex: Int = 0,
    val selectedAnswer: Int? = null,
    val score: Int = 0,
    val isLoading: Boolean = false,
    val error: String? = null,
    val currentCategoryId: String = ""
) {
    val currentQuestion: Question?
        get() = questions.getOrNull(currentIndex)

    val isLastQuestion: Boolean
        get() = currentIndex == questions.lastIndex
}

class QuizViewModel : ViewModel() {

    private val quizRepository: QuizRepository = FirestoreQuizRepository()
    private val authRepository: AuthRepository = FirebaseAuthRepository()

    var uiState by mutableStateOf(QuizUiState())
        private set

    fun startQuiz(categoryId: String) {
        uiState = QuizUiState(isLoading = true, currentCategoryId = categoryId)
        viewModelScope.launch {
            try {
                val questions = if (categoryId == "random_mix") {
                    val categories = quizRepository.getCategories()
                    val allQuestions = mutableListOf<Question>()
                    for (cat in categories) {
                        allQuestions.addAll(quizRepository.getQuestions(cat.id))
                    }
                    allQuestions
                } else {
                    quizRepository.getQuestions(categoryId)
                }

                val shuffled = questions.shuffled().take(10).map { q ->
                    q.copy(options = q.options.shuffled())
                }
                uiState = if (shuffled.isNotEmpty()) {
                    QuizUiState(
                        questions = shuffled,
                        currentCategoryId = categoryId
                    )
                } else {
                    QuizUiState(
                        error = "No questions found.",
                        currentCategoryId = categoryId
                    )
                }
            } catch (e: Exception) {
                uiState = QuizUiState(
                    error = e.message ?: "Could not load questions.",
                    currentCategoryId = categoryId
                )
            }
        }
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

    fun saveStatsIfLoggedIn() {
        val uid = authRepository.getCurrentUser()?.uid ?: return
        val state = uiState
        if (state.questions.isEmpty()) return

        viewModelScope.launch {
            authRepository.updateQuizStats(
                uid = uid,
                questionsAnswered = state.questions.size,
                correctAnswers = state.score,
                categoryId = state.currentCategoryId
            )
        }
    }

    fun resetQuiz() {
        uiState = QuizUiState()
    }
}