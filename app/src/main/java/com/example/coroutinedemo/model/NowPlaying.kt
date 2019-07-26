package com.example.coroutinedemo.model

import com.google.gson.annotations.SerializedName


class NowPlaying {
    @SerializedName("results")
    val movies: List<Movie>? = null
}