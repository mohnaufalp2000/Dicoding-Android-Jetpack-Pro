package com.naufal.moviepedia.source

import androidx.lifecycle.LiveData
import com.naufal.moviepedia.model.DetailMovieResponse
import com.naufal.moviepedia.model.DetailTVResponse
import com.naufal.moviepedia.model.MovieItems
import com.naufal.moviepedia.model.ShowItems

interface AppSource {

    fun getAllMovies() : LiveData<ArrayList<MovieItems?>?>
    fun getAllShows() : LiveData<ArrayList<ShowItems?>?>
    fun getOneMovie(id: Int) : LiveData<DetailMovieResponse?>
    fun getOneShow(id: Int) : LiveData<DetailTVResponse?>

}