package com.skay.imdb.data.remote

import com.google.gson.annotations.SerializedName

data class RemoteDataEntity(
    @SerializedName("results")
    val results: List<RemoteEntityMovie>
)

data class RemoteEntityMovie(
    @SerializedName("title")
    val name: String,

    @SerializedName("overview")
    val description: String,

    @SerializedName("poster_path")
    val imageUrl: String,

    @SerializedName("release_date")
    val releaseDate: String,

    @SerializedName("vote_average")
    val rating: Double,

    @SerializedName("popularity")
    val popularity: Double
)