package io.umehara.movieranker.list

import io.umehara.movieranker.list.ListType.*
import org.assertj.core.api.Assertions.assertThat
import org.hamcrest.CoreMatchers.equalTo
import org.junit.Test
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup

class ListControllerTest {
    @Test
    fun get_returnMovies() {
        val listService = StubListService()
        val listController = ListController(listService)
        val mockController = standaloneSetup(listController).build()

        mockController.perform(get("/wishlists/1"))
                .andExpect(jsonPath("$[0].id", equalTo(1)))
                .andExpect(jsonPath("$[0].name", equalTo("The Godfather")))

    }

    @Test
    fun add_callsRepoWithCorrectArguments() {
        val listService = SpyListService()
        val listController = ListController(listService)
        val mockController = standaloneSetup(listController).build()

        mockController.perform(put("/wishlists/1/movies/12"))

        assertThat(listService.updateArgUserId).isEqualTo(1)
        assertThat(listService.updateArgType).isEqualTo(WISHLIST)
        assertThat(listService.updateArgMovieId).isEqualTo(12)
    }
}
