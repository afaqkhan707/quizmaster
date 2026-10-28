package com.peregrine.quizmaster

import com.peregrine.quizmaster.data.model.Category
import com.peregrine.quizmaster.data.model.Question
import com.peregrine.quizmaster.data.model.User
import com.peregrine.quizmaster.data.repository.AuthRepository
import com.peregrine.quizmaster.data.repository.QuizRepository
import com.peregrine.quizmaster.ui.quiz.QuizViewModel
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class FakeQuizRepository : QuizRepository {
    private val sampleCategory = Category(id = "cat_tech", name = "Tech")
    private val sampleQuestion = Question(
        id = "q1",
        categoryId = "cat_tech",
        question = "What is Kotlin?",
        options = listOf("Language", "Database", "OS", "Browser"),
        correctAnswer = "Language",
        explanation = "Kotlin is a programming language."
    )

    override suspend fun getCategories(): List<Category> = listOf(sampleCategory)
    override fun getCategoriesFlow(): Flow<List<Category>> = flowOf(listOf(sampleCategory))
    override suspend fun getQuestions(categoryId: String): List<Question> {
        return if (categoryId == "cat_tech") listOf(sampleQuestion) else emptyList()
    }
    override suspend fun seedSampleData(): Result<Unit> = Result.success(Unit)
}

class FakeAuthRepository : AuthRepository {
    override fun getCurrentUser(): FirebaseUser? = null
    override fun isLoggedIn(): Boolean = false
    override suspend fun signInWithGoogle(idToken: String): Result<FirebaseUser> = Result.failure(Exception("Not implemented"))
    override suspend fun saveUserToFirestore(user: User) {}
    override suspend fun getUserFromFirestore(uid: String): User? = null
    override suspend fun updateQuizStats(uid: String, questionsAnswered: Int, correctAnswers: Int, categoryId: String) {}
    override fun signOut() {}
}

@OptIn(ExperimentalCoroutinesApi::class)
class QuizViewModelTest {

    private val testDispatcher = UnconfinedTestDispatcher()

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun startQuiz_loadsQuestionsSuccessfully() {
        val viewModel = QuizViewModel(
            quizRepository = FakeQuizRepository(),
            authRepository = FakeAuthRepository()
        )

        viewModel.startQuiz("cat_tech")

        val state = viewModel.uiState
        assertEquals(1, state.questions.size)
        assertEquals("cat_tech", state.currentCategoryId)
        assertNotNull(state.currentQuestion)
    }

    @Test
    fun selectAnswer_and_nextQuestion_updatesScore() {
        val viewModel = QuizViewModel(
            quizRepository = FakeQuizRepository(),
            authRepository = FakeAuthRepository()
        )

        viewModel.startQuiz("cat_tech")
        val question = viewModel.uiState.currentQuestion
        val correctIndex = question?.options?.indexOf(question.correctAnswer) ?: 0

        viewModel.selectAnswer(correctIndex)
        viewModel.nextQuestion()

        assertEquals(1, viewModel.uiState.score)
    }

    @Test
    fun resetQuiz_clearsState() {
        val viewModel = QuizViewModel(
            quizRepository = FakeQuizRepository(),
            authRepository = FakeAuthRepository()
        )

        viewModel.startQuiz("cat_tech")
        viewModel.resetQuiz()

        assertEquals(0, viewModel.uiState.questions.size)
        assertEquals("", viewModel.uiState.currentCategoryId)
    }

    @Test
    fun startQuiz_randomMix_loadsAllCategories() {
        val viewModel = QuizViewModel(
            quizRepository = FakeQuizRepository(),
            authRepository = FakeAuthRepository()
        )

        viewModel.startQuiz("random_mix")

        assertEquals(1, viewModel.uiState.questions.size) // Our fake only has 1 total
    }

    @Test
    fun nextQuestion_onLastQuestion_doesNotIncrementIndex() {
        val viewModel = QuizViewModel(
            quizRepository = FakeQuizRepository(),
            authRepository = FakeAuthRepository()
        )

        viewModel.startQuiz("cat_tech")
        val question = viewModel.uiState.currentQuestion
        val correctIndex = question?.options?.indexOf(question.correctAnswer) ?: 0

        viewModel.selectAnswer(correctIndex)
        viewModel.nextQuestion()

        assertEquals(0, viewModel.uiState.currentIndex)
    }
}
