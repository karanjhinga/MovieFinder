package com.karan.moviefinder.ui.screens.movielist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.karan.moviefinder.R
import com.karan.moviefinder.data.model.Movie
import com.karan.moviefinder.ui.screens.movielist.components.EmptyState
import com.karan.moviefinder.ui.screens.movielist.components.MoviesGrid
import com.karan.moviefinder.ui.screens.movielist.components.ProgressIndicator
import com.karan.moviefinder.ui.screens.movielist.components.SearchBar
import com.karan.moviefinder.ui.screens.movielist.components.previewList
import com.karan.moviefinder.ui.theme.MovieFinderTheme
import com.karan.moviefinder.utils.network.NetworkError
import com.karan.moviefinder.utils.network.toString

@Composable
fun MovieListScreen(
    searchText: String,
    state: MovieListState,
    onTextChange: (String) -> Unit,
    onMovieClicked: (Movie) -> Unit,
    onRetry: () -> Unit
) {
    Scaffold(
        content = { contentPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = contentPadding.calculateTopPadding()),
            ) {
                SearchBar(searchText, onTextChange)

                when (state) {
                    is MovieListState.Error -> EmptyState(
                        title = state.error.toString(LocalContext.current),
                        showRetry = true,
                        onRetry = onRetry,
                        modifier = Modifier.fillMaxSize()
                    )

                    is MovieListState.Loading -> ProgressIndicator(
                        title = stringResource(R.string.please_wait),
                        modifier = Modifier.fillMaxSize()
                    )

                    is MovieListState.Success -> if (state.movies.isEmpty()) {
                        EmptyState(
                            title = stringResource(R.string.no_movies_found),
                            modifier = Modifier.fillMaxSize()
                        )
                    } else MoviesGrid(
                        state.movies,
                        onMovieClicked,
                        contentPadding
                    )
                }
            }
        })
}

@Composable
@Preview
fun MovieListScreenLoadingPreview() {
    MovieFinderTheme {
        MovieListScreen(
            searchText = "",
            state = MovieListState.Loading,
            onTextChange = { TODO("preview") },
            onMovieClicked = { TODO("preview") },
            onRetry = { TODO("preview") }
        )
    }
}

@Composable
@Preview
fun MovieListScreenErrorPreview() {
    MovieFinderTheme {
        MovieListScreen(
            searchText = "",
            state = MovieListState.Error(NetworkError.NO_INTERNET),
            onTextChange = { TODO("preview") },
            onMovieClicked = { TODO("preview") },
            onRetry = { TODO("preview") }
        )
    }
}

@Composable
@Preview
fun MovieListScreenSuccessPreview() {
    MovieFinderTheme {
        MovieListScreen(
            searchText = "Dr Strange",
            state = MovieListState.Success(previewList),
            onTextChange = { TODO("preview") },
            onMovieClicked = { TODO("preview") },
            onRetry = { TODO("preview") }
        )
    }
}

@Composable
@Preview
fun MovieListScreenEmptyStatePreview() {
    MovieFinderTheme {
        MovieListScreen(
            searchText = "Dr Strange",
            state = MovieListState.Success(emptyList()),
            onTextChange = { TODO("preview") },
            onMovieClicked = { TODO("preview") },
            onRetry = { TODO("preview") }
        )
    }
}