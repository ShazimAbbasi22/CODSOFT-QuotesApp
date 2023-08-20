package com.example.quotesapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel(private val quotesRepo: QuotesRepo) : ViewModel() {

    fun getQuote(): LiveData<Quotes> {
        return quotesRepo.getQuote()
    }

    fun addQuotes(quote: Quotes) {
        viewModelScope.launch {
            quotesRepo.insertQuote(quote)
        }
    }
}