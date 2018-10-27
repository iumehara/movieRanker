package io.umehara.movieranker

import org.springframework.stereotype.Service

@Service
class DefaultMovieService(val movieRepo: MovieRepo): MovieService {
    override fun getAll(): List<Movie> {
        return movieRepo.getAll()
    }
}
