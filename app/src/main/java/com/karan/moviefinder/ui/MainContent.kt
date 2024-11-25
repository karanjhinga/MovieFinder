package com.karan.moviefinder.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.karan.moviefinder.ui.navigation.Screens
import com.karan.moviefinder.ui.screens.moviedetail.MovieDetailScreen
import com.karan.moviefinder.ui.screens.movielist.MovieListScreen

val LocalNavController = compositionLocalOf<NavHostController> { error("No nav controller") }

@Composable
fun MainContent() {
    NavHost(navController = LocalNavController.current, startDestination = Screens.Movies) {
        composable<Screens.Movies> {
            MovieListScreen()
        }

        composable<Screens.MovieDetail> {
            val movie = it.toRoute<Screens.MovieDetail>()
            MovieDetailScreen(movie)
        }
    }
}