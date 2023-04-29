package com.skay.imdb.data.remote

import com.skay.imdb.common.DependencyContainer

object ApiClient {
    fun getService(): MovieApiInterface {
        val retrofit = DependencyContainer.getRetrofitClient()
        return retrofit.create(MovieApiInterface::class.java)
    }
}