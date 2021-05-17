package com.naufal.moviepedia.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.naufal.moviepedia.di.Injection
import com.naufal.moviepedia.repository.Repository

class ViewModelFactory(private val repository: Repository) : ViewModelProvider.NewInstanceFactory() {

    companion object{
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context?) : ViewModelFactory =
            instance ?: synchronized(this){
                instance ?: ViewModelFactory(Injection.provideRepository(context)).apply {
                    instance = this
                }
            }
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
                return MovieViewModel(repository) as T
            }
            modelClass.isAssignableFrom(TVViewModel::class.java) -> {
                return TVViewModel(repository) as T
            }
            modelClass.isAssignableFrom(DetailViewModel::class.java) -> {
                return DetailViewModel(repository) as T
            }
            modelClass.isAssignableFrom(FavTVViewModel::class.java) -> {
                return FavTVViewModel(repository) as T
            }
            else -> throw Throwable("Uknown" +modelClass.name)
        }

    }

}