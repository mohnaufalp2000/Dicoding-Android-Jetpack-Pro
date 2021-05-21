package com.naufal.moviepedia.database

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.naufal.moviepedia.model.MovieEntity

@Dao
interface MovieDao {

    @Query("SELECT * FROM movie")
    fun getMovies() : DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM movie WHERE movie.id = :id")
    fun getOneMovies(id: Int?) : LiveData<MovieEntity>

    @Query("SELECT * FROM movie WHERE isFavorite = 1")
    fun getFavoriteMovies(): DataSource.Factory<Int, MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addMovies(movieItems: List<MovieEntity>)
    
    @Update
    fun updateMovies(movieItems: MovieEntity)

}