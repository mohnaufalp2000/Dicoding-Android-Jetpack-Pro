package com.naufal.moviepedia.response

data class MovieResp(
    val id: Int? = 0,
    val title: String? = "",
    val posterPath: String? = "",
    val rate: Double? = 0.0,
    val language: String? = ""
)