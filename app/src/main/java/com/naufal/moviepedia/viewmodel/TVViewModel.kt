package com.naufal.moviepedia.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.naufal.moviepedia.model.ShowItems
import com.naufal.moviepedia.model.ShowResponse
import com.naufal.moviepedia.network.ConfigNetwork
import com.naufal.moviepedia.repository.Repository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TVViewModel(private val showRepository: Repository) : ViewModel() {

    fun getShows() : LiveData<ArrayList<ShowItems?>?> = showRepository.getAllShows()

}