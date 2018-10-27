package io.umehara.movieranker.list

import org.hamcrest.CoreMatchers.equalTo
import org.junit.Test
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup

class ListControllerTest {
    @Test
    fun getReturnMovies() {
        val listService = StubListService()
        val listController = ListController(listService)
        val mockController = standaloneSetup(listController).build()

        mockController.perform(get("/wishlists/1"))
                .andExpect(jsonPath("$[0].id", equalTo(1)))
                .andExpect(jsonPath("$[0].name", equalTo("The Godfather")))

    }
}