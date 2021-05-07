package com.naufal.moviepedia.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.naufal.moviepedia.model.*
import com.naufal.moviepedia.network.ConfigNetwork
import com.naufal.moviepedia.response.MovieResp
import com.naufal.moviepedia.response.TVResp
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource {

    private val movies = MutableLiveData<ArrayList<MovieItems?>?>()
    private val tv = MutableLiveData<ArrayList<TVItems?>?>()

    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource().apply { instance = this }
            }
    }

    fun getMovies() : LiveData<ArrayList<MovieItems?>?> {
        ConfigNetwork.getApi().getMovies().enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                val body = response.body()?.results

                movies.postValue(body)
            }
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
            }
        })

        return movies
    }

    fun getTV() : LiveData<ArrayList<TVItems?>?> {
        ConfigNetwork.getApi().getShows().enqueue(object : Callback<TVResponse> {
            override fun onResponse(call: Call<TVResponse>, response: Response<TVResponse>) {
                val body = response.body()?.results

                tv.postValue(body)
            }
            override fun onFailure(call: Call<TVResponse>, t: Throwable) {
            }
        })

        return tv
    }

    fun getDetailMovie(id: Int, callback: LoadDetailMovieCallback) {
        ConfigNetwork.getApi().getDetailMovie(id).enqueue(object : Callback<DetailMovieResponse>{
            override fun onResponse(
                call: Call<DetailMovieResponse>,
                response: Response<DetailMovieResponse>
            ) {
                val body = response.body()

                val detailMovie = MovieResp(
                    id = body?.id,
                    title = body?.title,
                    posterPath = body?.posterPath,
                    rate = body?.voteAverage,
                    language = body?.originalLanguage,
                    overview = body?.overview
                )
                callback.onDetailMovieReceived(detailMovie)
            }

            override fun onFailure(call: Call<DetailMovieResponse>, t: Throwable) {
            }
        })
    }

    fun getDetailTV(id: Int, callback: LoadDetailTVCallback) {
        ConfigNetwork.getApi().getDetailTV(id).enqueue(object : Callback<DetailTVResponse>{
            override fun onResponse(
                call: Call<DetailTVResponse>,
                response: Response<DetailTVResponse>
            ) {
                val body = response.body()

                val detailTV = TVResp(
                    id = body?.id,
                    title = body?.name,
                    posterPath = body?.posterPath,
                    rate = body?.voteAverage,
                    language = body?.originalLanguage,
                    overview = body?.overview
                )
             callback.onDetailTVReceived(detailTV)
            }

            override fun onFailure(call: Call<DetailTVResponse>, t: Throwable) {
            }
        })
    }

    interface LoadDetailMovieCallback {
        fun onDetailMovieReceived(movieResp : MovieResp)
    }

    interface LoadDetailTVCallback {
        fun onDetailTVReceived(tvResp: TVResp)
    }


}
