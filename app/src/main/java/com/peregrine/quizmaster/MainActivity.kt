package com.peregrine.quizmaster
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.peregrine.quizmaster.navigation.QuizNavigation
import com.peregrine.quizmaster.ui.quiz.QuizViewModel
import com.peregrine.quizmaster.ui.theme.QuizMasterTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            QuizMasterTheme {
                val quizViewModel: QuizViewModel = viewModel()

                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    QuizNavigation(
                        viewModel = quizViewModel
                    )
                }
            }
        }
    }
}
