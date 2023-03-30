package com.skay.imdb.ui.contract

import com.skay.imdb.data.model.Movie

interface MoviesListener {
    fun onRowClick(movie: Movie)
}