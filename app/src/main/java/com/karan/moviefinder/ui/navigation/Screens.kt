package com.karan.moviefinder.ui.navigation

import kotlinx.serialization.Serializable

sealed interface Screens {
    @Serializable
    object Movies

    @Serializable
    data class MovieDetail(
        val id: Int,
        val title: String,
        val description: String,
        val poster: String
    ) : Screens
}