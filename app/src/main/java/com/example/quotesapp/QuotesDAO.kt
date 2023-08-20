package com.example.quotesapp

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


@Dao
interface QuotesDAO {

    @Insert
    suspend fun insertQuote(quotes: Quotes)

    @Update
    suspend fun updateQuote(quotes: Quotes)

    @Delete
    suspend fun deleteQuote(quotes: Quotes)

    @Query("SELECT * FROM motivational_quotes ORDER BY RANDOM() LIMIT 1")
    fun getQuote(): LiveData<Quotes>
}