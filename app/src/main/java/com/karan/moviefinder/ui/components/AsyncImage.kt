package com.karan.moviefinder.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.karan.moviefinder.R
import coil3.compose.AsyncImage as CoilImage

@Composable
fun AsyncImage(url: String?, contentDescription: String?, modifier: Modifier = Modifier) {
    CoilImage(
        model = url,
        contentDescription = contentDescription,
        contentScale = ContentScale.Crop,
        modifier = modifier,
        placeholder = painterResource(R.drawable.ic_placeholder),
        error = painterResource(R.drawable.ic_placeholder),
    )
}

@Preview(showBackground = true)
@Composable
fun AsyncImagePreview() {
    AsyncImage(null, null)
}