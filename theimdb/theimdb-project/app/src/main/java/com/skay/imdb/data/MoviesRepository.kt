package com.skay.imdb.data

import com.skay.imdb.common.randomMovie
import com.skay.imdb.data.model.Movie

object MoviesRepository {
    fun getMovies(count: Int = 10): List<Movie> =
        (1..count).map { randomMovie() }
}

fun main() {
    print(MoviesRepository.getMovies())
}