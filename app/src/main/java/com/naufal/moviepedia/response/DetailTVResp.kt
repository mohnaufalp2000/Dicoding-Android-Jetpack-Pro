package com.naufal.moviepedia.response

data class DetailTVResp (
    val id: Int? = 0,
    val title: String? = "",
    val posterPath: String? = "",
    val rate: Double? = 0.0,
    val language: String? = "",
    val overview: String? = "",
    val released: String? = null,
    val runtime: Int? = 0
)

