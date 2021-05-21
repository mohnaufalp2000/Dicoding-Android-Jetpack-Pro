package com.naufal.moviepedia.model

import com.google.gson.annotations.SerializedName

data class DetailMovieResponse(

	@field:SerializedName("original_language")
	var originalLanguage: String? = null,

	@field:SerializedName("title")
	var title: String? = null,

	@field:SerializedName("id")
	var id: Int? = null,

	@field:SerializedName("overview")
	var overview: String? = null,

	@field:SerializedName("runtime")
	var runtime: Int? = null,

	@field:SerializedName("poster_path")
	var posterPath: String? = null,

	@field:SerializedName("release_date")
	var releaseDate: String? = null,

	@field:SerializedName("vote_average")
	var voteAverage: Double? = null,
)

