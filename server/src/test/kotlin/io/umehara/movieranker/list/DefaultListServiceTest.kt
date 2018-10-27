package io.umehara.movieranker.list

import io.umehara.movieranker.StubMovieRepo
import io.umehara.movieranker.list.ListType.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class DefaultListServiceTest {
    private lateinit var movieRepo: StubMovieRepo
    private lateinit var listRepo: SpyListRepo
    private lateinit var defaultMovieService: DefaultListService

    @Before
    fun setUp() {
        movieRepo = StubMovieRepo()
        listRepo = SpyListRepo()
        defaultMovieService = DefaultListService(movieRepo, listRepo)
    }

    @Test
    fun get_callsReposWithCorrectArguments() {
        listRepo.getReturnValue = MovieList(5, 8, listOf(12, 14))

        defaultMovieService.get(8, WISHLIST)

        assertThat(listRepo.getArgUserId).isEqualTo(8)
        assertThat(listRepo.getArgType).isEqualTo(WISHLIST)
        assertThat(movieRepo.getWhereArgMovieIds).isEqualTo(listOf(12, 14))
    }

    @Test
    fun get_returnsMovies() {
        val movies = defaultMovieService.get(2, WISHLIST)

        assertThat(movies.size).isEqualTo(3)
        assertThat(movies[0].id).isEqualTo(2)
        assertThat(movies[0].name).isEqualTo("The Wizard of Oz")
    }
}