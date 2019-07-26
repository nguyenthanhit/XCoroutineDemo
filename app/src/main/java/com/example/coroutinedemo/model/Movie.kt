package com.example.coroutinedemo.model

import com.google.gson.annotations.SerializedName

class Movie {
    @SerializedName("id")
    val id: Int? = null

    @SerializedName("title")
    val title: String? = null

    @SerializedName("overview")
    val overview: String? = null

    @SerializedName("backdrop_path")
    val backdropPath: String? = null

    @SerializedName("vote_average")
    val voteAverage: Double? = null
}