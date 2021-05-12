package com.naufal.moviepedia.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.naufal.moviepedia.model.MovieItems
import com.naufal.moviepedia.repository.Repository

class MovieViewModel(private val movieRepository: Repository) : ViewModel() {

    fun getMovies(context: Context?) : LiveData<ArrayList<MovieItems?>?> = movieRepository.getAllMovies(context)

}