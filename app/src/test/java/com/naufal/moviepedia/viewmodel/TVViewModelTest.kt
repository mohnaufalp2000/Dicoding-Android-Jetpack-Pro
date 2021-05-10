package com.naufal.moviepedia.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.naufal.moviepedia.model.MovieItems
import com.naufal.moviepedia.model.TVItems
import com.naufal.moviepedia.repository.Repository
import com.naufal.moviepedia.util.DataDummy
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TVViewModelTest {

    private lateinit var viewModel : TVViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var tvRepository: Repository

    @Mock
    private lateinit var observer: Observer<ArrayList<TVItems?>?>

    @Before
    fun setUp(){
        viewModel = TVViewModel(tvRepository)
    }

    @Test
    fun getTV() {
        val dummyTV = DataDummy.getDataTV()
        val tv = MutableLiveData<ArrayList<TVItems?>?>()
        tv.value = dummyTV

        `when`(tvRepository.getAllTV()).thenReturn(tv)
        val tvEntities = viewModel.getTV().value
        verify(tvRepository).getAllTV()
        assertNotNull(tvEntities)
        assertEquals(10, tvEntities?.size)

        viewModel.getTV().observeForever(observer)
        Mockito.verify(observer).onChanged(dummyTV)
    }
}