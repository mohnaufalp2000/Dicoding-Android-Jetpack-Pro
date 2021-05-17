package com.naufal.moviepedia.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.naufal.moviepedia.model.MovieEntity
import com.naufal.moviepedia.model.TVEntity

@Dao
interface TVDao {

    @Query("SELECT * FROM tv")
    fun getTV() : LiveData<List<TVEntity>>

    @Query("SELECT * FROM tv WHERE tv.id = :id")
    fun getOneTV(id: Int?) : LiveData<TVEntity>

    @Query("SELECT * FROM tv WHERE isFavorite = 1")
    fun getFavoriteTV(): LiveData<List<TVEntity?>?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addTV(tvItems: List<TVEntity>)

    @Update
    fun updateTV(tvItems: TVEntity)

}