package com.naufal.moviepedia.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.naufal.moviepedia.model.DetailMovieResponse
import com.naufal.moviepedia.model.MovieEntity
import com.naufal.moviepedia.model.MovieItems

@Dao
interface MovieDao {

    @Query("SELECT * FROM movie")
    fun getMovies() : LiveData<List<MovieEntity>>

    @Query("SELECT * FROM movie WHERE movie.id = :id")
    fun getOneMovies(id: Int?) : LiveData<MovieEntity>

    @Query("SELECT * FROM movie WHERE isFavorite = 1")
    fun getFavoriteMovies(): LiveData<List<MovieEntity?>?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addMovies(movieItems: List<MovieEntity>)
    
    @Update
    fun updateMovies(movieItems: MovieEntity)

}