package com.peregrine.quizmaster.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.peregrine.quizmaster.ui.auth.LoginScreen
import com.peregrine.quizmaster.ui.home.HomeScreen
import com.peregrine.quizmaster.ui.quiz.QuizScreen
import com.peregrine.quizmaster.ui.quiz.QuizViewModel
import com.peregrine.quizmaster.ui.result.ResultScreen
import com.peregrine.quizmaster.ui.settings.SettingsScreen
import com.peregrine.quizmaster.ui.splash.SplashScreen

object Routes {
    const val SPLASH = "splash"
    const val LOGIN = "login"
    const val HOME = "home"
    const val QUIZ = "quiz"
    const val RESULT = "result"
    const val SETTINGS = "settings"
}

@Composable
fun QuizNavigation() {
    val navController = rememberNavController()
    val quizViewModel: QuizViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = Routes.SPLASH
    ) {
        composable(Routes.SPLASH) {
            SplashScreen(
                onNavigateToLogin = {
                    navController.navigate(Routes.LOGIN) {
                        popUpTo(Routes.SPLASH) { inclusive = true }
                    }
                },
                onNavigateToHome = {
                    navController.navigate(Routes.HOME) {
                        popUpTo(Routes.SPLASH) { inclusive = true }
                    }
                }
            )
        }

        composable(Routes.LOGIN) {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate(Routes.HOME) {
                        popUpTo(Routes.LOGIN) { inclusive = true }
                    }
                }
            )
        }

        composable(Routes.HOME) {
            HomeScreen(
                onCategoryClick = { categoryId ->
                    quizViewModel.startQuiz(categoryId)
                    navController.navigate(Routes.QUIZ)
                },
                onSettingsClick = {
                    navController.navigate(Routes.SETTINGS)
                }
            )
        }

        composable(Routes.QUIZ) {
            QuizScreen(
                viewModel = quizViewModel,
                onFinish = {
                    navController.navigate(Routes.RESULT) {
                        popUpTo(Routes.HOME)
                    }
                },
                onBack = {
                    quizViewModel.resetQuiz()
                    navController.popBackStack()
                }
            )
        }

        composable(Routes.RESULT) {
            ResultScreen(
                viewModel = quizViewModel,
                onRetry = {
                    val categoryId = quizViewModel.uiState.currentCategoryId
                    if (categoryId.isNotBlank()) {
                        quizViewModel.startQuiz(categoryId)
                        navController.navigate(Routes.QUIZ) {
                            popUpTo(Routes.RESULT) { inclusive = true }
                        }
                    } else {
                        navController.popBackStack(Routes.HOME, inclusive = false)
                    }
                },
                onHome = {
                    quizViewModel.resetQuiz()
                    navController.navigate(Routes.HOME) {
                        popUpTo(Routes.HOME) { inclusive = false }
                        launchSingleTop = true
                    }
                }
            )
        }

        composable(Routes.SETTINGS) {
            SettingsScreen(
                onBack = {
                    navController.popBackStack()
                },
                onLogout = {
                    navController.navigate(Routes.LOGIN) {
                        popUpTo(0) { inclusive = true }
                    }
                }
            )
        }
    }
}