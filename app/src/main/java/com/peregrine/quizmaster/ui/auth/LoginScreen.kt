package com.peregrine.quizmaster.ui.auth

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.peregrine.quizmaster.core.UiState
import com.peregrine.quizmaster.ui.layout.screenSystemBars

private val Purple = Color(0xFF7562E8)
private val PurpleLight = Color(0xFF9B76F6)
private val Ink = Color(0xFF20243A)

@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit,
    loginViewModel: LoginViewModel = viewModel()
) {
    val loginState by loginViewModel.loginState.collectAsStateWithLifecycle()
    val context = LocalContext.current

    var visible by remember { mutableStateOf(false) }
    val alpha by animateFloatAsState(
        targetValue = if (visible) 1f else 0f,
        animationSpec = tween(600),
        label = "login_alpha"
    )

    LaunchedEffect(Unit) { visible = true }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(Purple, PurpleLight, Color(0xFFF7F7FC))
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .screenSystemBars()
                .alpha(alpha)
                .padding(24.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            // Logo
            Text("🧠", fontSize = 64.sp)
            Spacer(Modifier.height(16.dp))

            Text(
                "QuizMaster",
                color = Color.White,
                fontSize = 32.sp,
                fontWeight = FontWeight.ExtraBold
            )

            Spacer(Modifier.height(8.dp))

            Text(
                "Learn something new,\none quiz at a time.",
                color = Color.White.copy(alpha = 0.8f),
                fontSize = 15.sp,
                textAlign = TextAlign.Center,
                lineHeight = 22.sp
            )

            Spacer(Modifier.height(56.dp))

            // Card with buttons
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(28.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(8.dp)
            ) {
                Column(
                    modifier = Modifier.padding(28.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        "Sign in to save your progress",
                        color = Ink,
                        fontWeight = FontWeight.Bold,
                        fontSize = 17.sp,
                        textAlign = TextAlign.Center
                    )

                    Spacer(Modifier.height(6.dp))

                    Text(
                        "Your quiz stats will be saved to your account.",
                        color = Color(0xFF777D91),
                        fontSize = 13.sp,
                        textAlign = TextAlign.Center
                    )

                    Spacer(Modifier.height(24.dp))

                    // Google Sign-In Button
                    Button(
                        onClick = {
                            loginViewModel.signInWithGoogle(context) { onLoginSuccess() }
                        },
                        enabled = loginState !is UiState.Loading,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(52.dp),
                        shape = RoundedCornerShape(14.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Purple
                        )
                    ) {
                        if (loginState is UiState.Loading) {
                            CircularProgressIndicator(
                                color = Color.White,
                                modifier = Modifier.size(22.dp),
                                strokeWidth = 2.dp
                            )
                        } else {
                            Text(
                                "🔵  Continue with Google",
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp
                            )
                        }
                    }

                    Spacer(Modifier.height(12.dp))

                    // Error message
                    if (loginState is UiState.Error) {
                        Text(
                            (loginState as UiState.Error).message,
                            color = Color(0xFFCC5151),
                            fontSize = 13.sp,
                            textAlign = TextAlign.Center
                        )
                        Spacer(Modifier.height(8.dp))
                    }

                    Divider(color = Color(0xFFEEEEEE))

                    Spacer(Modifier.height(12.dp))

                    // Guest button
                    TextButton(
                        onClick = {
                            loginViewModel.continueAsGuest { onLoginSuccess() }
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            "👤  Continue as Guest",
                            color = Color(0xFF777D91),
                            fontSize = 14.sp
                        )
                    }

                    Text(
                        "Guest progress won't be saved",
                        color = Color(0xFFAAAAAA),
                        fontSize = 11.sp
                    )
                }
            }
        }
    }
}
