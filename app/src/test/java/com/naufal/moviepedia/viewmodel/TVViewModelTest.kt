package com.naufal.moviepedia.viewmodel

import junit.framework.Assert
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class TVViewModelTest {

    private lateinit var viewModel: TVViewModel

    @Before
    fun setUp(){
        viewModel = TVViewModel()
    }

    @Test
    fun getTV() {
        val tv = viewModel.getTV()
        assertNotNull(tv)
        assertEquals(10, tv.size)
    }
}