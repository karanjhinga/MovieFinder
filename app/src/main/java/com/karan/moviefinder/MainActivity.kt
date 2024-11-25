package com.karan.moviefinder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.compose.rememberNavController
import com.karan.moviefinder.ui.LocalNavController
import com.karan.moviefinder.ui.MainContent
import com.karan.moviefinder.ui.theme.MovieFinderTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MovieFinderTheme {
                val navController = rememberNavController()

                CompositionLocalProvider(
                    LocalNavController provides navController,
                ) {
                    MainContent()
                }
            }
        }
    }
}
