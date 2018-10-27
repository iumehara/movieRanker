package io.umehara.movieranker.list

class SpyListRepo : ListRepo {
    var getArgUserId: Number? = null
    var getArgType: ListType? = null
    var getReturnValue: MovieList = MovieList(12345, 2, listOf(2, 4, 6))

    override fun get(userId: Number, type: ListType): MovieList {
        getArgUserId = userId
        getArgType = type
        return getReturnValue
    }
}
