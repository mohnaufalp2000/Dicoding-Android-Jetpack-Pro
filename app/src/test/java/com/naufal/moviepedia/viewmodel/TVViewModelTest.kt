package com.naufal.moviepedia.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.naufal.moviepedia.model.MovieEntity
import com.naufal.moviepedia.model.TVEntity
import com.naufal.moviepedia.model.TVItems
import com.naufal.moviepedia.repository.Repository
import com.naufal.moviepedia.util.DataDummy
import com.naufal.moviepedia.vo.Resource
import com.nhaarman.mockitokotlin2.verify
import junit.framework.Assert
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
    private lateinit var observer: Observer<Resource<PagedList<TVEntity>>>

    @Mock
    private lateinit var pagedList: PagedList<TVEntity>

    @Before
    fun setUp(){
        viewModel = TVViewModel(tvRepository)
    }

    @Test
    fun getTV() {
        val dummyTV = Resource.success(pagedList)
        `when`(dummyTV.data?.size).thenReturn(5)
        val tv = MutableLiveData<Resource<PagedList<TVEntity>>>()
        tv.value = dummyTV

        `when`(tvRepository.getAllTV(context = null)).thenReturn(tv)
        val tvEntities = viewModel.getTV(context = null).value?.data
        Mockito.verify(tvRepository).getAllTV(context = null)
        assertNotNull(tvEntities)
        assertEquals(5, tvEntities?.size)

        viewModel.getTV(context = null).observeForever(observer)
        Mockito.verify(observer).onChanged(dummyTV)
    }
}