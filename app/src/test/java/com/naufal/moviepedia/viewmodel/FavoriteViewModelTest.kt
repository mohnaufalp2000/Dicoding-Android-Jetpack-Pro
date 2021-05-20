package com.naufal.moviepedia.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.naufal.moviepedia.model.MovieEntity
import com.naufal.moviepedia.model.TVEntity
import com.naufal.moviepedia.repository.Repository
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FavoriteViewModelTest {

    private lateinit var viewModel : FavoriteViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var favoriteRepository: Repository

    @Mock
    private lateinit var movieObserver: Observer<PagedList<MovieEntity>>

    @Mock
    private lateinit var pagedListMovie: PagedList<MovieEntity>

    @Mock
    private lateinit var tvObserver: Observer<PagedList<TVEntity>>

    @Mock
    private lateinit var pagedListTV: PagedList<TVEntity>

    @Before
    fun setUp(){
        viewModel = FavoriteViewModel(favoriteRepository)
    }

    @Test
    fun getFavoriteMovies() {
        val dummyMovies = pagedListMovie
        `when`(dummyMovies.size).thenReturn(5)
        val movies = MutableLiveData<PagedList<MovieEntity>>()
        movies.value = dummyMovies

        `when`(favoriteRepository.getFavoriteMovies(null)).thenReturn(movies)
        val movieEntities = viewModel.getFavoriteMovies(null).value
        verify(favoriteRepository).getFavoriteMovies(null)
        assertNotNull(movieEntities)

        viewModel.getFavoriteMovies(null).observeForever(movieObserver)
        verify(movieObserver).onChanged(dummyMovies)
    }

    @Test
    fun getFavoriteTV() {
        val dummyTV = pagedListTV
        `when`(dummyTV.size).thenReturn(5)
        val tv = MutableLiveData<PagedList<TVEntity>>()
        tv.value = dummyTV

        `when`(favoriteRepository.getFavoriteTV(null)).thenReturn(tv)
        val tvEntities = viewModel.getFavoriteTV(null).value
        verify(favoriteRepository).getFavoriteTV(null)
        assertNotNull(tvEntities)

        viewModel.getFavoriteTV(null).observeForever(tvObserver)
        verify(tvObserver).onChanged(dummyTV)
    }
}