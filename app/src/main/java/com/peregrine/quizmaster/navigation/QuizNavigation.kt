package com.peregrine.quizmaster.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.peregrine.quizmaster.ui.home.HomeScreen
import com.peregrine.quizmaster.ui.quiz.QuizScreen
import com.peregrine.quizmaster.ui.quiz.QuizViewModel
import com.peregrine.quizmaster.ui.result.ResultScreen

object Routes {
    const val HOME = "home"
    const val QUIZ = "quiz"
    const val RESULT = "result"
}

@Composable
fun QuizNavigation(
    viewModel: QuizViewModel
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.HOME
    ) {
        composable(Routes.HOME) {
            HomeScreen(
                onCategoryClick = { categoryId ->
                    viewModel.startQuiz(categoryId)
                    navController.navigate(Routes.QUIZ)
                }
            )
        }

        composable(Routes.QUIZ) {
            QuizScreen(
                viewModel = viewModel,
                onFinish = {
                    navController.navigate(Routes.RESULT) {
                        popUpTo(Routes.HOME)
                    }
                },
                onBack = {
                    viewModel.resetQuiz()
                    navController.popBackStack()
                }
            )
        }

        composable(Routes.RESULT) {
            ResultScreen(
                viewModel = viewModel,
                onRetry = {
                    val categoryId =
                        viewModel.uiState.questions.firstOrNull()?.categoryId

                    if (categoryId != null) {
                        viewModel.startQuiz(categoryId)
                        navController.navigate(Routes.QUIZ) {
                            popUpTo(Routes.RESULT) {
                                inclusive = true
                            }
                        }
                    } else {
                        navController.popBackStack(
                            Routes.HOME,
                            inclusive = false
                        )
                    }
                },
                onHome = {
                    viewModel.resetQuiz()
                    navController.navigate(Routes.HOME) {
                        popUpTo(Routes.HOME) {
                            inclusive = false
                        }
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}