package com.naufal.moviepedia.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.naufal.moviepedia.model.TVEntity
import com.naufal.moviepedia.model.TVItems
import com.naufal.moviepedia.repository.Repository
import com.naufal.moviepedia.vo.Resource

class TVViewModel(private val tvRepository: Repository) : ViewModel() {

    fun getTV(context: Context?) : LiveData<Resource<List<TVEntity>?>> = tvRepository.getAllTV(context)

}