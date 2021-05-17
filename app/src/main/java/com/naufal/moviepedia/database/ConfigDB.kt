package com.naufal.moviepedia.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.naufal.moviepedia.model.MovieEntity
import com.naufal.moviepedia.model.MovieItems
import com.naufal.moviepedia.model.TVEntity

@Database(entities = [MovieEntity::class, TVEntity::class], version = 4, exportSchema = false)
abstract class ConfigDB : RoomDatabase() {

    abstract fun movieDao() : MovieDao
    abstract fun tvDao() : TVDao

    companion object{

        @Volatile
        private var INSTANCE: ConfigDB? = null

        fun getInstance(context: Context?): ConfigDB =
            INSTANCE ?: synchronized(this){
                Room.databaseBuilder(
                    context!!.applicationContext,
                    ConfigDB::class.java,
                    "Catalogue.db"
                ).fallbackToDestructiveMigration().build().apply {
                    INSTANCE = this
                }
            }

    }

}