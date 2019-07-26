package com.example.coroutinedemo.repo

import com.example.coroutinedemo.api.MovieService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieRepository(private val service: MovieService) {

    suspend fun getMovieList() = withContext(Dispatchers.IO) {
        service.nowPlaying()
    }

    suspend fun getMovieDetail(movieId: Int) = withContext(Dispatchers.IO) {
        service.getDetail(movieId)
    }
}