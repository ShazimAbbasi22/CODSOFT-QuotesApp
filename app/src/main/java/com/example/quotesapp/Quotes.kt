package com.example.quotesapp

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "motivational_quotes")
data class Quotes(

    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val message: String
)

