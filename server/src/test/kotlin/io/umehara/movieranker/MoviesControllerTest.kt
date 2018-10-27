package io.umehara.movieranker

import org.hamcrest.CoreMatchers.equalTo
import org.junit.Test
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup

class MoviesControllerTest {
    @Test
    fun getAllReturnsMovies() {
        val movieService = StubMovieService()
        val moviesController = MoviesController(movieService)
        val mockController = standaloneSetup(moviesController).build()

        mockController.perform(get("/movies"))
                .andExpect(jsonPath("$[0].id", equalTo(1)))
    }
}