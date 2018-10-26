package io.umehara.movieranker

class StubMovieRepo: MovieRepo {
    override fun getAll(): List<Movie> {
        return listOf(
                Movie(1, "The Godfather"),
                Movie(2, "The Wizard of Oz"),
                Movie(3, "The Sound of Music"),
                Movie(4, "Get Out"),
                Movie(5, "Django Unchained")
        )
    }
}