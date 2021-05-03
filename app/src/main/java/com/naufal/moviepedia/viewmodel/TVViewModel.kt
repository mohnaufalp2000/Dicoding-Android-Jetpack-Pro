package com.naufal.moviepedia.viewmodel

import androidx.lifecycle.ViewModel
import com.naufal.moviepedia.data.TVData
import com.naufal.moviepedia.model.TV

class TVViewModel : ViewModel() {

    fun getTV() : List<TV> = TVData.getDataTV()

}