package io.umehara.movieranker

interface MovieRepo {
    fun getAll(): List<Movie>
}
