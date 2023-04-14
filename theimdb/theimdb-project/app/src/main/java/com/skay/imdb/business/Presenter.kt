package com.skay.imdb.business

import com.skay.imdb.common.DependencyContainer
import com.skay.imdb.data.remote.toUiMovie
import com.skay.imdb.ui.contract.IView

interface Presenter {
    fun loadMovies()
    fun clear()
}

class PresenterImpl(var view: IView?) : Presenter {

    override fun loadMovies() {
        DependencyContainer.moviesRepository.fetchMovies {
            view?.updateView(it.map { item -> item.toUiMovie() })
        }
    }

    override fun clear() {
        view = null
    }

}