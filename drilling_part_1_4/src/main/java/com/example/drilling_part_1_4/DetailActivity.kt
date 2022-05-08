package com.example.drilling_part_1_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.drilling_part_1_4.adapters.Wordadapter
import com.example.drilling_part_1_4.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    lateinit var binding: ActivityDetailBinding
    lateinit var wordRecyclerView: RecyclerView

    companion object{
        const val LETTER = "letter"
        const val SUFFIX_SEARCH = "https://google.com/search?q="
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val letter = intent?.extras?.getString(LETTER).toString()

        wordRecyclerView = binding.wordRv
        wordRecyclerView.layoutManager = LinearLayoutManager(this)
        wordRecyclerView.adapter = Wordadapter(letter, this)
    }
}