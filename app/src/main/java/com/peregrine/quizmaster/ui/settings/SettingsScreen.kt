package com.peregrine.quizmaster.ui.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.peregrine.quizmaster.core.UiState
import com.peregrine.quizmaster.data.model.User
import com.peregrine.quizmaster.ui.layout.ScreenHorizontalPadding
import com.peregrine.quizmaster.ui.layout.screenNavigationBars
import com.peregrine.quizmaster.ui.layout.screenStatusBars

private val Purple = Color(0xFF7562E8)
private val Ink = Color(0xFF20243A)
private val Muted = Color(0xFF777D91)
private val Page = Color(0xFFF7F7FC)

@Composable
fun SettingsScreen(
    onBack: () -> Unit,
    onLogout: () -> Unit,
    settingsViewModel: SettingsViewModel = viewModel()
) {
    val userState by settingsViewModel.userState.collectAsStateWithLifecycle()
    var showLogoutDialog by remember { mutableStateOf(false) }
    var seedMessage by remember { mutableStateOf<String?>(null) }
    var isSeeding by remember { mutableStateOf(false) }

    if (showLogoutDialog) {
        AlertDialog(
            onDismissRequest = { showLogoutDialog = false },
            title = { Text("Sign out?") },
            text = { Text("You'll need to sign in again to save your quiz stats.") },
            confirmButton = {
                TextButton(
                    onClick = {
                        showLogoutDialog = false
                        settingsViewModel.signOut { onLogout() }
                    }
                ) {
                    Text("Sign out", color = Color(0xFFCC5151))
                }
            },
            dismissButton = {
                TextButton(onClick = { showLogoutDialog = false }) {
                    Text("Cancel", color = Muted)
                }
            }
        )
    }

    if (seedMessage != null) {
        AlertDialog(
            onDismissRequest = { seedMessage = null },
            title = { Text("Firestore Seed") },
            text = { Text(seedMessage!!) },
            confirmButton = {
                TextButton(onClick = { seedMessage = null }) {
                    Text("OK", color = Purple)
                }
            }
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Page)
            .screenStatusBars()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onBack) {
                Icon(
                    Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = Ink
                )
            }
            Text(
                "Settings",
                color = Ink,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 8.dp)
            )
        }

        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
                .screenNavigationBars()
                .padding(horizontal = ScreenHorizontalPadding)
        ) {

            when (val state = userState) {
                is UiState.Loading -> {
                    Box(
                        modifier = Modifier.fillMaxWidth().height(200.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator(color = Purple)
                    }
                }

                is UiState.Success -> {
                    val user = state.data
                    ProfileSection(user = user, isGuest = settingsViewModel.isGuest)
                    Spacer(Modifier.height(20.dp))
                    StatsSection(user = user, isGuest = settingsViewModel.isGuest)
                    Spacer(Modifier.height(20.dp))
                    PreferencesSection()
                    Spacer(Modifier.height(20.dp))
                    DeveloperSection(
                        isSeeding = isSeeding,
                        onSeedClick = {
                            isSeeding = true
                            settingsViewModel.seedSampleData { success, msg ->
                                isSeeding = false
                                seedMessage = msg
                            }
                        }
                    )
                    Spacer(Modifier.height(20.dp))
                    AccountSection(
                        isGuest = settingsViewModel.isGuest,
                        onLogout = { showLogoutDialog = true }
                    )
                }

                is UiState.Error -> {
                    Text(state.message, color = Color(0xFFCC5151))
                }

                else -> Unit
            }

            Spacer(Modifier.height(32.dp))
        }
    }
}

@Composable
private fun DeveloperSection(isSeeding: Boolean, onSeedClick: () -> Unit) {
    Text(
        "Developer Tools",
        color = Ink,
        fontWeight = FontWeight.Bold,
        fontSize = 17.sp
    )
    Spacer(Modifier.height(10.dp))

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(1.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.weight(1f)
            ) {
                Text("☁️", fontSize = 22.sp)
                Spacer(Modifier.width(12.dp))
                Column {
                    Text("Seed Data", color = Ink, fontWeight = FontWeight.SemiBold, fontSize = 15.sp)
                    Text("Upload sample categories", color = Muted, fontSize = 12.sp)
                }
            }

            Button(
                onClick = onSeedClick,
                enabled = !isSeeding,
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Purple),
                contentPadding = PaddingValues(horizontal = 14.dp, vertical = 8.dp)
            ) {
                if (isSeeding) {
                    CircularProgressIndicator(
                        color = Color.White,
                        modifier = Modifier.size(18.dp),
                        strokeWidth = 2.dp
                    )
                } else {
                    Text("Upload", fontWeight = FontWeight.Bold, fontSize = 13.sp)
                }
            }
        }
    }
}

