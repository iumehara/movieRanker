package io.umehara.movieranker.list

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository
import java.sql.ResultSet
import java.util.*
import javax.xml.ws.http.HTTPException

@Repository
class DatabaseListRepo(val jdbcTemplate: JdbcTemplate) : ListRepo {
    override fun get(userId: Number, type: ListType): MovieList {
        val sqlString = "SELECT * FROM wishlists WHERE user_id = ?"

        val movieList = jdbcTemplate.queryForObject(
                sqlString,
                { rs, _ -> movieListRowMapper(rs) },
                arrayOf(userId)
        )

        return movieList ?: throw HTTPException(400)
    }

    private fun movieListRowMapper(rs: ResultSet): MovieList {
        return MovieList(
                rs.getLong("id"),
                rs.getLong("user_id"),
                sqlArrayToKotlinList(rs.getArray("movie_ids"))
        )
    }

    private fun sqlArrayToKotlinList(sqlArray: java.sql.Array): List<Long> {
        val kotlinArray =  sqlArray.array as Array<*>
        val kotlinList = Arrays.asList(*kotlinArray)
        return kotlinList.filterIsInstance<Long>()
    }
}
