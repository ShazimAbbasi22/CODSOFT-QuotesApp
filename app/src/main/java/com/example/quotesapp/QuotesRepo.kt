package com.example.quotesapp

import androidx.lifecycle.LiveData

class QuotesRepo(private val quotesDAO: QuotesDAO) {

    fun getQuote(): LiveData<List<Quotes>> {
        return quotesDAO.getQuote()
    }

    suspend fun insertQuote(quotes: Quotes) {
         quotesDAO.insertQuote(quotes)
    }

    suspend fun deleteQuote(quotes: Quotes) {
         quotesDAO.deleteQuote(quotes)
    }

}