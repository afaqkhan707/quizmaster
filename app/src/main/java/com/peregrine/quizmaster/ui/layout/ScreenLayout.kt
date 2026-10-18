package com.peregrine.quizmaster.ui.layout

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.statusBars
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding

/** Standard horizontal padding for main screens. */
val ScreenHorizontalPadding = 20.dp

/** Typical AdMob banner height — reserves space so layout doesn't jump. */
val BannerAdHeight = 50.dp

@Composable
fun statusBarPaddingValues() = WindowInsets.statusBars.asPaddingValues()

@Composable
fun navigationBarPaddingValues() = WindowInsets.navigationBars.asPaddingValues()

/** Top safe area (status bar) for screens without a scaffold. */
fun Modifier.screenStatusBars(): Modifier = statusBarsPadding()

/** Bottom safe area (gesture / 3-button nav). */
fun Modifier.screenNavigationBars(): Modifier = navigationBarsPadding()

/** Full system bar insets — login, splash, result. */
fun Modifier.screenSystemBars(): Modifier = systemBarsPadding()
