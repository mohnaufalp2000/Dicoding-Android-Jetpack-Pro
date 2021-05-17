package com.naufal.moviepedia.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

data class DetailMovieResponse(

	@field:SerializedName("original_language")
	var originalLanguage: String? = null,

	@field:SerializedName("imdb_id")
	var imdbId: String? = null,

	@field:SerializedName("video")
	var video: Boolean? = null,

	@field:SerializedName("title")
	var title: String? = null,

	@field:SerializedName("backdrop_path")
	var backdropPath: String? = null,

	@field:SerializedName("revenue")
	var revenue: Int? = null,

//	@field:SerializedName("genres")
//	var genres: @RawValue List<MovieGenresItem?>? = null,

	@field:SerializedName("popularity")
	var popularity: Double? = null,

	@field:SerializedName("id")
	var id: Int? = null,

	@field:SerializedName("vote_count")
	var voteCount: Int? = null,

	@field:SerializedName("budget")
	var budget: Int? = null,

	@field:SerializedName("overview")
	var overview: String? = null,

	@field:SerializedName("original_title")
	var originalTitle: String? = null,

	@field:SerializedName("runtime")
	var runtime: Int? = null,

	@field:SerializedName("poster_path")
	var posterPath: String? = null,

	@field:SerializedName("release_date")
	var releaseDate: String? = null,

	@field:SerializedName("vote_average")
	var voteAverage: Double? = null,

	@field:SerializedName("tagline")
	var tagline: String? = null,

	@field:SerializedName("adult")
	var adult: Boolean? = null,

	@field:SerializedName("homepage")
	var homepage: String? = null,

	@field:SerializedName("status")
	var status: String? = null
)

data class ProductionCompanies(

	@field:SerializedName("logo_path")
	var logoPath: String? = null,

	@field:SerializedName("name")
	var name: String? = null,

	@field:SerializedName("id")
	var id: Int? = null,

	@field:SerializedName("origin_country")
	var originCountry: String? = null
)

data class LanguagesItem(

	@field:SerializedName("name")
	var name: String? = null,

	@field:SerializedName("iso_639_1")
	var iso6391: String? = null,

	@field:SerializedName("english_name")
	var englishName: String? = null
)

data class ProductionCountriesItem(

	@field:SerializedName("iso_3166_1")
	var iso31661: String? = null,

	@field:SerializedName("name")
	var name: String? = null
)

data class MovieGenresItem(

	@field:SerializedName("name")
	var name: String? = null,

	@field:SerializedName("id")
	var id: Int? = null
)
