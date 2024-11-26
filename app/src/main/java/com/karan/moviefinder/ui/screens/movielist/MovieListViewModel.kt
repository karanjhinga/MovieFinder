package com.karan.moviefinder.ui.screens.movielist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.karan.moviefinder.data.MovieRepository
import com.karan.moviefinder.data.model.Movie
import com.karan.moviefinder.utils.network.NetworkError
import com.karan.moviefinder.utils.network.onError
import com.karan.moviefinder.utils.network.onSuccess
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.launch
import javax.inject.Inject

@OptIn(FlowPreview::class)
@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {

    private val _query = MutableStateFlow("")
    val query = _query.asStateFlow()

    private val _state = MutableStateFlow<MovieListState>(MovieListState.Loading)
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            query.debounce(500).collect {
                loadMovies(it)
            }
        }
    }

    fun onSearchTextChange(text: String) {
        _query.value = text
    }

    fun onRetry() {
        viewModelScope.launch {
            loadMovies(query.value)
        }
    }

    private suspend fun loadMovies(query: String) {
        _state.value = MovieListState.Loading

        movieRepository
            .getTrendingMovies()
            .onSuccess { movies ->
                _state.value = MovieListState.Success(movies)
            }
            .onError { error ->
                _state.value = MovieListState.Error(error)
            }
    }
}

sealed interface MovieListState {
    data object Loading : MovieListState
    data class Error(val error: NetworkError) : MovieListState
    data class Success(val movies: List<Movie>) : MovieListState
}