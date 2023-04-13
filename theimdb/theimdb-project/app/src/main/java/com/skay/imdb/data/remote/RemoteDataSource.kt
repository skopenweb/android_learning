package com.skay.imdb.data.remote

import android.util.Log
import com.skay.imdb.common.Constants
import com.skay.imdb.data.model.Movie
import retrofit2.Response
import retrofit2.http.Headers
import java.util.concurrent.Executors

class RemoteDataSource {

    private val threadpool = Executors.newFixedThreadPool(2)

    @Headers("api_key: 469da739633782e5e899a74a9ef36b50")
    fun fetchMovies(callback: (List<Movie>) -> Unit) {
        threadpool.execute {
            try {
                Thread.sleep(1500)
                val response: Response<RemoteDataEntity?> =
                    ApiClient.getService().getMovies(Constants.API_KEY).execute()
                Log.d(Constants.TAG, "response ${response.body()}")
                val movies = response.body()?.results ?: emptyList()
                callback(movies.map {
                    it.toUiMovie()
                })
            } catch (e: java.lang.Exception) {
                e.printStackTrace()
            }
        }
    }

    private val mockList: List<Movie> = listOf(
        Movie(
            name = "Lord of the rings",
            description = "The Lord of the Rings is a series of three epic fantasy adventure films directed by Peter Jackson, based on the novel The Lord of the Rings by J. R. R. Tolkien. The films are subtitled The Fellowship of the Ring, The Two Towers, and The Return of the King.",
            imageUrl = "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcSyhNpJyWkY1BIsQvBwKIdzq6mzWOqQtiyshuNC0Lh5FeLbcZAw",
            releaseDate = "30 March, 2023",
            rating = 8.8,
            popularity = 11_454_54.9
        ),
        Movie(
            name = "The Godfather Part",
            description = "Michael, Vito Corleone's son, attempts to expand his family's criminal empire. While he strikes a business deal with gangster Hyman Roth, he remains unaware of the lurking danger.",
            imageUrl = "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcRZ6ToTQtumClvfIsMO46QiwvAm47_ghVBSZsjrJxjjPt38gyeg",
            releaseDate = "20 December 1974",
            rating = 9.0,
            popularity = 22_454_54.9
        )
    )
}