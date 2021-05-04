package com.naufal.moviepedia.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.naufal.moviepedia.model.MovieResponse
import com.naufal.moviepedia.model.MovieItems
import com.naufal.moviepedia.network.ConfigNetwork
import com.naufal.moviepedia.repository.Repository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieViewModel(private val movieRepository: Repository) : ViewModel() {

    fun getMovies() : LiveData<ArrayList<MovieItems?>?> = movieRepository.getAllMovies()

}