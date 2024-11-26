package com.karan.moviefinder.ui.screens.moviedetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import com.karan.moviefinder.ui.components.AsyncImage
import com.karan.moviefinder.ui.navigation.Screens
import com.karan.moviefinder.ui.screens.movielist.components.previewList
import com.karan.moviefinder.ui.theme.MovieFinderTheme
import com.karan.moviefinder.ui.theme.spacing

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieDetailScreen(
    movie: Screens.MovieDetail,
    onBackClicked: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    IconButton(onClick = onBackClicked) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        },
        content = { contentPadding ->
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .padding(
                        top = contentPadding.calculateTopPadding(),
                        bottom = contentPadding.calculateBottomPadding() + MaterialTheme.spacing.l,
                        start = MaterialTheme.spacing.l,
                        end = MaterialTheme.spacing.l
                    ),
            ) {

                AsyncImage(
                    url = movie.poster,
                    contentDescription = movie.title,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f)
                        .clip(RoundedCornerShape(MaterialTheme.spacing.m))
                        .background(colorScheme.secondaryContainer),
                )

                Text(
                    text = movie.title,
                    modifier = Modifier.padding(top = MaterialTheme.spacing.l),
                    style = MaterialTheme.typography.titleLarge
                )

                Text(
                    movie.description,
                    modifier = Modifier.padding(top = MaterialTheme.spacing.m)
                )
            }
        }
    )
}

@Composable
@Preview
fun MovieDetailScreenPreview() {
    MovieFinderTheme {
        MovieDetailScreen(
            Screens.MovieDetail(1, previewList[0].title, previewList[0].overview, "poster"),
            onBackClicked = { TODO("preview") })
    }
}