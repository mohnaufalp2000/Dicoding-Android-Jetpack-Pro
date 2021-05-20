package com.naufal.moviepedia.source

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.naufal.moviepedia.model.*
import com.naufal.moviepedia.vo.Resource
import retrofit2.Response

interface AppSource {

    fun getAllMovies(context: Context?) : LiveData<Resource<PagedList<MovieEntity>>>
    fun getAllTV(context: Context?) : LiveData<Resource<PagedList<TVEntity>>>
    fun getOneMovie(id: Int?, context: Context?) : LiveData<Resource<MovieEntity>>
    fun getOneTV(id: Int?, context: Context?) : LiveData<Resource<TVEntity>>
    fun getFavoriteMovies(context: Context?) : LiveData<PagedList<MovieEntity>>
    fun getFavoriteTV(context: Context?) : LiveData<PagedList<TVEntity>>
    fun setFavoriteMovies(movieItems: MovieEntity, state: Boolean)
    fun setFavoriteTV(tvItems: TVEntity, state: Boolean)
}