package com.skay.imdb.data

import com.skay.imdb.data.model.Movie

interface MoviesRepository {
    fun getMovies(): List<Movie>
}
