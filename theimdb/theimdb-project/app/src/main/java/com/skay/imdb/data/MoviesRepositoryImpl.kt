package com.skay.imdb.data

import com.skay.imdb.common.DependencyContainer
import com.skay.imdb.data.model.Movie

class MoviesRepositoryImpl : MoviesRepository {

    override fun getMovies(): List<Movie> {
        return DependencyContainer.localDataSource.movies
//        return DependencyContainer.inMemoryDataSource.getMovies()
    }
}

fun main() {
    print(MoviesRepositoryImpl().getMovies())
}