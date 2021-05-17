package com.naufal.moviepedia.di

import android.content.Context
import com.naufal.moviepedia.database.ConfigDB
import com.naufal.moviepedia.local.LocalDataSource
import com.naufal.moviepedia.remote.RemoteDataSource
import com.naufal.moviepedia.repository.Repository
import com.naufal.moviepedia.util.AppExecutors

object Injection {
    fun provideRepository(context: Context?) : Repository {

        val database = ConfigDB.getInstance(context)

        val remoteDataResource = RemoteDataSource.getInstance()
        val localDataSource = LocalDataSource.getInstance(database.movieDao(), database.tvDao())
        val appExecutors = AppExecutors()

        return Repository.getInstance(remoteDataResource, localDataSource, appExecutors)
    }
}