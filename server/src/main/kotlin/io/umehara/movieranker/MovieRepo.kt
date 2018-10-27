package io.umehara.movieranker

interface MovieRepo {
    fun getAll(): List<Movie>
    fun getWhere(movieIds: List<Number>): List<Movie>
}
