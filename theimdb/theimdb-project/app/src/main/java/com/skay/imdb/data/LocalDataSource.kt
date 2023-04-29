package com.skay.imdb.data

import com.skay.imdb.BaseApplication
import com.skay.imdb.data.model.Movie
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream

class LocalDataSource {
    private var _movies = mutableListOf<Movie>()
    val movies: List<Movie>
        get() = _movies

    init {
        extractMovies()
    }

    private fun extractMovies() {
        val text = loadFromFile()
        parseMovies(text)
    }

    private fun parseMovies(text: String) {
        val json = JSONObject(text)
        val results = json.optJSONArray("results")

        _movies = mutableListOf<Movie>()
        results?.let {
            0.until(it.length()).onEach { i ->
                it.optJSONObject(i)?.let { obj ->
                    _movies.add(
                        Movie(
                            name = obj.optString("title"),
                            description = obj.optString("overview"),
                            imageUrl = BASE_PATH.plus(obj.optString("poster_path")),
                            releaseDate = obj.optString("release_date"),
                            rating = obj.optDouble("vote_average"),
                            popularity = obj.optDouble("popularity")
                        )
                    )
                }
            }
        }
    }

    private fun loadFromFile(): String {
        var text = ""
        val context = BaseApplication.context
        try {
            val inputStream: InputStream = context.resources.assets.open("movies_file.json")

            val size: Int = inputStream.available()
            val buffer = ByteArray(size)

            inputStream.read(buffer)
            text = String(buffer)
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return text
    }

    companion object {
        private const val BASE_PATH = "https://image.tmdb.org/t/p/w500"
    }
}

fun main() {
    LocalDataSource()
}