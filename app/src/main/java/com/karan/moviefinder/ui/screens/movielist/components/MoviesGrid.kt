package com.karan.moviefinder.ui.screens.movielist.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.karan.moviefinder.data.model.Movie
import com.karan.moviefinder.ui.theme.MovieFinderTheme
import com.karan.moviefinder.ui.theme.spacing

private const val COLUMN_COUNT = 2

@Composable
fun MoviesGrid(
    items: List<Movie>,
    onMovieClicked: (Movie) -> Unit = {},
    contentPadding: PaddingValues = PaddingValues()
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(COLUMN_COUNT),
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.s),
        contentPadding = PaddingValues(
            top = MaterialTheme.spacing.s,
            bottom = contentPadding.calculateBottomPadding(),
            start = MaterialTheme.spacing.s,
            end = MaterialTheme.spacing.s,
        )
    ) {
        items(items.size) { index ->
            MovieListItem(items[index], onMovieClicked)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MoviesGridPreview() {
    MovieFinderTheme {
        MoviesGrid(previewList)
    }
}

val previewList =
    listOf(
        Movie(1, "Opennheimer", "Some description about opennheimer movie", null),
        Movie(2, "Dr Strange", "Some description about dr strange movie", null),
        Movie(
            3,
            "Venom a long name to see text wrap now the text is even longer",
            "Some description about venom movie",
            null
        ),
        Movie(4, "Wicked", "Some description about Wicked movie", null),
    )