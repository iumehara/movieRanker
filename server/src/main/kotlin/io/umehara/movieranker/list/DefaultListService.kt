package io.umehara.movieranker.list

import io.umehara.movieranker.Movie
import io.umehara.movieranker.MovieRepo
import org.springframework.stereotype.Service

@Service
class DefaultListService(
        val movieRepo: MovieRepo,
        val listRepo: ListRepo
): ListService {
    override fun get(userId: Number, type: ListType): List<Movie> {
        val wishList: MovieList = listRepo.get(userId, type)
        return movieRepo.getWhere(wishList.movieIds)
    }
}