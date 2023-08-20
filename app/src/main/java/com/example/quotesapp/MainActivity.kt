package com.example.quotesapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.quotesapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val database = QuotesDatabase.getDatabase(this).quotesDao()
        val repo = QuotesRepo(database)

        mainViewModel =
            ViewModelProvider(this, MainViewModelFactory(repo))[MainViewModel::class.java]

        mainViewModel.addQuotes(
            Quotes(
                0,
                "“All our dreams can come true, if we have the courage to pursue them.” —Walt Disney"
            )
        )
        mainViewModel.addQuotes(
            Quotes(
                0,
                "“The secret of getting ahead is getting started.” —Mark Twain"
            )
        )
        mainViewModel.addQuotes(
            Quotes(
                0,
                "“Be careful Who you trust because, Sugar and Salt are same!” —Unknown"
            )
        )
        mainViewModel.addQuotes(
            Quotes(
                0,
                "“Don’t limit yourself. Many people limit themselves to what they think they can do. You can go as far as your mind lets you. What you believe, remember, you can achieve.” —Mary Kay Ash"
            )
        )
        mainViewModel.addQuotes(
            Quotes(
                0,
                "“We need to accept that we won’t always make the right decisions, that we’ll screw up royally sometimes―understanding that failure is not the opposite of success, it’s part of success.” ―Arianna Huffington"
            )
        )
        mainViewModel.addQuotes(
            Quotes(
                0,
                "““You can either experience the pain of discipline or the pain of regret. The choice is yours.” —Unknown"
            )
        )
        mainViewModel.addQuotes(
            Quotes(
                0,
                "“Your passion is waiting for your courage to catch up.” —Isabelle Lafleche"
            )
        )
        mainViewModel.addQuotes(
            Quotes(
                0,
                "“Magic is believing in yourself. If you can make that happen, you can make anything happen.” —Johann Wolfgang Von Goethe"
            )
        )

        binding.save.setOnClickListener {
            Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show()
        }
        binding.fav.setOnClickListener {
            Toast.makeText(this, "Liked", Toast.LENGTH_SHORT).show()
        }

        mainViewModel.getQuote().observe(this) { quoteContents ->
            binding.quoteTV.text = quoteContents.message
        }

    }

}