@Composable
private fun ProfileSection(user: User, isGuest: Boolean) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(1.dp)
    ) {
        Row(
            modifier = Modifier.padding(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Avatar
            Box(
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFE6E3F7)),
                contentAlignment = Alignment.Center
            ) {
                if (user.photoUrl.isNotBlank() && !isGuest) {
                    AsyncImage(
                        model = user.photoUrl,
                        contentDescription = "Profile photo",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                } else {
                    Icon(
                        Icons.Default.Person,
                        contentDescription = null,
                        tint = Purple,
                        modifier = Modifier.size(36.dp)
                    )
                }
            }

            Spacer(Modifier.width(16.dp))

            Column {
                Text(
                    user.name.ifBlank { "Guest User" },
                    color = Ink,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    if (isGuest) "Playing without an account" else user.email,
                    color = Muted,
                    fontSize = 13.sp
                )
                if (isGuest) {
                    Spacer(Modifier.height(4.dp))
                    Text(
                        "Sign in to save your progress",
                        color = Purple,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
    }
}

@Composable
private fun StatsSection(user: User, isGuest: Boolean) {
    Text(
        "Quiz Stats",
        color = Ink,
        fontWeight = FontWeight.Bold,
        fontSize = 17.sp
    )
    Spacer(Modifier.height(10.dp))

    if (isGuest) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Box(
                modifier = Modifier.fillMaxWidth().padding(24.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "Sign in to track your quiz stats 📊",
                    color = Muted,
                    fontSize = 14.sp
                )
            }
        }
        return
    }

    val accuracy = if (user.questionsAnswered > 0) {
        (user.correctAnswers * 100 / user.questionsAnswered)
    } else 0

    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            StatCard(
                modifier = Modifier.weight(1f),
                label = "Quizzes Played",
                value = "${user.quizzesPlayed}",
                emoji = "🎮"
            )
            StatCard(
                modifier = Modifier.weight(1f),
                label = "Questions",
                value = "${user.questionsAnswered}",
                emoji = "❓"
            )
        }
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            StatCard(
                modifier = Modifier.weight(1f),
                label = "Accuracy",
                value = "$accuracy%",
                emoji = "🎯"
            )
            StatCard(
                modifier = Modifier.weight(1f),
                label = "Best Category",
                value = user.bestCategory.ifBlank { "—" },
                emoji = "🏆"
            )
        }
    }
}

@Composable
private fun StatCard(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    emoji: String
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(1.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(emoji, fontSize = 24.sp)
            Spacer(Modifier.height(8.dp))
            Text(
                value,
                color = Purple,
                fontSize = 22.sp,
                fontWeight = FontWeight.ExtraBold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(label, color = Muted, fontSize = 12.sp)
        }
    }
}

@Composable
private fun PreferencesSection() {
    Text(
        "Preferences",
        color = Ink,
        fontWeight = FontWeight.Bold,
        fontSize = 17.sp
    )
    Spacer(Modifier.height(10.dp))

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(1.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("🌙", fontSize = 20.sp)
                Spacer(Modifier.width(12.dp))
                Column {
                    Text("Dark Mode", color = Ink, fontWeight = FontWeight.Medium, fontSize = 15.sp)
                    Text("Following system setting", color = Muted, fontSize = 12.sp)
                }
            }
            Text("AUTO", color = Purple, fontSize = 12.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
private fun AccountSection(isGuest: Boolean, onLogout: () -> Unit) {
    Text(
        "Account",
        color = Ink,
        fontWeight = FontWeight.Bold,
        fontSize = 17.sp
    )
    Spacer(Modifier.height(10.dp))

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(1.dp)
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            TextButton(
                onClick = onLogout,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        if (isGuest) "🔑  Sign In" else "🚪  Sign Out",
                        color = if (isGuest) Purple else Color(0xFFCC5151),
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 15.sp
                    )
                }
            }
        }
    }
}
