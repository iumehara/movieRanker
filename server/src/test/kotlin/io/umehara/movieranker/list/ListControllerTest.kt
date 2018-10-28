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

        mockController.perform(put("/wishlists/1/add/12"))

        assertThat(listService.addArgUserId).isEqualTo(1)
        assertThat(listService.addArgType).isEqualTo(WISHLIST)
        assertThat(listService.addArgMovieId).isEqualTo(12)
    }

    @Test
    fun remove_callsRepoWithCorrectArguments() {
        val listService = SpyListService()
        val listController = ListController(listService)
        val mockController = standaloneSetup(listController).build()

        mockController.perform(put("/wishlists/1/remove/12"))

        assertThat(listService.removeArgUserId).isEqualTo(1)
        assertThat(listService.removeArgType).isEqualTo(WISHLIST)
        assertThat(listService.removeArgMovieId).isEqualTo(12)
    }
}
