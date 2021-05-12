package com.naufal.moviepedia.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.naufal.moviepedia.remote.RemoteDataSource
import com.naufal.moviepedia.util.DataDummy
import com.naufal.moviepedia.util.LiveDataTestUtil
import com.naufal.moviepedia.viewmodel.FakeRepository
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.eq
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
    private val movieId = movieResponses[0].id
    private val tvId = tvResponses[0].id
    private val detailMovieResponse = movieId?.let { DataDummy.getRemoteDetailDataMovies(it) }
    private val detailTVResponse = tvId?.let { DataDummy.getRemoteDetailDataTV(it) }

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
        assertEquals(movieResponses.size.toLong(), movieItems?.size?.toLong())
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
        assertEquals(tvResponses.size.toLong(), tvItems?.size?.toLong())
    }

    @Test
    fun getOneMovie() {
        doAnswer {
            if (detailMovieResponse != null) {
                (it.arguments[1] as RemoteDataSource.LoadDetailMovieCallback)
                    .onDetailMovieReceived(detailMovieResponse)
            }
        }.`when`(remote).getDetailMovie(eq(movieId), any())

        val movieEntity = LiveDataTestUtil.getValue(fakeRepository.getOneMovie(movieId))

        verify(remote)
            .getDetailMovie(eq(movieId), any())

        assertNotNull(movieEntity)
    }

    @Test
    fun getOneTV() {
        doAnswer {
            if (detailTVResponse != null) {
                (it.arguments[1] as RemoteDataSource.LoadDetailTVCallback)
                    .onDetailTVReceived(detailTVResponse)
            }
        }.`when`(remote).getDetailTV(eq(tvId), any())

        val tvEntity = LiveDataTestUtil.getValue(fakeRepository.getOneTV(tvId))

        verify(remote)
            .getDetailTV(eq(tvId), any())

        assertNotNull(tvEntity)
    }
}