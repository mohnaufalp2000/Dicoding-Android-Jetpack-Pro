package com.naufal.moviepedia.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.naufal.moviepedia.model.*
import com.naufal.moviepedia.remote.RemoteDataSource
import com.naufal.moviepedia.response.MovieResp
import com.naufal.moviepedia.response.TVResp
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
    override fun getAllTV(): LiveData<ArrayList<TVItems?>?> = remoteDataSource.getTV()
    override fun getOneMovie(id: Int): LiveData<DetailMovieResponse?> {
        val detailMovieResults = MutableLiveData<DetailMovieResponse>()

        remoteDataSource.getDetailMovie(id, object : RemoteDataSource.LoadDetailMovieCallback{
            override fun onDetailMovieReceived(movieResp: MovieResp) {
                val detailMovieResponse = DetailMovieResponse(
                    id = movieResp.id,
                    title = movieResp.title,
                    posterPath = movieResp.posterPath,
                    voteAverage = movieResp.rate,
                    originalLanguage = movieResp.language,
                    overview = movieResp.overview
                )

                detailMovieResults.postValue(detailMovieResponse)
            }
        })
        return detailMovieResults
    }
    override fun getOneTV(id: Int): LiveData<DetailTVResponse?> {
        val detailTVResults = MutableLiveData<DetailTVResponse>()

        remoteDataSource.getDetailTV(id, object : RemoteDataSource.LoadDetailTVCallback{
            override fun onDetailTVReceived(tvResp: TVResp) {
                val detailTVResponse = DetailTVResponse(
                    id = tvResp.id,
                    name = tvResp.title,
                    posterPath = tvResp.posterPath,
                    voteAverage = tvResp.rate,
                    originalLanguage = tvResp.language,
                    overview = tvResp.overview
                )

                detailTVResults.postValue(detailTVResponse)
            }


        })
        return detailTVResults
    }


}