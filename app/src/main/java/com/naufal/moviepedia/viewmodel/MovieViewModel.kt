package com.naufal.moviepedia.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.naufal.moviepedia.model.MovieEntity
import com.naufal.moviepedia.repository.Repository
import com.naufal.moviepedia.vo.Resource

class MovieViewModel(private val movieRepository: Repository) : ViewModel() {

    fun getMovies(context: Context?) : LiveData<Resource<PagedList<MovieEntity>>> = movieRepository.getAllMovies(context)

}