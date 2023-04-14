package com.skay.imdb.data

import android.util.Log
import com.skay.imdb.common.DependencyContainer
import com.skay.imdb.data.model.Movie
import com.skay.imdb.data.remote.RemoteEntityMovie

class MoviesRepositoryImpl : MoviesRepository {

    override fun getMovies(): List<Movie> {
        return DependencyContainer.localDataSource.movies
//        return DependencyContainer.inMemoryDataSource.getMovies()
    }

    override fun fetchMovies(callback: (List<RemoteEntityMovie>) -> Unit) {
        DependencyContainer.remoteDataSource.fetchMovies(callback)
    }

}

fun main() {
    print(MoviesRepositoryImpl().getMovies())
}