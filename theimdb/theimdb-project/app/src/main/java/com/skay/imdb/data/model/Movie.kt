package com.skay.imdb.data.model

import java.util.*
import com.skay.imdb.common.randomAlphaString as rnd
import kotlin.random.Random

data class Movie(
    val name: String,
    val description: String,
    val imageUrl: String,
    val releaseDate: Date,
    val rating: Double,
    val popularity: Double
)