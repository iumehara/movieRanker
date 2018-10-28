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

    override fun add(userId: Number, type: ListType, movieId: Number) {}

    override fun remove(userId: Number, type: ListType, movieId: Number) {}
}

class SpyListService: ListService {
    override fun get(userId: Number, type: ListType): List<Movie> {
        return emptyList()
    }

    var addArgUserId: Number? = null
    var addArgType: ListType? = null
    var addArgMovieId: Number? = null
    override fun add(userId: Number, type: ListType, movieId: Number) {
        addArgUserId = userId
        addArgType = type
        addArgMovieId = movieId
    }

    var removeArgUserId: Number? = null
    var removeArgType: ListType? = null
    var removeArgMovieId: Number? = null
    override fun remove(userId: Number, type: ListType, movieId: Number) {
        removeArgUserId = userId
        removeArgType = type
        removeArgMovieId = movieId
    }
}
