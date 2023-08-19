package com.example.quotesapp
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainViewModel(private val quotesRepo: QuotesRepo) : ViewModel() {

    /* fun getQuote(): LiveData<List<Quotes>> {
        return quotesRepo.getQuote()
    } */

    init {
        GlobalScope.launch {
            val quote1 = Quotes(0, "Quote 1 content")
            val quote2 = Quotes(0, "Quote 2 content")

            quotesRepo.insertQuote(quote1)
            quotesRepo.insertQuote(quote2)
        }
    }

    val allQuoteContents: LiveData<List<Quotes>> = quotesRepo.getQuote()


}