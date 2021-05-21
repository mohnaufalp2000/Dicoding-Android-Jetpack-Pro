package com.naufal.moviepedia.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.naufal.moviepedia.model.TVEntity
import androidx.paging.DataSource

@Dao
interface TVDao {

    @Query("SELECT * FROM tv")
    fun getTV() : DataSource.Factory<Int, TVEntity>

    @Query("SELECT * FROM tv WHERE tv.id = :id")
    fun getOneTV(id: Int?) : LiveData<TVEntity>

    @Query("SELECT * FROM tv WHERE isFavorite = 1")
    fun getFavoriteTV(): DataSource.Factory<Int, TVEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addTV(tvItems: List<TVEntity>)

    @Update
    fun updateTV(tvItems: TVEntity)

}