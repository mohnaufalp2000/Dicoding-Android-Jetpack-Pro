package com.naufal.moviepedia.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TV (
    val id : String = "",
    val title : String = "",
    val genre : String = "",
    val rating : Double = 0.0,
    val overview : String = "",
    val img : Int = 0,
    val released : String = "",
    val runtime : String = "",
    val language : String = ""
) : Parcelable