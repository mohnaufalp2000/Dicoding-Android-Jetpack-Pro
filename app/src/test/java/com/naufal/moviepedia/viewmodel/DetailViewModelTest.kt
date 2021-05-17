package com.naufal.moviepedia.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.naufal.moviepedia.model.DetailMovieResponse
import com.naufal.moviepedia.model.DetailTVResponse
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

@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {

    private lateinit var viewModel: DetailViewModel
    private val dummyMovie = DataDummy.getDataMovies()[0]
    private val dummyTV = DataDummy.getDataTV()[0]
    private val movieId = dummyMovie?.id
    private val tvId = dummyTV?.id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var detailRepository: Repository

    @Mock
    private lateinit var movieObserver: Observer<DetailMovieResponse?>

    @Mock
    private lateinit var tvObserver: Observer<DetailTVResponse?>


    @Before
    fun setUp() {
        viewModel = DetailViewModel(detailRepository)
        movieId?.let { viewModel.setSelectedMovie(it) }
        tvId?.let { viewModel.setSelectedTV(it) }
    }

    @Test
    fun getDetailMovie() {
        val movies = MutableLiveData<DetailMovieResponse>()

        val detailMovie = DetailMovieResponse()

        movies.value = detailMovie

        `when`(movieId?.let { detailRepository.getOneMovie(it, null) }).thenReturn(movies)
        val movieEntity = viewModel.getDetailMovie(null).value
        movieId?.let { verify(detailRepository).getOneMovie(it, null) }

        assertNotNull(movieEntity)
        assertEquals(detailMovie.id, movieEntity?.id)
        assertEquals(detailMovie.title, movieEntity?.title)
        assertEquals(detailMovie.voteAverage, movieEntity?.voteAverage)
        assertEquals(detailMovie.originalLanguage, movieEntity?.originalLanguage)

        viewModel.getDetailMovie(null).observeForever(movieObserver)
        verify(movieObserver).onChanged(detailMovie)

    }

    @Test
    fun getDetailShow() {
        val tv = MutableLiveData<DetailTVResponse>()

        val detailTV = DetailTVResponse()

        tv.value = detailTV

        `when`(tvId?.let { detailRepository.getOneTV(it, null) }).thenReturn(tv)
        val tvEntity = viewModel.getDetailShow(null).value
        tvId?.let { verify(detailRepository).getOneTV(it, null) }

        assertNotNull(tvEntity)
        assertEquals(detailTV.id, tvEntity?.id)
        assertEquals(detailTV.name, tvEntity?.name)
        assertEquals(detailTV.voteAverage, tvEntity?.voteAverage)
        assertEquals(detailTV.originalLanguage, tvEntity?.originalLanguage)

        viewModel.getDetailShow(null).observeForever(tvObserver)
        verify(tvObserver).onChanged(detailTV)
    }
}