package com.naufal.moviepedia.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.naufal.moviepedia.model.TVItems
import com.naufal.moviepedia.repository.Repository

class FavTVViewModel(private val tvRepository: Repository) : ViewModel() {

    fun getFavoriteTV(context: Context?) : LiveData<List<TVItems?>?> = tvRepository.getFavoriteTV(context)

}