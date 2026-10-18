package com.peregrine.quizmaster.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Purple = Color(0xFF7562E8)
private val Ink = Color(0xFF20243A)
private val Muted = Color(0xFF777D91)
private val Page = Color(0xFFF7F7FC)

private data class QuizCategory(
    val id: String,
    val title: String,
    val subtitle: String,
    val emoji: String
)

@Composable
fun HomeScreen(
    onCategoryClick: (String) -> Unit
) {
    val categories = listOf(
        QuizCategory("science", "Science", "Space, nature & more", "🔬"),
        QuizCategory("general", "General Knowledge", "Test what you know", "🌍"),
        QuizCategory("technology", "Technology", "Digital world & tech", "💻")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Page)
            .verticalScroll(rememberScrollState())
            .padding(20.dp)
    ) {
        Spacer(Modifier.height(20.dp))

        Text(
            "QUIZMASTER",
            color = Purple,
            fontSize = 13.sp,
            fontWeight = FontWeight.Bold,
            letterSpacing = 2.sp
        )

        Spacer(Modifier.height(12.dp))

        Text(
            "Ready to challenge\nyour mind?",
            color = Ink,
            fontSize = 30.sp,
            lineHeight = 36.sp,
            fontWeight = FontWeight.ExtraBold
        )

        Spacer(Modifier.height(8.dp))

        Text(
            "Learn something new, one quiz at a time.",
            color = Muted,
            fontSize = 14.sp
        )

        Spacer(Modifier.height(24.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Brush.linearGradient(
                        listOf(Purple, Color(0xFF9B76F6))
                    ),
                    RoundedCornerShape(24.dp)
                )
                .padding(22.dp)
        ) {
            Column {
                Text("✨  DAILY CHALLENGE", color = Color.White,
                    fontSize = 12.sp, fontWeight = FontWeight.Bold)

                Spacer(Modifier.height(12.dp))

                Text(
                    "A little quiz.\nA lot of learning.",
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 30.sp
                )

                Spacer(Modifier.height(16.dp))

                Button(
                    onClick = { onCategoryClick("general") },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = Purple
                    )
                ) {
                    Text("Start quiz  →", fontWeight = FontWeight.Bold)
                }
            }
        }

        Spacer(Modifier.height(28.dp))

        Text(
            "Explore categories",
            color = Ink,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(Modifier.height(6.dp))

        Text(
            "Choose a topic and test yourself.",
            color = Muted,
            fontSize = 14.sp
        )

        Spacer(Modifier.height(14.dp))

        categories.forEachIndexed { index, category ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp)
                    .clickable { onCategoryClick(category.id) },
                shape = RoundedCornerShape(18.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                elevation = CardDefaults.cardElevation(1.dp)
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(category.emoji, fontSize = 28.sp)

                    Spacer(Modifier.width(14.dp))

                    Column(Modifier.weight(1f)) {
                        Text(
                            category.title,
                            color = Ink,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        )
                        Spacer(Modifier.height(4.dp))
                        Text(
                            category.subtitle,
                            color = Muted,
                            fontSize = 13.sp
                        )
                    }

                    Text("→", color = Purple, fontSize = 22.sp)
                }
            }
        }

        Spacer(Modifier.height(20.dp))

        Text(
            "Practice a little. Improve every day.",
            modifier = Modifier.align(Alignment.CenterHorizontally),
            color = Muted,
            fontSize = 12.sp
        )

        Spacer(Modifier.height(12.dp))
    }
}