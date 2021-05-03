package com.naufal.moviepedia.viewmodel

import androidx.lifecycle.ViewModel
import com.naufal.moviepedia.data.MovieData
import com.naufal.moviepedia.model.Movie

class MovieViewModel : ViewModel() {

    fun getMovies() : List<Movie> = MovieData.getDataMovies()

}