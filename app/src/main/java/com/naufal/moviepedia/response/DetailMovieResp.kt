package com.naufal.moviepedia.response

data class DetailMovieResp(
    val id: Int? = 0,
    val title: String? = "",
    val posterPath: String? = "",
    val rate: Double? = 0.0,
    val language: String? = "",
    val overview: String? = "",
    val runtime: Int? = 0,
    val release: String? = "",
)


