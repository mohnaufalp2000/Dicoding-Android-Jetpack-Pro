package com.naufal.moviepedia.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.naufal.moviepedia.model.DetailMovieResponse
import com.naufal.moviepedia.model.DetailTVResponse
import com.naufal.moviepedia.model.MovieItems
import com.naufal.moviepedia.repository.Repository
import com.naufal.moviepedia.util.DataDummy
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import java.util.*

@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {

    private lateinit var viewModel : DetailViewModel
    private val dummyMovie = DataDummy.getDataMovies()[0]
    private val dummyTV = DataDummy.getDataTV()[0]
    private val movieId = dummyMovie?.id
    private val tvId = dummyTV?.id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var detailRepository : Repository

    @Mock
    private lateinit var movieObserver: Observer<DetailMovieResponse?>

    @Mock
    private lateinit var tvObserver: Observer<DetailTVResponse?>


    @Before
    fun setUp(){
        viewModel = DetailViewModel(detailRepository)
        movieId?.let { viewModel.setSelectedMovie(it) }
        tvId?.let { viewModel.setSelectedTV(it) }
    }

    @Test
    fun getDetailMovie() {
        val movies = MutableLiveData<DetailMovieResponse>()

        val detailMovie = DetailMovieResponse(
            id = movieId,
            title = dummyMovie?.title
        )

        movies.value = detailMovie

        `when`(movieId?.let { detailRepository.getOneMovie(it) }).thenReturn(movies)
        val movieEntity = viewModel.getDetailMovie().value
        movieId?.let { verify(detailRepository).getOneMovie(it) }
        assertNotNull(movieEntity)

        viewModel.getDetailMovie().observeForever(movieObserver)
        verify(movieObserver).onChanged(detailMovie)

    }

    @Test
    fun getDetailShow() {
        val tv = MutableLiveData<DetailTVResponse>()

        val detailTV = DetailTVResponse(
            id = tvId,
            name = dummyTV?.name
        )

        tv.value = detailTV

        `when`(tvId?.let { detailRepository.getOneTV(it) }).thenReturn(tv)
        val tvEntity = viewModel.getDetailShow().value
        tvId?.let { verify(detailRepository).getOneTV(it) }
        assertNotNull(tvEntity)

        viewModel.getDetailShow().observeForever(tvObserver)
        verify(tvObserver).onChanged(detailTV)
    }
}