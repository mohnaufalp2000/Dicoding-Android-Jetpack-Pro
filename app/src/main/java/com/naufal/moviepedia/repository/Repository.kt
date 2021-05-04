package com.naufal.moviepedia.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.naufal.moviepedia.model.DetailMovieResponse
import com.naufal.moviepedia.model.DetailTVResponse
import com.naufal.moviepedia.model.MovieItems
import com.naufal.moviepedia.model.ShowItems
import com.naufal.moviepedia.remote.RemoteDataSource
import com.naufal.moviepedia.source.AppSource

class Repository(private val remoteDataSource: RemoteDataSource) : AppSource {

    companion object{
        @Volatile
        private var instance: Repository? = null

        fun getInstance(remoteData: RemoteDataSource): Repository =
            instance ?: synchronized(this) {
                instance ?: Repository(remoteData).apply { instance = this }
            }
    }

    override fun getAllMovies(): LiveData<ArrayList<MovieItems?>?> = remoteDataSource.getMovies()
    override fun getAllShows(): LiveData<ArrayList<ShowItems?>?> = remoteDataSource.getShows()
    override fun getOneMovie(id: Int): LiveData<DetailMovieResponse?> = remoteDataSource.getDetailMovie(id)
    override fun getOneShow(id: Int): LiveData<DetailTVResponse?> = remoteDataSource.getDetailShow(id)


}