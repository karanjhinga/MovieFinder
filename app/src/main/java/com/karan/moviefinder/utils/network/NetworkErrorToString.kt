package com.karan.moviefinder.utils.network

import android.content.Context
import com.karan.moviefinder.R

fun NetworkError.toString(context: Context): String {
    val resId = when (this) {
        NetworkError.NO_INTERNET, NetworkError.REQUEST_TIMEOUT -> R.string.no_internet_error
        else -> R.string.something_went_wrong
    }
    return context.getString(resId)
}