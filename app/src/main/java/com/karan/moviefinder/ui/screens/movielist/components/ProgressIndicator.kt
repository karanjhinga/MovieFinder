package com.karan.moviefinder.ui.screens.movielist.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.karan.moviefinder.R
import com.karan.moviefinder.ui.theme.MovieFinderTheme
import com.karan.moviefinder.ui.theme.spacing

@Composable
fun ProgressIndicator(title: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(MaterialTheme.spacing.l),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(title, textAlign = TextAlign.Center)
        CircularProgressIndicator(
            modifier = Modifier
                .size(40.dp)
                .padding(top = MaterialTheme.spacing.l),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ProgressIndicatorPreview() {
    MovieFinderTheme {
        ProgressIndicator(stringResource(R.string.please_wait), Modifier)
    }
}