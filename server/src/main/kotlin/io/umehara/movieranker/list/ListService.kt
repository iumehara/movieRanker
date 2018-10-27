package io.umehara.movieranker.list

import io.umehara.movieranker.Movie

interface ListService {
    fun get(userId: Number, type: ListType): List<Movie>
}
