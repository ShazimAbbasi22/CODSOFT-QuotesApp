package com.example.quotesapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase



@Database(entities = [Quotes::class], version = 1)
abstract class QuotesDatabase : RoomDatabase() {

    abstract fun quotesDao(): QuotesDAO

    companion object {

        private var INSTANCE: QuotesDatabase? = null
        fun getDatabase(context: Context): QuotesDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext, QuotesDatabase::class.java,"quotesDB").build()
                }
            }
            return INSTANCE!!
        }
    }

}