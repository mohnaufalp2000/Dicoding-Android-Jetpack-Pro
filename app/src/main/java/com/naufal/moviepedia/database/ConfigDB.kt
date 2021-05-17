package com.naufal.moviepedia.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.naufal.moviepedia.model.MovieEntity
import com.naufal.moviepedia.model.MovieItems

@Database(entities = [MovieEntity::class], version = 3, exportSchema = false)
abstract class ConfigDB : RoomDatabase() {

    abstract fun movieDao() : MovieDao

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