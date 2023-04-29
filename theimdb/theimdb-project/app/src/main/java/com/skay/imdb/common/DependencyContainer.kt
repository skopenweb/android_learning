package com.skay.imdb.common

import com.google.gson.GsonBuilder
import com.skay.imdb.data.InMemoryDataSource
import com.skay.imdb.data.LocalDataSource
import com.skay.imdb.data.MoviesRepositoryImpl
import com.skay.imdb.data.remote.RemoteDataSource
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object DependencyContainer {

    private var _retrofietClient: Retrofit? = null

    val moviesRepository = MoviesRepositoryImpl()

    private var _localDataSource: LocalDataSource? = null
    val localDataSource: LocalDataSource
        get() {
            if (_localDataSource == null) {
                _localDataSource = LocalDataSource()
            }
            return _localDataSource!!
        }

    val inMemoryDataSource by lazy { InMemoryDataSource() }

    val remoteDataSource: RemoteDataSource by lazy { RemoteDataSource() }

    fun getRetrofitClient(): Retrofit {
        if (_retrofietClient == null) {
            val httpClient = OkHttpClient()

            val gson = GsonBuilder()
                .setLenient()
                .create()

            _retrofietClient = Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
        }
        return _retrofietClient!!
    }
}