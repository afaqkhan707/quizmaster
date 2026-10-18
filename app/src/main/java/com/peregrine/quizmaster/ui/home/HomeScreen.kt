package com.peregrine.quizmaster.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.peregrine.quizmaster.core.UiState
import com.peregrine.quizmaster.data.model.Category
import com.peregrine.quizmaster.ui.ads.BannerAdView

private val Purple = Color(0xFF7562E8)
private val Ink = Color(0xFF20243A)
private val Muted = Color(0xFF777D91)
private val Page = Color(0xFFF7F7FC)

@Composable
fun HomeScreen(
    onCategoryClick: (String) -> Unit,
    onSettingsClick: () -> Unit,
    homeViewModel: HomeViewModel = viewModel()
) {
    val categoriesState by homeViewModel.categoriesState.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Page)
    ) {
        // Scrollable content
        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(20.dp)
        ) {
            Spacer(Modifier.height(20.dp))

            // Top row: title + settings icon
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    "QUIZMASTER",
                    color = Purple,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 2.sp
                )
                IconButton(onClick = onSettingsClick) {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = "Settings",
                        tint = Muted
                    )
                }
            }

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

            // Daily challenge banner
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        Brush.linearGradient(listOf(Purple, Color(0xFF9B76F6))),
                        RoundedCornerShape(24.dp)
                    )
                    .padding(22.dp)
            ) {
                Column {
                    Text(
                        "✨  DAILY CHALLENGE",
                        color = Color.White,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
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
                        onClick = { onCategoryClick("general_knowledge") },
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

            // Categories state
            when (val state = categoriesState) {
                is UiState.Loading -> {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(180.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator(color = Purple)
                    }
                }

                is UiState.Error -> {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            state.message,
                            color = Color(0xFFCC5151),
                            fontSize = 14.sp
                        )
                        Spacer(Modifier.height(12.dp))
                        OutlinedButton(onClick = { homeViewModel.loadCategories() }) {
                            Text("Retry", color = Purple)
                        }
                    }
                }

                is UiState.Success -> {
                    state.data.forEach { category ->
                        CategoryCard(
                            category = category,
                            onClick = { onCategoryClick(category.id) }
                        )
                    }
                }

                else -> Unit
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

        // Banner ad pinned at bottom
        BannerAdView(
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
private fun CategoryCard(category: Category, onClick: () -> Unit) {
    val emoji = when (category.id) {
        "general_knowledge" -> "🌍"
        "science" -> "🔬"
        "history" -> "📜"
        "mathematics" -> "➗"
        "geography" -> "🗺️"
        else -> "📚"
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(1.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(emoji, fontSize = 28.sp)
            Spacer(Modifier.width(14.dp))
            Column(Modifier.weight(1f)) {
                Text(
                    category.name,
                    color = Ink,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    category.description,
                    color = Muted,
                    fontSize = 13.sp
                )
            }
            Text("→", color = Purple, fontSize = 22.sp)
        }
    }
}