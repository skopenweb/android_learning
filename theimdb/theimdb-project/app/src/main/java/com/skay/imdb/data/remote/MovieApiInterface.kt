package com.skay.imdb.data.remote

import okhttp3.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface MovieApiInterface {
    @GET("users/{username}")
    fun getMovies(@Path("username") username: String?): Call<RemoteDataEntity>?
}