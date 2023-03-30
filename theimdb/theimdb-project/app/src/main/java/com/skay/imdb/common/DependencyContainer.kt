package com.skay.imdb.common

import com.skay.imdb.data.InMemoryDataSource
import com.skay.imdb.data.LocalDataSource
import com.skay.imdb.data.MoviesRepositoryImpl
import com.skay.imdb.data.RemoteDataSource

object DependencyContainer {

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
}