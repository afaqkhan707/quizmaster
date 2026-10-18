package com.peregrine.quizmaster.ui.quiz

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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

@Composable
fun QuizScreen(
    viewModel: QuizViewModel,
    onFinish: () -> Unit,
    onBack: () -> Unit
) {
    val state = viewModel.uiState
    val question = state.currentQuestion

    val purple = Color(0xFF7562E8)
    val ink = Color(0xFF20243A)
    val muted = Color(0xFF777D91)
    val page = Color(0xFFF7F7FC)

    if (question == null) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(page)
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("No questions available", color = ink)
            Spacer(Modifier.height(16.dp))
            Button(onClick = onBack) {
                Text("Go back")
            }
        }
        return
    }

    val progress =
        (state.currentIndex + 1).toFloat() / state.questions.size

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(page)
            .padding(20.dp)
    ) {
        TextButton(onClick = onBack) {
            Text("←  Exit quiz", color = purple)
        }

        Spacer(Modifier.height(12.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                "QUESTION ${state.currentIndex + 1}",
                color = purple,
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp
            )

            Text(
                "${state.currentIndex + 1} of ${state.questions.size}",
                color = muted,
                fontSize = 13.sp
            )
        }

        Spacer(Modifier.height(12.dp))

        LinearProgressIndicator(
            progress = { progress },
            modifier = Modifier
                .fillMaxWidth()
                .height(7.dp),
            color = purple,
            trackColor = Color(0xFFE6E3F7)
        )

        Spacer(Modifier.height(30.dp))

        Text(
            "Think carefully 💡",
            color = muted,
            fontSize = 14.sp
        )

        Spacer(Modifier.height(12.dp))

        Text(
            question.question,
            color = ink,
            fontSize = 25.sp,
            lineHeight = 33.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(Modifier.height(24.dp))

        question.options.forEachIndexed { index, option ->
            val selected = state.selectedAnswer == index

            val optionColor = when {
                state.selectedAnswer == null -> Color.White
                index == question.correctAnswerIndex ->
                    Color(0xFFE0F5E9)
                selected -> Color(0xFFFFE6E6)
                else -> Color.White
            }

            val borderColor = when {
                selected -> purple
                state.selectedAnswer != null &&
                        index == question.correctAnswerIndex ->
                    Color(0xFF35A66F)
                else -> Color(0xFFE8E8F0)
            }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 5.dp)
                    .clickable(
                        enabled = state.selectedAnswer == null
                    ) {
                        viewModel.selectAnswer(index)
                    },
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = optionColor
                ),
                border = androidx.compose.foundation.BorderStroke(
                    1.dp, borderColor
                )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "${'A' + index}",
                        color = purple,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(Modifier.width(14.dp))

                    Text(
                        option,
                        modifier = Modifier.weight(1f),
                        color = ink,
                        fontSize = 15.sp
                    )

                    if (
                        state.selectedAnswer != null &&
                        index == question.correctAnswerIndex
                    ) {
                        Text("✓", color = Color(0xFF258753))
                    }
                }
            }
        }

        Spacer(Modifier.weight(1f))

        if (state.selectedAnswer != null) {
            val correct =
                state.selectedAnswer == question.correctAnswerIndex

            Text(
                if (correct) "Correct answer! 🎉" else "Not quite — learn and try again!",
                color = if (correct) Color(0xFF258753) else Color(0xFFCC5151),
                fontWeight = FontWeight.SemiBold
            )

            if (question.explanation.isNotBlank()) {
                Spacer(Modifier.height(5.dp))
                Text(question.explanation, color = muted, fontSize = 13.sp)
            }

            Spacer(Modifier.height(12.dp))
        }

        Button(
            onClick = {
                val lastQuestion = state.isLastQuestion
                viewModel.nextQuestion()

                if (lastQuestion) {
                    onFinish()
                }
            },
            enabled = state.selectedAnswer != null,
            modifier = Modifier
                .fillMaxWidth()
                .height(54.dp),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = purple
            )
        ) {
            Text(
                if (state.isLastQuestion) "See my result  →"
                else "Next question  →",
                fontWeight = FontWeight.Bold
            )
        }
    }
}