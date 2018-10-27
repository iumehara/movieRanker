package io.umehara.movieranker

class StubMovieRepo : MovieRepo {
    private val movies = listOf(
            Movie(1, "The Godfather"),
            Movie(2, "The Wizard of Oz"),
            Movie(3, "The Sound of Music"),
            Movie(4, "Get Out"),
            Movie(5, "Django Unchained"),
            Movie(6, "Ratatouille")
    )

    override fun getAll(): List<Movie> {
        return movies
    }

    var getWhereArgMovieIds: List<Number>? = null
    override fun getWhere(movieIds: List<Number>): List<Movie> {
        getWhereArgMovieIds = movieIds
        return movies.filter { movie -> movieIds.contains(movie.id) }
    }
}
