package com.skay.imdb.common

import android.content.Context
import android.widget.Toast
import com.skay.imdb.data.model.Movie
import java.util.*
import kotlin.random.Random

fun Context.toast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}

fun randomAlphaString(length: Int): String {
    val allChars = ('a'..'z') + ('A'..'Z') + ('0'..'9') + " "
    return (1..length).map { allChars[Random.nextInt(allChars.size)] }.joinToString("")
}

fun randomNumberString(length: Int): String {
    val allNums = ('0'..'9').toList()
    return (1..length).map { allNums[Random.nextInt(allNums.size)] }.joinToString("")
}

fun randomMovie() = Movie(
    name = randomAlphaString(6),
    description = randomAlphaString(50),
    imageUrl = "https://cdn.sstatic.net/Img/home/illo-public.svg?v=14bd5a506009",
    releaseDate = Date(),
    rating = Random.nextDouble(10.0),
    popularity = Random.nextDouble(50_000.0)
)

fun main() {
    print(randomAlphaString(20))
}