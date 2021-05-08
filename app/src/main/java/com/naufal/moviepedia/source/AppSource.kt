package com.naufal.moviepedia.source

import androidx.lifecycle.LiveData
import com.naufal.moviepedia.model.DetailMovieResponse
import com.naufal.moviepedia.model.DetailTVResponse
import com.naufal.moviepedia.model.MovieItems
import com.naufal.moviepedia.model.TVItems

interface AppSource {

    fun getAllMovies() : LiveData<ArrayList<MovieItems?>?>
    fun getAllTV() : LiveData<ArrayList<TVItems?>?>
    fun getOneMovie(id: Int) : LiveData<DetailMovieResponse?>
    fun getOneTV(id: Int) : LiveData<DetailTVResponse?>

}