package io.umehara.movieranker.list

interface ListRepo {
    fun get(userId: Number, type: ListType): MovieList
    fun update(userId: Number, type: ListType, movieIds: List<Number>)
}
