package io.umehara.movieranker.list

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
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

    override fun update(userId: Number, type: ListType, movieIds: List<Number>) {
        val sqlString = "UPDATE wishlists " +
                "SET movie_ids=:movie_ids " +
                "WHERE user_id=:user_id"

        val parameterSource = MapSqlParameterSource()
        val movieIdsArray = kotlinListToSqlArray(movieIds.map(Number::toLong))
        parameterSource.addValue("movie_ids", movieIdsArray)
        parameterSource.addValue("user_id", userId)

        val namedParameterJdbcTemplate = NamedParameterJdbcTemplate(jdbcTemplate)
        namedParameterJdbcTemplate.update(sqlString, parameterSource)
    }

    private fun movieListRowMapper(rs: ResultSet): MovieList {
        return MovieList(
                rs.getLong("id"),
                rs.getLong("user_id"),
                sqlArrayToKotlinList(rs.getArray("movie_ids"))
        )
    }

    private fun kotlinListToSqlArray(kotlinList: List<Long>): java.sql.Array? {
        val kotlinArray = kotlinList.toTypedArray()
        return jdbcTemplate.dataSource?.connection?.createArrayOf("INT", kotlinArray)
    }

    private fun sqlArrayToKotlinList(sqlArray: java.sql.Array): List<Long> {
        val kotlinArray =  sqlArray.array as Array<*>
        val kotlinList = Arrays.asList(*kotlinArray)
        return kotlinList.filterIsInstance<Long>()
    }
}
