package io.umehara.movieranker

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository
import java.sql.ResultSet

@Repository
class DatabaseMovieRepo(val jdbcTemplate: JdbcTemplate) : MovieRepo {
    override fun getAll(): List<Movie> {
        val sqlString = "SELECT * FROM movies"
        return jdbcTemplate.query(sqlString) { rs, _ ->
            movieRowMapper(rs)
        }
    }

    private fun movieRowMapper(rs: ResultSet): Movie {
        return Movie(
                rs.getLong("id"),
                rs.getString("name")
        )
    }
}