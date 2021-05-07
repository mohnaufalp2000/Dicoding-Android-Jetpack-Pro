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

    fun getDetailMovie(id: Int) : LiveData<DetailMovieResponse?> = detailRepository.getOneMovie(id)

    fun getDetailShow(id: Int) : LiveData<DetailTVResponse?> = detailRepository.getOneTV(id)

}