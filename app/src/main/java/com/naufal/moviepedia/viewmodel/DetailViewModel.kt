package com.naufal.moviepedia.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.naufal.moviepedia.model.DetailTVResponse
import com.naufal.moviepedia.model.MovieEntity
import com.naufal.moviepedia.repository.Repository
import com.naufal.moviepedia.vo.Resource

class DetailViewModel(private val detailRepository: Repository) : ViewModel() {

    private var movieId : Int = 0
    private var tvId : Int = 0

    fun setSelectedMovie(movieId: Int){
        this.movieId = movieId
    }

    fun setSelectedTV(tvId: Int){
        this.tvId = tvId
    }

    fun getDetailMovie(context: Context?) : LiveData<Resource<MovieEntity?>> = detailRepository.getOneMovie(movieId, context)

    fun getDetailShow(context: Context?): LiveData<DetailTVResponse?> = detailRepository.getOneTV(tvId, context)

    fun setFavoriteMovies(movieItems: MovieEntity, state: Boolean){
        detailRepository.setFavoriteMovies(movieItems, state)
    }
    fun getFavoriteMovies(context: Context?) : LiveData<List<MovieEntity?>?> = detailRepository.getFavoriteMovies(context)


}