package com.naufal.moviepedia.viewmodel

import androidx.lifecycle.ViewModel
import com.naufal.moviepedia.data.MovieData
import com.naufal.moviepedia.data.TVData
import com.naufal.moviepedia.model.Movie
import com.naufal.moviepedia.model.TV

class DetailViewModel : ViewModel() {

    private lateinit var movieId : String
    private lateinit var tvId : String

    fun setSelectedMovie(movieId : String){
        this.movieId = movieId
    }

    fun setSelectedTV(tvId : String){
        this.tvId = tvId
    }

    fun getMovie() : Movie {
        return MovieData.getDataMovies().first{ it.id == movieId}
    }

    fun getTV() : TV {
        lateinit var tv : TV

        for (tvEntity in TVData.getDataTV()){
            if (tvEntity.id == this.tvId){
                tv = tvEntity
            }
        }
        return tv
    }

}