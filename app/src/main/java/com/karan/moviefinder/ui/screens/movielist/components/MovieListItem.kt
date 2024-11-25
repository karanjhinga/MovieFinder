package com.karan.moviefinder.ui.screens.movielist.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.karan.moviefinder.data.model.Movie
import com.karan.moviefinder.ui.components.AsyncImage
import com.karan.moviefinder.ui.theme.MovieFinderTheme
import com.karan.moviefinder.ui.theme.spacing

@Composable
fun MovieListItem(
    movie: Movie,
    onMovieClicked: (Movie) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier
            .padding(MaterialTheme.spacing.s)
            .clickable {
                onMovieClicked(movie)
            }) {
        AsyncImage(
            url = movie.posterWithPrefix,
            contentDescription = movie.title,
            modifier = Modifier
                .aspectRatio(1f)
                .clip(RoundedCornerShape(MaterialTheme.spacing.s))
                .background(MaterialTheme.colorScheme.secondaryContainer)
        )

        Text(
            text = movie.title,
            modifier = Modifier.padding(top = MaterialTheme.spacing.m),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun MovieListItemPreview() {
    MovieFinderTheme {
        MovieListItem(
            movie = previewList[0],
            onMovieClicked = { TODO("Preview") },
        )
    }
}