package com.naufal.moviepedia.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class TVResp(
    val id: Int? = 0,
    val title: String? = "",
    val posterPath: String? = "",
    val rate: Double? = 0.0,
    val language: String? = ""
) : Parcelable