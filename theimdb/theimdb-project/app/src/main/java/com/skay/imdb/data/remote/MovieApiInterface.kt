package com.skay.imdb.data.remote

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface MovieApiInterface {
    @GET("3/movie/popular")
    fun getMovies(@Query("api_key") apiKey: String): Call<RemoteDataEntity?>
}