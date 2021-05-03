package com.naufal.moviepedia.viewmodel

import com.naufal.moviepedia.data.MovieData
import com.naufal.moviepedia.data.TVData
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class DetailViewModelTest {

    private lateinit var viewModel : DetailViewModel
    private val dummyMovie = MovieData.getDataMovies()[0]
    private val dummyTV = TVData.getDataTV()[0]
    private val movieId = dummyMovie.id
    private val tvId = dummyTV.id

    @Before
    fun setUp(){
        viewModel = DetailViewModel()
    }

    @Test
    fun getMovie() {
        viewModel.setSelectedMovie(dummyMovie.id)
        val movies = viewModel.getMovie()

        assertNotNull(movies)
        assertEquals(dummyMovie.id, movies.id)
        assertEquals(dummyMovie.title, movies.title)
        assertEquals(dummyMovie.genre, movies.genre)
        assertEquals(dummyMovie.rating, movies.rating, 0.0001)
        assertEquals(dummyMovie.overview, movies.overview)
        assertEquals(dummyMovie.img, movies.img)
        assertEquals(dummyMovie.released, movies.released)
        assertEquals(dummyMovie.runtime, movies.runtime)
        assertEquals(dummyMovie.language, movies.language)
    }

    @Test
    fun getTV() {
        viewModel.setSelectedTV(dummyTV.id)
        val tv = viewModel.getTV()

        assertNotNull(tv)
        assertEquals(dummyTV.id, tv.id)
        assertEquals(dummyTV.title, tv.title)
        assertEquals(dummyTV.genre, tv.genre)
        assertEquals(dummyTV.rating, tv.rating, 0.0001)
        assertEquals(dummyTV.overview, tv.overview)
        assertEquals(dummyTV.img, tv.img)
        assertEquals(dummyTV.released, tv.released)
        assertEquals(dummyTV.runtime, tv.runtime)
        assertEquals(dummyTV.language, tv.language)
    }
}