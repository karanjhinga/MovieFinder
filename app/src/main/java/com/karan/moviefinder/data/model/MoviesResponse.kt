package com.karan.moviefinder.data.model

import kotlinx.serialization.Serializable

@Serializable
data class MoviesResponse(
    val results: List<Movie>
)