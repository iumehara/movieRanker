package io.umehara.movieranker

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("movies")
class MoviesController(val movieRepo: MovieRepo) {

    @GetMapping
    fun getAll(): List<Movie> {
        return movieRepo.getAll()
    }
}
