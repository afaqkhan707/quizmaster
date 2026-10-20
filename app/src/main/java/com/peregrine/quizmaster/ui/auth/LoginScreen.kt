package com.peregrine.quizmaster.ui.auth

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.peregrine.quizmaster.core.UiState
import com.peregrine.quizmaster.ui.layout.screenSystemBars

private val Purple = Color(0xFF7562E8)
private val PurpleLight = Color(0xFF9B76F6)
private val Ink = Color(0xFF20243A)
private val Muted = Color(0xFF777D91)
private val Hairline = Color(0xFFE6E7F0)

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

            Spacer(Modifier.height(48.dp))

            SignInCard(
                isLoading = loginState is UiState.Loading,
                errorMessage = (loginState as? UiState.Error)?.message,
                onGoogleClick = {
                    loginViewModel.signInWithGoogle(context) { onLoginSuccess() }
                },
                onGuestClick = {
                    loginViewModel.continueAsGuest { onLoginSuccess() }
                }
            )
        }
    }
}

@Composable
private fun SignInCard(
    isLoading: Boolean,
    errorMessage: String?,
    onGoogleClick: () -> Unit,
    onGuestClick: () -> Unit
) {
    val cardShape = RoundedCornerShape(32.dp)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(
                elevation = 24.dp,
                shape = cardShape,
                ambientColor = Purple.copy(alpha = 0.25f),
                spotColor = Purple.copy(alpha = 0.35f)
            ),
        shape = cardShape,
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(0.dp)
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 24.dp, vertical = 28.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Icon badge
            Box(
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
                    .background(Brush.linearGradient(listOf(Purple, PurpleLight))),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Filled.Lock,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(28.dp)
                )
            }

            Spacer(Modifier.height(18.dp))

            Text(
                "Sign in to save your progress",
                color = Ink,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                lineHeight = 26.sp,
                textAlign = TextAlign.Center
            )

            Spacer(Modifier.height(6.dp))

            Text(
                "Your scores and stats sync to your account\nso you can pick up on any device.",
                color = Muted,
                fontSize = 13.sp,
                lineHeight = 19.sp,
                textAlign = TextAlign.Center
            )

            Spacer(Modifier.height(26.dp))

            GoogleButton(enabled = !isLoading, isLoading = isLoading, onClick = onGoogleClick)

            if (errorMessage != null) {
                Spacer(Modifier.height(12.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp))
                        .background(Color(0xFFFDECEC))
                        .padding(horizontal = 14.dp, vertical = 10.dp)
                ) {
                    Text(
                        errorMessage,
                        color = Color(0xFFB83A3A),
                        fontSize = 13.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }

            Spacer(Modifier.height(20.dp))

            OrDivider()

            Spacer(Modifier.height(20.dp))

            GuestButton(enabled = !isLoading, onClick = onGuestClick)

            Spacer(Modifier.height(10.dp))

            Text(
                "Guest progress isn't saved",
                color = Color(0xFF9A9FB2),
                fontSize = 12.sp
            )
        }
    }
}

@Composable
private fun GoogleButton(
    enabled: Boolean,
    isLoading: Boolean,
    onClick: () -> Unit
) {
    val interaction = remember { MutableInteractionSource() }
    val pressed by interaction.collectIsPressedAsState()
    val scale by animateFloatAsState(if (pressed) 0.97f else 1f, label = "google_press")

    OutlinedButton(
        onClick = onClick,
        enabled = enabled,
        interactionSource = interaction,
        modifier = Modifier
            .fillMaxWidth()
            .height(54.dp)
            .graphicsLayer { scaleX = scale; scaleY = scale },
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(1.dp, Hairline),
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = Color.White,
            contentColor = Ink,
            disabledContainerColor = Color.White
        )
    ) {
        if (isLoading) {
            CircularProgressIndicator(
                color = Purple,
                modifier = Modifier.size(22.dp),
                strokeWidth = 2.dp
            )
        } else {
            GoogleLogo(size = 22.dp)
            Spacer(Modifier.width(12.dp))
            Text(
                "Continue with Google",
                fontWeight = FontWeight.SemiBold,
                fontSize = 15.sp
            )
        }
    }
}

@Composable
private fun GuestButton(
    enabled: Boolean,
    onClick: () -> Unit
) {
    val interaction = remember { MutableInteractionSource() }
    val pressed by interaction.collectIsPressedAsState()
    val scale by animateFloatAsState(if (pressed) 0.97f else 1f, label = "guest_press")

    Button(
        onClick = onClick,
        enabled = enabled,
        interactionSource = interaction,
        modifier = Modifier
            .fillMaxWidth()
            .height(54.dp)
            .graphicsLayer { scaleX = scale; scaleY = scale },
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Purple.copy(alpha = 0.10f),
            contentColor = Purple,
            disabledContainerColor = Purple.copy(alpha = 0.05f),
            disabledContentColor = Purple.copy(alpha = 0.4f)
        ),
        elevation = ButtonDefaults.buttonElevation(0.dp, 0.dp, 0.dp, 0.dp, 0.dp)
    ) {
        Icon(
            imageVector = Icons.Filled.Person,
            contentDescription = null,
            modifier = Modifier.size(22.dp)
        )
        Spacer(Modifier.width(12.dp))
        Text(
            "Continue as guest",
            fontWeight = FontWeight.SemiBold,
            fontSize = 15.sp
        )
    }
}

@Composable
private fun OrDivider() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            Modifier
                .weight(1f)
                .height(1.dp)
                .background(Hairline)
        )
        Text(
            "or",
            color = Color(0xFF9A9FB2),
            fontSize = 12.sp,
            modifier = Modifier.padding(horizontal = 12.dp)
        )
        Box(
            Modifier
                .weight(1f)
                .height(1.dp)
                .background(Hairline)
        )
    }
}

/** Four-colour Google "G", drawn with Canvas so no extra drawable or dependency is needed. */
@Composable
private fun GoogleLogo(size: Dp) {
    Canvas(modifier = Modifier.size(size)) {
        val stroke = this.size.minDimension * 0.2f
        val inset = stroke / 2f
        val arcSize = Size(this.size.width - stroke, this.size.height - stroke)
        val topLeft = Offset(inset, inset)
        val style = Stroke(width = stroke, cap = StrokeCap.Butt)

        val red = Color(0xFFEA4335)
        val yellow = Color(0xFFFBBC05)
        val green = Color(0xFF34A853)
        val blue = Color(0xFF4285F4)

        drawArc(red, 215f, 100f, false, topLeft, arcSize, style = style)
        drawArc(yellow, 135f, 80f, false, topLeft, arcSize, style = style)
        drawArc(green, 45f, 90f, false, topLeft, arcSize, style = style)
        drawArc(blue, 0f, 45f, false, topLeft, arcSize, style = style)

        // Horizontal bar of the "G"
        drawRect(
            color = blue,
            topLeft = Offset(this.size.width / 2f, this.size.height / 2f - stroke / 2f),
            size = Size(this.size.width / 2f, stroke)
        )
    }
}