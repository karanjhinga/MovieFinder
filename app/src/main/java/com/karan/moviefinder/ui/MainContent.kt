package com.karan.moviefinder.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.karan.moviefinder.data.model.Movie
import com.karan.moviefinder.ui.navigation.Screens
import com.karan.moviefinder.ui.screens.moviedetail.MovieDetailScreen
import com.karan.moviefinder.ui.screens.movielist.MovieListScreen
import com.karan.moviefinder.ui.screens.movielist.MovieListViewModel

val LocalNavController = compositionLocalOf<NavHostController> { error("No nav controller") }

@Composable
fun MainContent() {
    NavHost(navController = LocalNavController.current, startDestination = Screens.Movies) {
        composable<Screens.Movies> {
            val viewModel = hiltViewModel<MovieListViewModel>()

            val searchText by viewModel.query.collectAsStateWithLifecycle()
            val state by viewModel.state.collectAsStateWithLifecycle()

            val navController = LocalNavController.current
            val onMovieClicked: (Movie) -> Unit =
                { movie ->
                    navController.navigate(
                        Screens.MovieDetail(
                            movie.id,
                            movie.title,
                            movie.overview,
                            movie.posterWithPrefix
                        )
                    )
                }

            MovieListScreen(
                searchText = searchText,
                state = state,
                onTextChange = viewModel::onSearchTextChange,
                onMovieClicked = onMovieClicked,
                onRetry = viewModel::onRetry
            )
        }

        composable<Screens.MovieDetail> {
            val movie = it.toRoute<Screens.MovieDetail>()
            MovieDetailScreen(movie)
        }
    }
}