package com.naufal.moviepedia.source

import android.content.Context
import androidx.lifecycle.LiveData
import com.naufal.moviepedia.model.*
import com.naufal.moviepedia.vo.Resource
import retrofit2.Response

interface AppSource {

    fun getAllMovies(context: Context?) : LiveData<Resource<List<MovieEntity>?>>
    fun getAllTV(context: Context?) : LiveData<Resource<List<TVEntity>?>>
    fun getOneMovie(id: Int?, context: Context?) : LiveData<Resource<MovieEntity?>>
    fun getOneTV(id: Int?, context: Context?) : LiveData<Resource<TVEntity?>>
    fun getFavoriteMovies(context: Context?) : LiveData<List<MovieEntity?>?>
    fun getFavoriteTV(context: Context?) : LiveData<List<TVEntity?>?>
    fun setFavoriteMovies(movieItems: MovieEntity, state: Boolean)
    fun setFavoriteTV(tvItems: TVEntity, state: Boolean)
}