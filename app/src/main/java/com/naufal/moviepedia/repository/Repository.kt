package com.naufal.moviepedia.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.naufal.moviepedia.local.MovieLocalDataSource
import com.naufal.moviepedia.model.*
import com.naufal.moviepedia.remote.ApiResponse
import com.naufal.moviepedia.remote.RemoteDataSource
import com.naufal.moviepedia.response.DetailMovieResp
import com.naufal.moviepedia.response.DetailTVResp
import com.naufal.moviepedia.response.MovieResp
import com.naufal.moviepedia.response.TVResp
import com.naufal.moviepedia.source.AppSource
import com.naufal.moviepedia.source.NetworkBoundResource
import com.naufal.moviepedia.util.AppExecutors
import com.naufal.moviepedia.vo.Resource

class Repository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: MovieLocalDataSource,
    private val appExecutors: AppExecutors
    ) : AppSource {

    companion object {
        @Volatile
        private var instance: Repository? = null

        fun getInstance(
            remoteData: RemoteDataSource,
            localDataSource: MovieLocalDataSource,
            appExecutors: AppExecutors
        ): Repository =
            instance ?: synchronized(this) {
                instance ?: Repository(remoteData, localDataSource, appExecutors).apply {
                    instance = this
                }
            }
    }

    override fun getAllMovies(context: Context?): LiveData<Resource<List<MovieEntity>?>> {

        return object : NetworkBoundResource<List<MovieEntity>, List<MovieResp>>(appExecutors) {
            override fun loadFromDB(): LiveData<List<MovieEntity>> =
                localDataSource.getAllMovies()

            override fun shouldFetch(data: List<MovieEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<MovieResp>>> =
                remoteDataSource.getMovies(context)

            override fun saveCallResult(data: List<MovieResp>) {
                val movieList = ArrayList<MovieEntity>()
                for (response in data) {
                    val movieResponse = MovieEntity(
                        id = response.id,
                        title = response.title,
                        posterPath = response.posterPath,
                        voteAverage = response.rate,
                        isFavorite = false,
                        originalLanguage = response.language,
                    )
                    movieList.add(movieResponse)
                }
                localDataSource.addMovies(movieList)
            }
        }.asLiveData()
    }

    override fun getAllTV(context: Context?): LiveData<ArrayList<TVItems?>?> {
        val tvResults = MutableLiveData<ArrayList<TVItems?>?>()
        remoteDataSource.getTV(object : RemoteDataSource.LoadTVCallback {
            override fun onTVReceived(tvResp: ArrayList<TVResp>) {
                val tvList = ArrayList<TVItems?>()
                for (response in tvResp) {
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
        }, context)
        return tvResults
    }

    override fun getOneMovie(
        id: Int?,
        context: Context?
    ): LiveData<Resource<MovieEntity?>>
    {
        return object : NetworkBoundResource<MovieEntity, DetailMovieResp>(appExecutors){
            override fun loadFromDB(): LiveData<MovieEntity> =
                localDataSource.getOneMovies(id)

            override fun shouldFetch(data: MovieEntity?): Boolean =
                data?.overview.isNullOrEmpty()

            override fun createCall(): LiveData<ApiResponse<DetailMovieResp>> =
                remoteDataSource.getDetailMovie(id, context)

            override fun saveCallResult(data: DetailMovieResp) {
                val detailMovie = MovieEntity(
                    id = data.id,
                    title = data.title,
                    posterPath = data.posterPath,
                    voteAverage = data.rate,
                    originalLanguage = data.language,
                    overview = data.overview,
                    runtime = data.runtime,
                    releaseDate = data.release
                )
                localDataSource.updateMovies(detailMovie)
            }
        }.asLiveData()
    }

    override fun getOneTV(id: Int?, context: Context?): LiveData<DetailTVResponse?> {
        val detailTVResults = MutableLiveData<DetailTVResponse>()

        remoteDataSource.getDetailTV(id, object : RemoteDataSource.LoadDetailTVCallback{
            override fun onDetailTVReceived(detailTvResp: DetailTVResp) {
//                val genresItem = ArrayList<GenresTVItem?>()
//
//                for (response in detailTvResp.genres!!){
//                    val genre = GenresTVItem(
//                        id = response.id,
//                        name = response.name
//                    )
//                    genresItem.add(genre)
//                }

                val detailTVResponse = DetailTVResponse(
                    id = detailTvResp.id,
                    name = detailTvResp.title,
                    posterPath = detailTvResp.posterPath,
                    voteAverage = detailTvResp.rate,
                    originalLanguage = detailTvResp.language,
                    overview = detailTvResp.overview,
                    firstAirDate = detailTvResp.released,
                    episodeRunTime = detailTvResp.runtime,
//                    genres = genresItem
                )

                detailTVResults.postValue(detailTVResponse)
            }


        }, context)
        return detailTVResults
    }

    override fun getFavoriteMovies(context: Context?): LiveData<List<MovieEntity?>?> =
        localDataSource.getFavoriteMovies()

    override fun getFavoriteTV(context: Context?): LiveData<List<TVItems?>?> {
        val tvResults = MutableLiveData<List<TVItems?>?>()
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
        }, context)
        return tvResults
    }

    override fun setFavoriteMovies(movieItems: MovieEntity, state: Boolean) {
        appExecutors.diskIO().execute{localDataSource.setFavoriteMovie(movieItems, state)}
    }


}