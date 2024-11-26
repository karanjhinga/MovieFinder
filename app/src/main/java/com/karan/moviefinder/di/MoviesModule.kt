package com.karan.moviefinder.di

import com.karan.moviefinder.data.MovieRepository
import com.karan.moviefinder.data.MovieRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class MoviesModule {

    @Binds
    @Singleton
    abstract fun provideMovieRepository(impl: MovieRepositoryImpl): MovieRepository
}