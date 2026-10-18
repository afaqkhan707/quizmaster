package com.peregrine.quizmaster.ui.result

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.peregrine.quizmaster.ui.layout.ScreenHorizontalPadding
import com.peregrine.quizmaster.ui.layout.screenNavigationBars
import com.peregrine.quizmaster.ui.layout.screenStatusBars
import com.peregrine.quizmaster.ui.quiz.QuizViewModel

private const val INTERSTITIAL_AD_UNIT_ID = "ca-app-pub-3940256099942544/1033173712"

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
    val context = LocalContext.current
    val scrollState = rememberScrollState()

    val purple = Color(0xFF7562E8)
    val ink = Color(0xFF20243A)

    LaunchedEffect(Unit) {
        val activity = context as? Activity ?: return@LaunchedEffect
        InterstitialAd.load(
            context,
            INTERSTITIAL_AD_UNIT_ID,
            AdRequest.Builder().build(),
            object : InterstitialAdLoadCallback() {
                override fun onAdLoaded(ad: InterstitialAd) {
                    ad.fullScreenContentCallback = object : FullScreenContentCallback() {
                        override fun onAdDismissedFullScreenContent() { }
                        override fun onAdFailedToShowFullScreenContent(e: AdError) { }
                    }
                    ad.show(activity)
                }

                override fun onAdFailedToLoad(error: LoadAdError) { }
            }
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF7F7FC))
            .screenStatusBars()
            .screenNavigationBars()
            .verticalScroll(scrollState)
            .padding(horizontal = ScreenHorizontalPadding)
            .padding(top = 24.dp, bottom = 32.dp),
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
            colors = CardDefaults.cardColors(containerColor = Color.White)
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

                if (percentage == 100) {
                    Spacer(Modifier.height(12.dp))
                    Text("Perfect score! 🎉", color = Color(0xFF258753), fontWeight = FontWeight.Bold)
                } else if (percentage >= 70) {
                    Spacer(Modifier.height(12.dp))
                    Text("Great job! 👍", color = purple, fontWeight = FontWeight.SemiBold)
                }
            }
        }

        Spacer(Modifier.height(28.dp))

        Button(
            onClick = onRetry,
            modifier = Modifier
                .fillMaxWidth()
                .height(54.dp),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = purple)
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
