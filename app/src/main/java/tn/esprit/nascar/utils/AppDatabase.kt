package tn.esprit.nascar.utils

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import tn.esprit.nascar.dao.EventDao
import tn.esprit.nascar.models.Events

//TODO 10 Change this class to an abstract class that inherit from ROOMDatabase
@Database(entities = [Events::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {


    abstract fun eventDao(): EventDao

    companion object {
        //TODO 11 Apply the Design Pattern singleton
        fun getDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, "db_events").allowMainThreadQueries().build()
        }

    }
}