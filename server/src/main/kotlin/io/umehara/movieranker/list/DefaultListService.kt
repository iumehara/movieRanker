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

    override fun add(userId: Number, type: ListType, movieId: Number) {
        val wishList: MovieList = listRepo.get(userId, type)
        val movieIds = wishList.movieIds.toMutableList()
        movieIds.add(movieId)

        listRepo.update(userId, type, movieIds)
    }

    override fun remove(userId: Number, type: ListType, movieId: Number) {
        val wishList: MovieList = listRepo.get(userId, type)
        val movieIds = wishList.movieIds.toMutableList()
        movieIds.remove(movieId)

        listRepo.update(userId, type, movieIds)
    }
}
