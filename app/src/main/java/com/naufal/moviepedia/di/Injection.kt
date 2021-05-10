package com.naufal.moviepedia.di

import com.naufal.moviepedia.remote.RemoteDataSource
import com.naufal.moviepedia.repository.Repository

object Injection {
    fun provideRepository() : Repository {
        val remoteDataResource = RemoteDataSource.getInstance()

        return Repository.getInstance(remoteDataResource)
    }
}