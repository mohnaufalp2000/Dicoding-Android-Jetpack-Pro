package com.naufal.moviepedia.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.naufal.moviepedia.model.TVItems
import com.naufal.moviepedia.repository.Repository

class TVViewModel(private val tvRepository: Repository) : ViewModel() {

    fun getTV() : LiveData<ArrayList<TVItems?>?> = tvRepository.getAllTV()

}