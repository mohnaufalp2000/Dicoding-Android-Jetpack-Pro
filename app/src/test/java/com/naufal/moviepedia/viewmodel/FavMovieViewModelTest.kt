package com.naufal.moviepedia.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.naufal.moviepedia.model.MovieItems
import com.naufal.moviepedia.model.TVItems
import com.naufal.moviepedia.repository.Repository
import com.naufal.moviepedia.util.DataDummy
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FavMovieViewModelTest {

    private lateinit var viewModel : FavMovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var favMovieRepository: Repository

    @Mock
    private lateinit var movieObserver: Observer<List<MovieItems?>?>

    @Before
    fun setUp(){
        viewModel = FavMovieViewModel(favMovieRepository)
    }

    @Test
    fun getFavoriteMovies() {
        val dummyMovies = DataDummy.getDataMovies()
        val movies = MutableLiveData<List<MovieItems?>?>()
        movies.value = dummyMovies

        Mockito.`when`(favMovieRepository.getAllMovies(context = null)).thenReturn(movies)
        val movieEntities = viewModel.getFavoriteMovies(context = null).value
        Mockito.verify(favMovieRepository).getAllMovies(context = null)
        assertNotNull(movieEntities)
        assertEquals(10, movieEntities?.size)

        viewModel.getFavoriteMovies(context = null).observeForever(movieObserver)
        Mockito.verify(movieObserver).onChanged(dummyMovies)
    }
}