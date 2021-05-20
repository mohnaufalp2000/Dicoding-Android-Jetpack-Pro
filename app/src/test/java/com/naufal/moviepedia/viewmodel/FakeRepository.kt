package com.naufal.moviepedia.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.naufal.moviepedia.local.LocalDataSource
import com.naufal.moviepedia.model.*
import com.naufal.moviepedia.remote.ApiResponse
import com.naufal.moviepedia.remote.RemoteDataSource
import com.naufal.moviepedia.repository.Repository
import com.naufal.moviepedia.response.DetailMovieResp
import com.naufal.moviepedia.response.DetailTVResp
import com.naufal.moviepedia.response.MovieResp
import com.naufal.moviepedia.response.TVResp
import com.naufal.moviepedia.source.AppSource
import com.naufal.moviepedia.source.NetworkBoundResource
import com.naufal.moviepedia.util.AppExecutors
import com.naufal.moviepedia.vo.Resource

class FakeRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : AppSource {

    override fun getAllMovies(context: Context?): LiveData<Resource<PagedList<MovieEntity>>> {

        return object : NetworkBoundResource<PagedList<MovieEntity>, List<MovieResp>>(appExecutors) {
            override fun loadFromDB(): LiveData<PagedList<MovieEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()

                return LivePagedListBuilder(localDataSource.getAllMovies(), config).build()
            }

            override fun shouldFetch(data: PagedList<MovieEntity>?): Boolean =
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

    override fun getAllTV(context: Context?): LiveData<Resource<PagedList<TVEntity>>> {

        return object : NetworkBoundResource<PagedList<TVEntity>, List<TVResp>>(appExecutors) {
            override fun loadFromDB(): LiveData<PagedList<TVEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()

                return LivePagedListBuilder(localDataSource.getAllTV(), config).build()
            }

            override fun shouldFetch(data: PagedList<TVEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<TVResp>>> =
                remoteDataSource.getTV(context)

            override fun saveCallResult(data: List<TVResp>) {
                val tvList = ArrayList<TVEntity>()
                for (response in data) {
                    val tvResponse = TVEntity(
                        id = response.id,
                        name = response.title,
                        posterPath = response.posterPath,
                        voteAverage = response.rate,
                        isFavorite = false,
                        originalLanguage = response.language,
                    )
                    tvList.add(tvResponse)
                }
                localDataSource.addTV(tvList)
            }

        }.asLiveData()
    }

    override fun getOneMovie(
        id: Int?,
        context: Context?
    ): LiveData<Resource<MovieEntity>>
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

    override fun getOneTV(
        id: Int?,
        context: Context?
    ): LiveData<Resource<TVEntity>> {

        return object : NetworkBoundResource<TVEntity, DetailTVResp>(appExecutors){
            override fun loadFromDB(): LiveData<TVEntity> =
                localDataSource.getOneTV(id)

            override fun shouldFetch(data: TVEntity?): Boolean =
                data?.overview.isNullOrEmpty()

            override fun createCall(): LiveData<ApiResponse<DetailTVResp>> =
                remoteDataSource.getDetailTV(id, context)

            override fun saveCallResult(data: DetailTVResp) {
//                val genresItem = ArrayList<GenresTVItem?>()
//
//                for (response in detailTvResp.genres!!){
//                    val genre = GenresTVItem(
//                        id = response.id,
//                        name = response.name
//                    )
//                    genresItem.add(genre)
//                }

                val detailTV = TVEntity(
                    id = data.id,
                    name = data.title,
                    posterPath = data.posterPath,
                    voteAverage = data.rate,
                    originalLanguage = data.language,
                    overview = data.overview,
                    firstAirDate = data.released,
//                    episodeRunTime = data.runtime,
//                    genres = genresItem
                )
                localDataSource.updateTV(detailTV)
            }
        }.asLiveData()

    }


    override fun getFavoriteMovies(context: Context?): LiveData<PagedList<MovieEntity?>?> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()

        return LivePagedListBuilder(localDataSource.getFavoriteMovies(), config).build()
    }

    override fun getFavoriteTV(context: Context?): LiveData<PagedList<TVEntity?>?> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()

        return LivePagedListBuilder(localDataSource.getFavoriteTV(), config).build()
    }

    override fun setFavoriteMovies(movieItems: MovieEntity, state: Boolean) {
        appExecutors.diskIO().execute{localDataSource.setFavoriteMovie(movieItems, state)}
    }

    override fun setFavoriteTV(tvItems: TVEntity, state: Boolean) {
        appExecutors.diskIO().execute{localDataSource.setFavoriteTV(tvItems, state)}
    }


}