package com.naufal.moviepedia.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class DetailTVResp (
    val id: Int? = 0,
    val title: String? = "",
    val posterPath: String? = "",
    val rate: Double? = 0.0,
    val language: String? = "",
    val overview: String? = "",
    val released: String? = null,
    val runtime: @RawValue ArrayList<Int?>? = arrayListOf(),
    val genres: @RawValue ArrayList<TVGenreResp>? = arrayListOf()
) : Parcelable

@Parcelize
data class TVGenreResp(
    val id: Int? = 0,
    val name: String? = ""
) : Parcelable