package com.naufal.moviepedia.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.naufal.moviepedia.model.DetailMovieResponse
import com.naufal.moviepedia.model.DetailTVResponse
import com.naufal.moviepedia.network.ConfigNetwork
import com.naufal.moviepedia.repository.Repository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailViewModel(private val detailRepository: Repository) : ViewModel() {

    private var movieId : Int = 0
    private var tvId : Int = 0

    fun setSelectedMovie(movieId: Int){
        this.movieId = movieId
    }

    fun setSelectedTV(tvId: Int){
        this.tvId = tvId
    }

    fun getDetailMovie() : LiveData<DetailMovieResponse?> = detailRepository.getOneMovie(movieId)

    fun getDetailShow(): LiveData<DetailTVResponse?> = detailRepository.getOneTV(tvId)

}