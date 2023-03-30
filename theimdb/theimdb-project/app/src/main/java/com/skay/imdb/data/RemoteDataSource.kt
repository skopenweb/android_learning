package com.skay.imdb.data

import com.skay.imdb.data.model.Movie

class RemoteDataSource {
    suspend fun getMovies(): List<Movie> {
        return emptyList()
    }
}