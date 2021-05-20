package com.naufal.moviepedia.repository

import android.graphics.Movie
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.naufal.moviepedia.local.LocalDataSource
import com.naufal.moviepedia.model.MovieEntity
import com.naufal.moviepedia.model.TVEntity
import com.naufal.moviepedia.remote.RemoteDataSource
import com.naufal.moviepedia.util.AppExecutors
import com.naufal.moviepedia.util.DataDummy
import com.naufal.moviepedia.util.LiveDataTestUtil
import com.naufal.moviepedia.util.PagedListUtil
import com.naufal.moviepedia.viewmodel.FakeRepository
import com.naufal.moviepedia.vo.Resource
//import com.nhaarman.mockitokotlin2.verify
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.mockito.Mockito
import org.mockito.Mockito.*

class RepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)

    private val fakeRepository = FakeRepository(remote, local, appExecutors)

    private val movieResponses = DataDummy.getDataMovies()
    private val tvResponses = DataDummy.getDataTV()


    @Test
    fun getAllMovies() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getAllMovies()).thenReturn(dataSourceFactory)
        fakeRepository.getAllMovies(null)

        val movieEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.getDataMovies()))
        verify(local).getAllMovies()
        assertNotNull(movieEntities.data)
    }

    @Test
    fun getAllTV() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TVEntity>
        `when`(local.getAllTV()).thenReturn(dataSourceFactory)
        fakeRepository.getAllTV(null)

        val tvEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.getDataTV()))
        verify(local).getAllTV()
        assertNotNull(tvEntities.data)
    }

    @Test
    fun getOneMovie() {
        val dummyMovie = MutableLiveData<MovieEntity>()
        dummyMovie.value = movieResponses[0]
        `when`(local.getOneMovies(movieResponses[0].id)).thenReturn(dummyMovie)

        val movieEntities = LiveDataTestUtil.getValue(fakeRepository.getOneMovie(movieResponses[0].id, null))
        verify(local).getOneMovies(movieResponses[0].id)
        assertNotNull(movieEntities)
    }

    @Test
    fun getOneTV() {
        val dummyTV = MutableLiveData<TVEntity>()
        dummyTV.value = tvResponses[0]
        `when`(local.getOneTV(tvResponses[0].id)).thenReturn(dummyTV)

        val tvEntities = LiveDataTestUtil.getValue(fakeRepository.getOneTV(tvResponses[0].id, null))
        verify(local).getOneTV(tvResponses[0].id)
        assertNotNull(tvEntities)
    }
}