package com.peregrine.quizmaster

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.google.android.gms.ads.MobileAds
import com.peregrine.quizmaster.navigation.QuizNavigation
import com.peregrine.quizmaster.ui.theme.QuizMasterTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize AdMob
        MobileAds.initialize(this) {}

        enableEdgeToEdge()

        setContent {
            QuizMasterTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    QuizNavigation()
                }
            }
        }
    }
}
