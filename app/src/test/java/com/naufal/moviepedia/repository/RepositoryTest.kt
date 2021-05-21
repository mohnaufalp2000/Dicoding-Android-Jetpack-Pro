package com.naufal.moviepedia.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.naufal.moviepedia.local.LocalDataSource
import com.naufal.moviepedia.model.MovieEntity
import com.naufal.moviepedia.model.TVEntity
import com.naufal.moviepedia.remote.RemoteDataSource
import com.naufal.moviepedia.util.*
import com.naufal.moviepedia.viewmodel.FakeRepository
import com.naufal.moviepedia.vo.Resource
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.mockito.Mockito.*

class RepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = AppExecutors(TestExecutor(), TestExecutor(), TestExecutor())

    private val fakeRepository = FakeRepository(remote, local, appExecutors)

    private val movieResponses = DataDummy.getDataMovies()
    private val tvResponses = DataDummy.getDataTV()


    @Test
    fun getAllMovies() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getAllMovies()).thenReturn(dataSourceFactory)
        fakeRepository.getAllMovies(null)

        val movieEntities = Resource.success(PagedListUtil.mockPagedList(movieResponses))
        verify(local).getAllMovies()
        assertNotNull(movieEntities.data)
        assertEquals(movieResponses.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getAllTV() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TVEntity>
        `when`(local.getAllTV()).thenReturn(dataSourceFactory)
        fakeRepository.getAllTV(null)

        val tvEntities = Resource.success(PagedListUtil.mockPagedList(tvResponses))
        verify(local).getAllTV()
        assertNotNull(tvEntities.data)
        assertEquals(tvResponses.size.toLong(), tvEntities.data?.size?.toLong())
    }

    @Test
    fun getOneMovie() {
        val dummyMovie = MutableLiveData<MovieEntity>()
        dummyMovie.value = movieResponses[0]
        `when`(local.getOneMovies(movieResponses[0].id)).thenReturn(dummyMovie)

        val movieEntities = LiveDataTestUtil.getValue(fakeRepository.getOneMovie(movieResponses[0].id, null))
        verify(local).getOneMovies(movieResponses[0].id)
        assertNotNull(movieEntities)
        assertNotNull(movieEntities.data?.title)
        assertEquals(movieResponses[0].title, movieEntities.data?.title)
    }

    @Test
    fun getOneTV() {
        val dummyTV = MutableLiveData<TVEntity>()
        dummyTV.value = tvResponses[0]
        `when`(local.getOneTV(tvResponses[0].id)).thenReturn(dummyTV)

        val tvEntities = LiveDataTestUtil.getValue(fakeRepository.getOneTV(tvResponses[0].id, null))
        verify(local).getOneTV(tvResponses[0].id)
        assertNotNull(tvEntities)
        assertNotNull(tvEntities.data?.name)
        assertEquals(tvResponses[0].name, tvEntities.data?.name)
    }

    @Test
    fun getFavoriteMovies(){
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getFavoriteMovies()).thenReturn(dataSourceFactory)
        fakeRepository.getFavoriteMovies(null)

        val movieEntities = Resource.success(PagedListUtil.mockPagedList(movieResponses))
        verify(local).getFavoriteMovies()
        assertNotNull(movieEntities)
    }

    @Test
    fun getFavoriteTV(){
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TVEntity>
        `when`(local.getFavoriteTV()).thenReturn(dataSourceFactory)
        fakeRepository.getFavoriteTV(null)

        val tvEntities = Resource.success(PagedListUtil.mockPagedList(tvResponses))
        verify(local).getFavoriteTV()
        assertNotNull(tvEntities)
    }

    @Test
    fun setFavoriteMovies(){
        val dummy = movieResponses[0]
        fakeRepository.setFavoriteMovies(dummy, true)

        verify(local, times(1)).setFavoriteMovie(dummy, true)
    }

    @Test
    fun setFavoriteTV(){
        val dummy = tvResponses[0]
        fakeRepository.setFavoriteTV(dummy, true)

        verify(local, times(1)).setFavoriteTV(dummy, true)
    }

}