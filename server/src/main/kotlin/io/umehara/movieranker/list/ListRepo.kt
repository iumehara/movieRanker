package io.umehara.movieranker.list

interface ListRepo {
    fun get(userId: Number, type: ListType): MovieList
}
