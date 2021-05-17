package com.naufal.moviepedia.source

import android.content.Context
import androidx.lifecycle.LiveData
import com.naufal.moviepedia.model.*
import com.naufal.moviepedia.vo.Resource

interface AppSource {

    fun getAllMovies(context: Context?) : LiveData<Resource<List<MovieEntity>?>>
    fun getAllTV(context: Context?) : LiveData<ArrayList<TVItems?>?>
    fun getOneMovie(id: Int?, context: Context?) : LiveData<MovieEntity?>
    fun getOneTV(id: Int?, context: Context?) : LiveData<DetailTVResponse?>
    fun getFavoriteMovies(context: Context?) : LiveData<List<MovieEntity?>?>
    fun getFavoriteTV(context: Context?) : LiveData<List<TVItems?>?>
    fun setFavoriteMovies(movieItems: MovieEntity, state: Boolean)
}