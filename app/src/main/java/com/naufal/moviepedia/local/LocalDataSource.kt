package com.naufal.moviepedia.local

import androidx.lifecycle.LiveData
import com.naufal.moviepedia.database.MovieDao
import com.naufal.moviepedia.database.TVDao
import com.naufal.moviepedia.model.MovieEntity
import com.naufal.moviepedia.model.TVEntity

class LocalDataSource(private val mMovieDao: MovieDao, private val mTVDao: TVDao) {

    companion object{
        private var INSTANCE : LocalDataSource? = null

        fun getInstance(movieDao: MovieDao, tvDao: TVDao) : LocalDataSource =
            INSTANCE ?: LocalDataSource(movieDao, tvDao)
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

    fun getAllTV(): LiveData<List<TVEntity>> = mTVDao.getTV()

    fun getOneTV(id: Int?) : LiveData<TVEntity> =
        mTVDao.getOneTV(id)

    fun getFavoriteTV(): LiveData<List<TVEntity?>?> = mTVDao.getFavoriteTV()

    fun addTV(tvItems: List<TVEntity>) = mTVDao.addTV(tvItems)

    fun updateTV(tvItems: TVEntity){
        mTVDao.updateTV(tvItems)
    }

    fun setFavoriteTV(tvItems: TVEntity, newState: Boolean){
        tvItems.isFavorite = newState
        mTVDao.updateTV(tvItems)
    }

}