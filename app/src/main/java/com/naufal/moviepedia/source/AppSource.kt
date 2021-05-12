package com.naufal.moviepedia.source

import android.content.Context
import androidx.lifecycle.LiveData
import com.naufal.moviepedia.model.DetailMovieResponse
import com.naufal.moviepedia.model.DetailTVResponse
import com.naufal.moviepedia.model.MovieItems
import com.naufal.moviepedia.model.TVItems

interface AppSource {

    fun getAllMovies(context: Context?) : LiveData<ArrayList<MovieItems?>?>
    fun getAllTV(context: Context?) : LiveData<ArrayList<TVItems?>?>
    fun getOneMovie(id: Int?, context: Context?) : LiveData<DetailMovieResponse?>
    fun getOneTV(id: Int?, context: Context?) : LiveData<DetailTVResponse?>

}