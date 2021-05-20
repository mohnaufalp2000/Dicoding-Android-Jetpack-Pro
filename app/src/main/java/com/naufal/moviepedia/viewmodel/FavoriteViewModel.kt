package com.naufal.moviepedia.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.naufal.moviepedia.model.MovieEntity
import com.naufal.moviepedia.model.TVEntity
import com.naufal.moviepedia.repository.Repository

class FavoriteViewModel(private val favoriteRepository: Repository) : ViewModel() {

    fun getFavoriteMovies(context: Context?) : LiveData<PagedList<MovieEntity>> = favoriteRepository.getFavoriteMovies(context)

    fun getFavoriteTV(context: Context?) : LiveData<PagedList<TVEntity>> = favoriteRepository.getFavoriteTV(context)

}