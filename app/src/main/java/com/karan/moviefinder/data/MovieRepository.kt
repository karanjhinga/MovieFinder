package com.karan.moviefinder.data

import com.karan.moviefinder.BuildConfig
import com.karan.moviefinder.data.model.Movie
import com.karan.moviefinder.data.model.MoviesResponse
import com.karan.moviefinder.data.network.Endpoints
import com.karan.moviefinder.utils.network.NetworkError
import com.karan.moviefinder.utils.network.Result
import com.karan.moviefinder.utils.network.constructUrl
import com.karan.moviefinder.utils.network.map
import com.karan.moviefinder.utils.network.safeCall
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.url
import javax.inject.Inject

interface MovieRepository {
    suspend fun getTrendingMovies(): Result<List<Movie>, NetworkError>
    suspend fun searchMovie(query: String): Result<List<Movie>, NetworkError>
}

class MovieRepositoryImpl @Inject constructor(
    private val httpClient: HttpClient
) : MovieRepository {

    override suspend fun getTrendingMovies(): Result<List<Movie>, NetworkError> {
        return safeCall<MoviesResponse> {
            httpClient.get {
                url(constructUrl(Endpoints.TRENDING_MOVIES))
                parameter("api_key", BuildConfig.TMDB_API_KEY)
            }
        }.map { it.results }
    }

    override suspend fun searchMovie(query: String): Result<List<Movie>, NetworkError> {
        return safeCall<MoviesResponse> {
            httpClient.get {
                url {
                    url(constructUrl(Endpoints.SEARCH))
                    parameter("api_key", BuildConfig.TMDB_API_KEY)
                    parameter("include_adult", true)
                    parameter("query", query)
                }
            }
        }.map { it.results }
    }
}