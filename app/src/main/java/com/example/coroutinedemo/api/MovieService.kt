package com.example.coroutinedemo.api

import com.example.coroutinedemo.model.MovieDetail
import com.example.coroutinedemo.model.NowPlaying
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieService {
    @GET("movie/now_playing")
    suspend fun nowPlaying(): NowPlaying

    @GET("movie/{movie_id}")
    suspend fun getDetail(@Path("movie_id") movieId: Int): MovieDetail
}