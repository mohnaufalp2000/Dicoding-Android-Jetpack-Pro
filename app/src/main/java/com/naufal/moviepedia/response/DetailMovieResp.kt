package com.naufal.moviepedia.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class DetailMovieResp(
    val id: Int? = 0,
    val title: String? = "",
    val posterPath: String? = "",
    val rate: Double? = 0.0,
    val language: String? = "",
    val overview: String? = "",
    val runtime: Int? = 0,
    val release: String? = "",
    val genres: @RawValue ArrayList<MovieGenreResp>? = null
) : Parcelable

data class MovieGenreResp(
    val id: Int? = 0,
    val name: String? = ""
)
