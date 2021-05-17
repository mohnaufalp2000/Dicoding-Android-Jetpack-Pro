package com.naufal.moviepedia.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class MovieResponse(

	@field:SerializedName("dates")
	var dates: Dates? = null,

	@field:SerializedName("page")
	var page: Int? = null,

	@field:SerializedName("total_pages")
	var totalPages: Int? = null,

	@field:SerializedName("results")
	var results: ArrayList<MovieItems?>? = null,

	@field:SerializedName("total_results")
	var totalResults: Int? = null
)

data class MovieItems(

	@field:SerializedName("original_language")
	@ColumnInfo(name = "originalLanguage")
	var originalLanguage: String? = null,

	@field:SerializedName("title")
	@ColumnInfo(name = "title")
	var title: String? = null,

	@field:SerializedName("poster_path")
	@ColumnInfo(name = "posterPath")
	var posterPath: String? = null,

	@field:SerializedName("release_date")
	@ColumnInfo(name = "releaseDate")
	var releaseDate: String? = null,

	@field:SerializedName("vote_average")
	@ColumnInfo(name = "voteAverage")
	var voteAverage: Double? = null,

	@field:SerializedName("id")
	@PrimaryKey
	@ColumnInfo(name = "id")
	var id: Int? = null,

	@ColumnInfo(name = "date")
	var date: String? = null,

	@ColumnInfo(name = "isFavorite")
	var isFavorite: Boolean? = false
)

data class Dates(

	@field:SerializedName("maximum")
	var maximum: String? = null,

	@field:SerializedName("minimum")
	var minimum: String? = null
)
