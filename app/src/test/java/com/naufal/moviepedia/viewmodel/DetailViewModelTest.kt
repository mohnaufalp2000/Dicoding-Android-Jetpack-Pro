package com.naufal.moviepedia.viewmodel

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.naufal.moviepedia.model.DetailMovieResponse
import com.naufal.moviepedia.model.DetailTVResponse
import com.naufal.moviepedia.model.MovieEntity
import com.naufal.moviepedia.model.TVEntity
import com.naufal.moviepedia.repository.Repository
import com.naufal.moviepedia.util.DataDummy
import com.naufal.moviepedia.vo.Resource
import com.naufal.moviepedia.vo.Status
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.junit.runner.manipulation.Ordering
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {

    private lateinit var viewModel: DetailViewModel
    private val dummyMovie : Resource<MovieEntity> = Resource.success(DataDummy.getDataMovies()[0])
    private val dummyTV : Resource<TVEntity> = Resource.success(DataDummy.getDataTV()[0])
    private val movieId = dummyMovie.data?.id
    private val tvId = dummyTV.data?.id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var detailRepository: Repository

    @Mock
    private lateinit var movieObserver: Observer<Resource<MovieEntity>>

    @Mock
    private lateinit var tvObserver: Observer<Resource<TVEntity>>


    @Before
    fun setUp() {
        viewModel = DetailViewModel(detailRepository)
        movieId?.let { viewModel.setSelectedMovie(it) }
        tvId?.let { viewModel.setSelectedTV(it) }
    }

    @Test
    fun getDetailMovie() {
        val movies = MutableLiveData<Resource<MovieEntity>>()
        movies.value = dummyMovie

        `when`(movieId?.let { detailRepository.getOneMovie(it,context = null) }).thenReturn(movies)

        viewModel.getDetailMovie(null).observeForever(movieObserver)
        verify(movieObserver).onChanged(dummyMovie)
    }

    @Test
    fun getDetailTV() {
        val tv = MutableLiveData<Resource<TVEntity>>()
        tv.value = dummyTV

        `when`(tvId?.let { detailRepository.getOneTV(it,context = null) }).thenReturn(tv)

        viewModel.getDetailTV(null).observeForever(tvObserver)
        verify(tvObserver).onChanged(dummyTV)
    }
}