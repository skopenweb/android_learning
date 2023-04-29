package com.skay.imdb.data

import android.util.Log
import com.skay.imdb.common.DependencyContainer
import com.skay.imdb.data.model.Movie
import com.skay.imdb.data.remote.RemoteEntityMovie
import com.skay.imdb.data.remote.toUiMovie

class MoviesRepositoryImpl : MoviesRepository {

    override fun getMovies(): List<Movie> {
        return DependencyContainer.remoteDataSource.movies.map {
            it.toUiMovie()
        }
//        return DependencyContainer.localDataSource.movies
//        return DependencyContainer.inMemoryDataSource.getMovies()
    }

    override fun fetchMovies(callback: (List<RemoteEntityMovie>) -> Unit) {
        DependencyContainer.remoteDataSource.fetchMovies(callback)
    }

}

fun main() {
    MoviesRepositoryImpl().fetchMovies { print(it) }
}