package com.skay.imdb.data.remote

import com.google.gson.annotations.SerializedName
import com.skay.imdb.common.Constants
import com.skay.imdb.data.model.Movie

data class RemoteDataEntity(
    @SerializedName("page")
    val page: Int,
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

fun RemoteEntityMovie.toUiMovie(): Movie {
    return Movie(
        name = this.name,
        description = this.description,
        imageUrl = Constants.PREFIX_PATH.plus(this.imageUrl),
        releaseDate = this.releaseDate,
        rating = this.rating,
        popularity = this.popularity
    )
}