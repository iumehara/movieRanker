package io.umehara.movieranker.list

import io.umehara.movieranker.list.ListType.WISHLIST
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.postgresql.ds.PGSimpleDataSource
import org.springframework.jdbc.core.JdbcTemplate

class DatabaseListRepoTest {
    private lateinit var databaseListRepo: DatabaseListRepo

    @Before
    fun setUp() {
        val dataSource = PGSimpleDataSource()
        dataSource.setURL("jdbc:postgresql://localhost/movie_ranker_test")
        val jdbcTemplate = JdbcTemplate(dataSource)
        jdbcTemplate.update("TRUNCATE wishlists RESTART IDENTITY")

        val seedMovieList = listOf(
                MovieList(1, 2, emptyList()),
                MovieList(2, 15, emptyList()),
                MovieList(3, 6, emptyList()),
                MovieList(4, 12, emptyList())
        )

        var sql = "INSERT INTO wishlists (user_id) VALUES "
        seedMovieList.forEachIndexed { index, movieList ->
            var additionalMovieString = "(${movieList.userId})"

            if (index != seedMovieList.size - 1) {
                additionalMovieString += ", "
            }
            sql += additionalMovieString
        }

        jdbcTemplate.execute(sql)

        databaseListRepo = DatabaseListRepo(jdbcTemplate)
    }

    @Test
    fun get_returnsMovieListFromDB() {
        val movieList = databaseListRepo.get(15, WISHLIST)

        assertThat(movieList).isNotNull
    }

    @Test
    fun update_updatesMovieList() {
        val initialMovieList = databaseListRepo.get(15, WISHLIST)
        assertThat(initialMovieList.movieIds).isEqualTo(emptyList<Number>())

        databaseListRepo.update(15, WISHLIST, listOf(3L, 4L, 6L))

        val updatedMovieList = databaseListRepo.get(15, WISHLIST)
        assertThat(updatedMovieList.movieIds).isEqualTo(listOf(3L, 4L, 6L))
    }
}