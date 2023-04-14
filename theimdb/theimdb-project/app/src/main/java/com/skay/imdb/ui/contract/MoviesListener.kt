package com.skay.imdb.ui.contract

import com.skay.imdb.business.Presenter
import com.skay.imdb.data.model.Movie

interface IView {
    fun updateView(movies: List<Movie>)
    fun onRowClick(movie: Movie)
}

interface MoviesListener {
    fun onRowClick(movie: Movie)
}