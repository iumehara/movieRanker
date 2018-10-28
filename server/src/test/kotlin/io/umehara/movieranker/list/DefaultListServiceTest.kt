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

    @Test
    fun add_callsReposWithCorrectArguments() {
        listRepo.getReturnValue = MovieList(5, 8, listOf(12, 14))

        defaultMovieService.add(8, WISHLIST, 15)

        assertThat(listRepo.updateArgUserId).isEqualTo(8)
        assertThat(listRepo.updateArgType).isEqualTo(WISHLIST)
        assertThat(listRepo.updateArgMovieIds).isEqualTo(listOf(12, 14, 15))
    }

    @Test
    fun remove_callsReposWithCorrectArguments() {
        listRepo.getReturnValue = MovieList(5, 8, listOf(12, 14))

        defaultMovieService.remove(8, WISHLIST, 14)

        assertThat(listRepo.updateArgUserId).isEqualTo(8)
        assertThat(listRepo.updateArgType).isEqualTo(WISHLIST)
        assertThat(listRepo.updateArgMovieIds).isEqualTo(listOf(12))
    }
}