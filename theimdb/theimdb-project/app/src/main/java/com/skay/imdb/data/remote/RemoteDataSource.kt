package com.skay.imdb.data.remote

import com.skay.imdb.data.model.Movie

class RemoteDataSource {
    fun getMovies(callback: (List<Movie>) -> Unit): List<Movie> {

        // Todo add retrofiet calling here
        callback(emptyList())
        return emptyList()
    }
}