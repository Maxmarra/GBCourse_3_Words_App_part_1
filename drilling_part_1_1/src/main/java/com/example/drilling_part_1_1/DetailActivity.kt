package com.example.drilling_part_1_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.drilling_part_1_1.adapters.WordAdapter
import com.example.drilling_part_1_1.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    lateinit var binding: ActivityDetailBinding
    lateinit var wordRecyclerView: RecyclerView

    companion object{
        const val LETTER = "letter"
        var SEARCH_PREFIX = "https://www.google.com/search?q="
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val letter = intent?.extras?.getString(LETTER).toString()

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        wordRecyclerView = binding.wordRecyclerView
        wordRecyclerView.layoutManager = LinearLayoutManager(this)
        wordRecyclerView.adapter = WordAdapter(letter, this)

        title = "Слова начинающиеся с $letter"

        wordRecyclerView.addItemDecoration(
            DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        )
    }
}