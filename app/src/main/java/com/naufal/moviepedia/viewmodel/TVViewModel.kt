package com.naufal.moviepedia.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.naufal.moviepedia.model.TVItems
import com.naufal.moviepedia.repository.Repository

class TVViewModel(private val tvRepository: Repository) : ViewModel() {

    fun getTV(context: Context?) : LiveData<ArrayList<TVItems?>?> = tvRepository.getAllTV(context)

}