package com.naufal.moviepedia.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.naufal.moviepedia.model.DetailMovieResponse
import com.naufal.moviepedia.model.DetailTVResponse
import com.naufal.moviepedia.repository.Repository

class DetailViewModel(private val detailRepository: Repository) : ViewModel() {

    private var movieId : Int = 0
    private var tvId : Int = 0

    fun setSelectedMovie(movieId: Int){
        this.movieId = movieId
    }

    fun setSelectedTV(tvId: Int){
        this.tvId = tvId
    }

    fun getDetailMovie(context: Context?) : LiveData<DetailMovieResponse?> = detailRepository.getOneMovie(movieId, context)

    fun getDetailShow(context: Context?): LiveData<DetailTVResponse?> = detailRepository.getOneTV(tvId, context)

}