package com.skay.imdb.data

import com.skay.imdb.data.model.Movie

class LocalDataSource {
    private var _movies = mutableListOf<Movie>()
    val movies: List<Movie> = _movies

    init {
        loadFromFile()
    }

    private fun loadFromFile() {

    }
}