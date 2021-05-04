package com.naufal.moviepedia.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.naufal.moviepedia.model.*
import com.naufal.moviepedia.network.ConfigNetwork
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource {

    private val movies = MutableLiveData<ArrayList<MovieItems?>?>()
    private val shows = MutableLiveData<ArrayList<ShowItems?>?>()
    private val movie = MutableLiveData<DetailMovieResponse?>()
    private val show = MutableLiveData<DetailTVResponse?>()

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

    fun getShows() : LiveData<ArrayList<ShowItems?>?> {
        ConfigNetwork.getApi().getShows().enqueue(object : Callback<ShowResponse> {
            override fun onResponse(call: Call<ShowResponse>, response: Response<ShowResponse>) {
                val body = response.body()?.results

                shows.postValue(body)
            }
            override fun onFailure(call: Call<ShowResponse>, t: Throwable) {
            }
        })

        return shows
    }

    fun getDetailMovie(id: Int) : LiveData<DetailMovieResponse?> {
        ConfigNetwork.getApi().getDetailMovie(id).enqueue(object : Callback<DetailMovieResponse>{
            override fun onResponse(
                call: Call<DetailMovieResponse>,
                response: Response<DetailMovieResponse>
            ) {
                val body = response.body()

                val detailMovie = DetailMovieResponse(
                    title = body?.title,
                    posterPath = body?.posterPath,
                    overview = body?.overview,
                    voteAverage = body?.voteAverage,
                    originalLanguage = body?.originalLanguage
                )
                movie.postValue(detailMovie)
            }

            override fun onFailure(call: Call<DetailMovieResponse>, t: Throwable) {
            }
        })
        return movie
    }

    fun getDetailShow(id: Int) : LiveData<DetailTVResponse?> {
        ConfigNetwork.getApi().getDetailShow(id).enqueue(object : Callback<DetailTVResponse>{
            override fun onResponse(
                call: Call<DetailTVResponse>,
                response: Response<DetailTVResponse>
            ) {
                val body = response.body()

                val detailShow = DetailTVResponse(
                    name = body?.name,
                    posterPath = body?.posterPath,
                    overview = body?.overview,
                    voteAverage = body?.voteAverage,
                    originalLanguage = body?.originalLanguage
                )
                show.postValue(detailShow)
            }

            override fun onFailure(call: Call<DetailTVResponse>, t: Throwable) {
            }
        })
        return show
    }


}
