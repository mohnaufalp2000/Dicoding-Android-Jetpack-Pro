package com.naufal.moviepedia.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.naufal.moviepedia.model.*
import com.naufal.moviepedia.remote.RemoteDataSource
import com.naufal.moviepedia.response.DetailMovieResp
import com.naufal.moviepedia.response.DetailTVResp
import com.naufal.moviepedia.response.MovieResp
import com.naufal.moviepedia.response.TVResp
import com.naufal.moviepedia.source.AppSource

class FakeRepository(private val remoteDataSource: RemoteDataSource) : AppSource {

    override fun getAllMovies(): LiveData<ArrayList<MovieItems?>?> {
        val movieResults = MutableLiveData<ArrayList<MovieItems?>?>()
        remoteDataSource.getMovies(object : RemoteDataSource.LoadMoviesCallback{
            override fun onMoviesReceived(movieResp: ArrayList<MovieResp>) {
                val movieList = ArrayList<MovieItems?>()
                for (response in movieResp){
                    val movieResponse = MovieItems(
                        id = response.id,
                        title = response.title,
                        posterPath = response.posterPath,
                        voteAverage = response.rate,
                        originalLanguage = response.language
                    )
                    movieList.add(movieResponse)
                }
                movieResults.postValue(movieList)
            }
        })
        return movieResults
    }

    override fun getAllTV(): LiveData<ArrayList<TVItems?>?> {
        val tvResults = MutableLiveData<ArrayList<TVItems?>?>()
        remoteDataSource.getTV(object : RemoteDataSource.LoadTVCallback{
            override fun onTVReceived(tvResp: ArrayList<TVResp>) {
                val tvList = ArrayList<TVItems?>()
                for (response in tvResp){
                    val tvResponse = TVItems(
                        id = response.id,
                        name = response.title,
                        posterPath = response.posterPath,
                        voteAverage = response.rate,
                        originalLanguage = response.language
                    )
                    tvList.add(tvResponse)
                }
                tvResults.postValue(tvList)
            }
        })
        return tvResults
    }
    override fun getOneMovie(id: Int): LiveData<DetailMovieResponse?> {
        val detailMovieResults = MutableLiveData<DetailMovieResponse>()

        remoteDataSource.getDetailMovie(id, object : RemoteDataSource.LoadDetailMovieCallback{
            override fun onDetailMovieReceived(detailMovieResp: DetailMovieResp) {
                val genresItem = ArrayList<MovieGenresItem?>()

                for (response in detailMovieResp.genres!!){
                    val genre = MovieGenresItem(
                        id = response.id,
                        name = response.name
                    )
                    genresItem.add(genre)
                }

                val detailMovieResponse = DetailMovieResponse(
                    id = detailMovieResp.id,
                    title = detailMovieResp.title,
                    posterPath = detailMovieResp.posterPath,
                    voteAverage = detailMovieResp.rate,
                    originalLanguage = detailMovieResp.language,
                    overview = detailMovieResp.overview,
                    runtime = detailMovieResp.runtime,
                    releaseDate = detailMovieResp.release,
                    genres = genresItem
                )

                detailMovieResults.postValue(detailMovieResponse)
            }
        })
        return detailMovieResults
    }
    override fun getOneTV(id: Int): LiveData<DetailTVResponse?> {
        val detailTVResults = MutableLiveData<DetailTVResponse>()

        remoteDataSource.getDetailTV(id, object : RemoteDataSource.LoadDetailTVCallback{
            override fun onDetailTVReceived(detailTvResp: DetailTVResp) {
                val genresItem = ArrayList<GenresTVItem?>()

                for (response in detailTvResp.genres!!){
                    val genre = GenresTVItem(
                        id = response.id,
                        name = response.name
                    )
                    genresItem.add(genre)
                }

                val detailTVResponse = DetailTVResponse(
                    id = detailTvResp.id,
                    name = detailTvResp.title,
                    posterPath = detailTvResp.posterPath,
                    voteAverage = detailTvResp.rate,
                    originalLanguage = detailTvResp.language,
                    overview = detailTvResp.overview,
                    firstAirDate = detailTvResp.released,
                    episodeRunTime = detailTvResp.runtime,
                    genres = genresItem
                )

                detailTVResults.postValue(detailTVResponse)
            }


        })
        return detailTVResults
    }

}