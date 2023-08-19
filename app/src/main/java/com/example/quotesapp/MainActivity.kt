package com.example.quotesapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.quotesapp.databinding.ActivityMainBinding
import kotlinx.coroutines.DelicateCoroutinesApi

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding


    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val database = QuotesDatabase.getDatabase(this).quotesDao()
        val repo = QuotesRepo(database)

        mainViewModel =
            ViewModelProvider(this, MainViewModelFactory(repo))[MainViewModel::class.java]

        /*
        GlobalScope.launch {
            database.insertQuote(Quotes(0, "Once a wise man said, live only to love!"))
            database.insertQuote(Quotes(0, "My name is shazim"))
        }
         */

        binding.save.setOnClickListener {
            Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show()
        }
        binding.fav.setOnClickListener {
            Toast.makeText(this, "Liked", Toast.LENGTH_SHORT).show()
        }
/*
        mainViewModel.getQuote().observe(this) {
            binding.quoteTV.text = it.toString()
        }
*/
        mainViewModel.allQuoteContents.observe(this) { quoteContents ->
            val allQuotes = quoteContents.joinToString("\n")
            binding.quoteTV.text = allQuotes
        }


    }

}


