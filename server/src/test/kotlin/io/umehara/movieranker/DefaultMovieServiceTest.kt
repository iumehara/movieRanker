package io.umehara.movieranker

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class DefaultMovieServiceTest {
    @Test
    fun getAllReturnsMovies() {
        val movieRepo = StubMovieRepo()
        val defaultMovieService = DefaultMovieService(movieRepo)

        val movies = defaultMovieService.getAll()

        assertThat(movies.size).isEqualTo(6)
        assertThat(movies[0].id).isEqualTo(1)
        assertThat(movies[0].name).isEqualTo("The Godfather")
    }
}