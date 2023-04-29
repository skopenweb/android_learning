package com.skay.imdb.data

import com.skay.imdb.data.model.Movie
import com.skay.imdb.data.remote.RemoteEntityMovie

interface MoviesRepository {
    fun getMovies(): List<Movie>

    fun fetchMovies(callback: (List<RemoteEntityMovie>) -> Unit): Unit {
        // Do nothing
    }
}
