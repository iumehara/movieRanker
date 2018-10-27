package io.umehara.movieranker.list

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
                MovieList(1, 2, listOf(1, 5, 8)),
                MovieList(2, 15, listOf(3, 3, 6)),
                MovieList(3, 6, listOf(1, 8)),
                MovieList(4, 12, listOf(12, 13))
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
        val movieList = databaseListRepo.get(15, ListType.WISHLIST)

        assertThat(movieList).isNotNull
    }
}