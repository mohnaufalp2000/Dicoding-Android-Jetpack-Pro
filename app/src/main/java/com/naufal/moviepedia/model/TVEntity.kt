package com.naufal.moviepedia.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "tv")
data class TVEntity(
    @ColumnInfo(name ="first_air_date")
    var firstAirDate: String? = null,

    @ColumnInfo(name = "overview")
    var overview: String? = null,

    @ColumnInfo(name = "original_language")
    var originalLanguage: String? = null,

    @field:SerializedName("genre_ids")
    var genreIds: List<Int?>? = null,

    @ColumnInfo(name ="poster_path")
    var posterPath: String? = null,

    @ColumnInfo(name = "voteAverage")
    var voteAverage: Double? = null,

    @ColumnInfo(name = "name")
    var name: String? = null,

    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: Int? = null,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean? = false

)