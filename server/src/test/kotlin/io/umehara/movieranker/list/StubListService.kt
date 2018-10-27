package io.umehara.movieranker.list

import io.umehara.movieranker.Movie

class StubListService: ListService {
    override fun get(userId: Number, type: ListType): List<Movie> {
        return listOf(
                Movie(1, "The Godfather"),
                Movie(3, "The Sound of Music"),
                Movie(5, "Django Unchained")
        )
    }
}
