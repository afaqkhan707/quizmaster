package com.peregrine.quizmaster.ui.result

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.peregrine.quizmaster.ui.quiz.QuizViewModel

@Composable
fun ResultScreen(
    viewModel: QuizViewModel,
    onRetry: () -> Unit,
    onHome: () -> Unit
) {
    val state = viewModel.uiState
    val total = state.questions.size
    val score = state.score
    val percentage = if (total > 0) score * 100 / total else 0

    val purple = Color(0xFF7562E8)
    val ink = Color(0xFF20243A)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF7F7FC))
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("🏆", fontSize = 64.sp)

        Spacer(Modifier.height(20.dp))

        Text(
            "Quiz completed!",
            color = ink,
            fontSize = 28.sp,
            fontWeight = FontWeight.ExtraBold
        )

        Spacer(Modifier.height(8.dp))

        Text(
            "Every question is a chance to learn.",
            color = Color(0xFF777D91),
            fontSize = 14.sp
        )

        Spacer(Modifier.height(30.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(28.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "$score / $total",
                    color = purple,
                    fontSize = 42.sp,
                    fontWeight = FontWeight.ExtraBold
                )

                Text("Correct answers", color = Color(0xFF777D91))

                Spacer(Modifier.height(20.dp))

                Text(
                    "$percentage%",
                    color = ink,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )

                Text("Your score", color = Color(0xFF777D91))
            }
        }

        Spacer(Modifier.height(28.dp))

        Button(
            onClick = onRetry,
            modifier = Modifier
                .fillMaxWidth()
                .height(54.dp),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = purple
            )
        ) {
            Text("Try again", fontWeight = FontWeight.Bold)
        }

        Spacer(Modifier.height(10.dp))

        OutlinedButton(
            onClick = onHome,
            modifier = Modifier
                .fillMaxWidth()
                .height(54.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            Text("Back to home", color = ink)
        }
    }
}