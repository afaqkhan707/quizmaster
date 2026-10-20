package com.peregrine.quizmaster.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.material3.*
import com.peregrine.quizmaster.core.MotivationalQuotes
import kotlinx.coroutines.delay
import kotlin.random.Random
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.peregrine.quizmaster.core.UiState
import com.peregrine.quizmaster.data.model.Category
import com.peregrine.quizmaster.ui.ads.BannerAdView
import com.peregrine.quizmaster.ui.layout.ScreenHorizontalPadding
import com.peregrine.quizmaster.ui.layout.screenNavigationBars
import com.peregrine.quizmaster.ui.layout.screenStatusBars

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
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Page)
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .screenStatusBars()
                .verticalScroll(scrollState)
                .padding(horizontal = ScreenHorizontalPadding)
                .padding(top = 12.dp, bottom = 16.dp)
        ) {
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
                        onClick = { onCategoryClick("random_mix") },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White,
                            contentColor = Purple
                        )
                    ) {
                        Text("Start quiz", fontWeight = FontWeight.Bold)
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

            Spacer(Modifier.height(14.dp))

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
                        modifier = Modifier.fillMaxWidth().padding(16.dp),
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
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(2),
                        state = rememberLazyGridState(),
                        modifier = Modifier
                            .fillMaxWidth()
                            .heightIn(max = 1000.dp),
                        contentPadding = PaddingValues(bottom = 16.dp),
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                        userScrollEnabled = false
                    ) {
                        items(state.data, key = { it.id }) { category ->
                            CategoryCard(
                                category = category,
                                onClick = { onCategoryClick(category.id) }
                            )
                        }
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
        }

        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = Page,
            shadowElevation = 8.dp
        ) {
            BannerAdView(
                modifier = Modifier
                    .fillMaxWidth()
                    .screenNavigationBars()
            )
        }
    }
}

@Composable
private fun CategoryCard(category: Category, onClick: () -> Unit) {
    val (emoji, gradientColors) = when (category.id) {
        "general_knowledge" -> "🌍" to listOf(Color(0xFF6366F1), Color(0xFF8B5CF6))
        "science" -> "🔬" to listOf(Color(0xFF0EA5E9), Color(0xFF2563EB))
        "history" -> "📜" to listOf(Color(0xFFF59E0B), Color(0xFFD97706))
        "mathematics" -> "➗" to listOf(Color(0xFF10B981), Color(0xFF059669))
        "geography" -> "🗺️" to listOf(Color(0xFF14B8A6), Color(0xFF0D9488))
        "sports" -> "⚽" to listOf(Color(0xFFEC4899), Color(0xFFBE185D))
        "technology" -> "💻" to listOf(Color(0xFF3B82F6), Color(0xFF1D4ED8))
        "movies" -> "🎬" to listOf(Color(0xFF8B5CF6), Color(0xFF6D28D9))
        "music" -> "🎵" to listOf(Color(0xFFF43F5E), Color(0xFFE11D48))
        else -> "📚" to listOf(Purple, Purple)
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(160.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(44.dp)
                        .background(Brush.linearGradient(gradientColors), RoundedCornerShape(14.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(emoji, fontSize = 22.sp)
                }

            }

            Column {
                Text(
                    category.name,
                    color = Ink,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    maxLines = 2,
                    overflow = TextOverflow.Visible
                )
                Spacer(Modifier.height(2.dp))
                Text(
                    "10 questions",
                    color = Muted,
                    fontSize = 12.sp
                )
            }
        }
    }
}
