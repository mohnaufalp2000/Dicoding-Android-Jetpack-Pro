package com.naufal.moviepedia.local

import androidx.lifecycle.LiveData
import com.naufal.moviepedia.database.MovieDao
import com.naufal.moviepedia.model.DetailMovieResponse
import com.naufal.moviepedia.model.MovieEntity
import com.naufal.moviepedia.model.MovieItems

class MovieLocalDataSource(private val mMovieDao: MovieDao) {

    companion object{
        private var INSTANCE : MovieLocalDataSource? = null

        fun getInstance(movieDao: MovieDao) : MovieLocalDataSource =
            INSTANCE ?: MovieLocalDataSource(movieDao)
    }

    fun getAllMovies(): LiveData<List<MovieEntity>> = mMovieDao.getMovies()

    fun getOneMovies(id: Int?) : LiveData<MovieEntity> =
        mMovieDao.getOneMovies(id)

    fun getFavoriteMovies(): LiveData<List<MovieEntity?>?> = mMovieDao.getFavoriteMovies()

    fun addMovies(movieItems: List<MovieEntity>) = mMovieDao.addMovies(movieItems)
    
    fun updateMovies(movieItems: MovieEntity){
        mMovieDao.updateMovies(movieItems)
    }

    fun setFavoriteMovie(movieItems: MovieEntity, newState: Boolean){
        movieItems.isFavorite = newState
        mMovieDao.updateMovies(movieItems)
    }

}