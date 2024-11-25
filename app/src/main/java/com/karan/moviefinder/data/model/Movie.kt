package com.karan.moviefinder.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

private const val POSTER_PREFIX = "https://image.tmdb.org/t/p/w500"

@Serializable
data class Movie(
    val id: Int,
    val title: String,
    val overview: String,
    @SerialName("poster_path")
    val posterPath: String?
) {

    val posterWithPrefix: String
        get() {
            return POSTER_PREFIX + posterPath
        }
}