package com.naufal.moviepedia.viewmodel

import androidx.lifecycle.MutableLiveData
import com.naufal.moviepedia.model.TVItems
import com.naufal.moviepedia.util.DataDummy
import org.junit.Test

import org.junit.Assert.*
import org.mockito.Mockito

class FavTVViewModelTest {

    @Test
    fun getFavoriteTV() {
//        val dummyTV = DataDummy.getDataTV()
//        val tv = MutableLiveData<ArrayList<TVItems?>?>()
//        tv.value = dummyTV
//
//        Mockito.`when`(favoriteRepository.getAllTV(null)).thenReturn(tv)
//        val tvEntities = viewModel.getFavoriteTV(null).value
//        Mockito.verify(favoriteRepository).getAllTV(null)
//        assertNotNull(tvEntities)
//        assertEquals(10, tvEntities?.size)
//
//        viewModel.getFavoriteTV(null).observeForever(tvObserver)
//        Mockito.verify(tvObserver).onChanged(dummyTV)
    }
}