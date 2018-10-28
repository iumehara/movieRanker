package io.umehara.movieranker.list

import io.umehara.movieranker.Movie
import io.umehara.movieranker.list.ListType.*
import org.springframework.web.bind.annotation.*

@RestController
class ListController(val listService: ListService) {

    @GetMapping("wishlists/{userId}")
    fun get(@PathVariable userId: Int): List<Movie> {
        return listService.get(userId, WISHLIST)
    }

    @PutMapping("wishlists/{userId}/movies/{movieId}")
    fun add(@PathVariable userId: Int, @PathVariable movieId: Int) {
        return listService.add(userId, WISHLIST, movieId)
    }
}