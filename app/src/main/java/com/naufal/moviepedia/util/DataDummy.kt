package com.naufal.moviepedia.util

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.naufal.moviepedia.model.DetailMovieResponse
import com.naufal.moviepedia.model.MovieItems
import com.naufal.moviepedia.model.TVItems
import com.naufal.moviepedia.response.DetailMovieResp
import com.naufal.moviepedia.response.MovieResp
import com.naufal.moviepedia.response.TVResp

object DataDummy {

    fun getDataMovies() : ArrayList<MovieItems?> {

        val movies = ArrayList<MovieItems?>()

        movies.apply {
            add(
                MovieItems(
                    id = 1,
                    title = "Aquaman",
                    posterPath = "Aquaman.jpg",
                    originalLanguage = "en",
                    voteAverage = 9.0
                )
            )
        }

        return movies
    }

    fun getRemoteDataMovies() : ArrayList<MovieResp> {

        val movies = ArrayList<MovieResp>()

        movies.apply {
            add(
                MovieResp(
                    id = 1,
                    title = "Aquaman"
                )
            )
        }

        return movies
    }

    fun getDataTV() : ArrayList<TVItems?> {

        val tv = ArrayList<TVItems?>()

        tv.apply {
            add(
                TVItems(
                    id = 1,
                    name = "Aquaman",
                    posterPath = "Aquaman.jpg",
                    originalLanguage = "en",
                    voteAverage = 9.0
                )
            )
        }

        return tv
    }

    fun getRemoteDataTV() : ArrayList<TVResp> {

        val tv = ArrayList<TVResp>()

        tv.apply {
            add(
                TVResp(
                    id = 1,
                    title = "The Flash"
                )
            )
        }

        return tv
    }

}