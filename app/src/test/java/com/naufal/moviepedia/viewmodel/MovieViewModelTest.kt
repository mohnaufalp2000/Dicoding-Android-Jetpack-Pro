package com.naufal.moviepedia.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.naufal.moviepedia.model.MovieEntity
import com.naufal.moviepedia.model.MovieItems
import com.naufal.moviepedia.repository.Repository
import com.naufal.moviepedia.util.DataDummy
import com.naufal.moviepedia.vo.Resource
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Test

import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {

    private lateinit var viewModel : MovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: Repository

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<MovieEntity>>>

    @Mock
    private lateinit var pagedList: PagedList<MovieEntity>

    @Before
    fun setUp(){
        viewModel = MovieViewModel(movieRepository)
    }

    @Test
    fun getMovies() {
        val dummyMovies = Resource.success(pagedList)
        `when`(dummyMovies.data?.size).thenReturn(5)
        val movies = MutableLiveData<Resource<PagedList<MovieEntity>>>()
        movies.value = dummyMovies

        `when`(movieRepository.getAllMovies(context = null)).thenReturn(movies)
        val movieEntities = viewModel.getMovies(context = null).value?.data
        verify(movieRepository).getAllMovies(context = null)
        assertNotNull(movieEntities)
        assertEquals(5, movieEntities?.size)

        viewModel.getMovies(context = null).observeForever(observer)
        verify(observer).onChanged(dummyMovies)
    }
}