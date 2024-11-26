package com.karan.moviefinder.ui.screens.movielist.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.karan.moviefinder.R
import com.karan.moviefinder.ui.theme.MovieFinderTheme
import com.karan.moviefinder.ui.theme.spacing

@Composable
fun EmptyState(
    title: String,
    showRetry: Boolean = false,
    onRetry: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(MaterialTheme.spacing.l),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(title, textAlign = TextAlign.Center)

        if (showRetry) {
            Button(onClick = onRetry, modifier = Modifier.padding(top = MaterialTheme.spacing.l)) {
                Text(stringResource(R.string.retry))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun NoInternetEmptyStatePreview() {
    MovieFinderTheme {
        EmptyState(stringResource(R.string.no_internet_error), true)
    }
}

@Preview(showBackground = true)
@Composable
private fun NoDataEmptyStatePreview() {
    MovieFinderTheme {
        EmptyState(stringResource(R.string.no_movies_found))
    }
}