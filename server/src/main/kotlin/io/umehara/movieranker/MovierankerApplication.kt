package io.umehara.movieranker

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MovierankerApplication

fun main(args: Array<String>) {
    runApplication<MovierankerApplication>(*args)
}
