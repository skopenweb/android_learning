package com.skay.imdb.data

import com.skay.imdb.data.model.Movie

class InMemoryDataSource() {
    fun getMovies(): List<Movie> {
        return listOf(
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
            ),
            Movie(
                name = "The Shawshank Redemption",
                description = "Andy Dufresne, a successful banker, is arrested for the murders of his wife and her lover, and is sentenced to life imprisonment at the Shawshank prison. He becomes the most unconventional prisoner.",
                imageUrl = "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcTvYzmCt0-qgc4Yc1AgkRw9_ONiZ5RX1sg53__YVoLs28rfR8M-",
                releaseDate = "30 March, 2023",
                rating = 9.5,
                popularity = 33_454_54.9
            ),
            Movie(
                name = "Pulp Fiction",
                description = "In the realm of underworld, a series of incidents intertwines the lives of two Los Angeles mobsters, a gangster's wife, a boxer and two small-time criminals.",
                imageUrl = "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcTViAjqYaPH8rSNheAqd11PhVY9p7Ty7BrlSzmXfk5rBD3w8q3m",
                releaseDate = "14 October 1994",
                rating = 9.8,
                popularity = 44_454_54.9
            ),
            Movie(
                name = "Schindler's List",
                description = "Oskar Schindler, a German industrialist and member of the Nazi party, tries to save his Jewish employees after witnessing the persecution of Jews in Poland.",
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQBoUo0lPtAJiO0RyEb_C44usrfMq4VhNN_L8zk_wtd8QQuZzSh",
                releaseDate = "30 March, 2023",
                rating = 9.2,
                popularity = 55_223_54.9
            ),
            Movie(
                name = "Stoker",
                description = "After the untimely death of her father, India and her mother are left alone in their estate. Soon, the arrival of her uncle Charlie, who she never knew existed, is followed by unexpected developments.",
                imageUrl = "https://m.media-amazon.com/images/M/MV5BMjI3MTM5ODI5MV5BMl5BanBnXkFtZTcwMjE1Mzc4OA@@._V1_.jpg",
                releaseDate = "28 February 2013",
                rating = 8.2,
                popularity = 66_223_54.9
            )
        )
    }
}