package io.umehara.movieranker

import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.postgresql.ds.PGSimpleDataSource
import org.springframework.jdbc.core.JdbcTemplate

class DatabaseMovieRepoTest {
    private lateinit var databaseMovieRepo: DatabaseMovieRepo

    @Before
    fun setUp() {
        val dataSource = PGSimpleDataSource()
        dataSource.setURL("jdbc:postgresql://localhost/movie_ranker_test")
        val jdbcTemplate = JdbcTemplate(dataSource)
        jdbcTemplate.update("TRUNCATE movies RESTART IDENTITY")

        val seedMovies = listOf(
                Movie(1, "The Godfather"),
                Movie(2, "The Wizard of Oz"),
                Movie(3, "The Sound of Music"),
                Movie(4, "Get Out"),
                Movie(5, "Django Unchained")
        )

        var sql = "INSERT INTO movies (name) VALUES "
        seedMovies.forEachIndexed { index, movie ->
            var additionalMovieString = "('$movie.name')"
            if (index != seedMovies.size - 1) {
                additionalMovieString += ", "
            }
            sql += additionalMovieString
        }

        jdbcTemplate.execute(sql)

        databaseMovieRepo = DatabaseMovieRepo(jdbcTemplate)
    }

    @Test
    fun getAll_returnsMoviesFromDB() {
        val movies = databaseMovieRepo.getAll()

        assertThat(movies.size).isEqualTo(5)
    }
}