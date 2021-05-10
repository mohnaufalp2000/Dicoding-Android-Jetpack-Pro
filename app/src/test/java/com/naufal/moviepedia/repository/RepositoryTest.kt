package com.naufal.moviepedia.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.naufal.moviepedia.remote.RemoteDataSource
import com.naufal.moviepedia.util.DataDummy
import com.naufal.moviepedia.util.LiveDataTestUtil
import com.naufal.moviepedia.viewmodel.FakeRepository
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.mockito.Mockito
import org.mockito.Mockito.`when`

class RepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val fakeRepository = FakeRepository(remote)

    private val movieResponses = DataDummy.getRemoteDataMovies()
    private val tvResponses = DataDummy.getRemoteDataTV()

    @Test
    fun getAllMovies() {
        doAnswer {
            (it.arguments[0] as RemoteDataSource.LoadMoviesCallback)
                .onMoviesReceived(movieResponses)
            null
        }.`when`(remote).getMovies(any())
        val movieItems = LiveDataTestUtil.getValue(fakeRepository.getAllMovies())
        verify(remote).getMovies(any())
        assertNotNull(movieItems)
    }

    @Test
    fun getAllTV() {
        doAnswer {
            (it.arguments[0] as RemoteDataSource.LoadTVCallback)
                .onTVReceived(tvResponses)
            null
        }.`when`(remote).getTV(any())
        val tvItems = LiveDataTestUtil.getValue(fakeRepository.getAllTV())
        verify(remote).getTV(any())
        assertNotNull(tvItems)
    }
//
//    @Test
//    fun getOneMovie() {
//    }
//
//    @Test
//    fun getOneTV() {
//    }
}