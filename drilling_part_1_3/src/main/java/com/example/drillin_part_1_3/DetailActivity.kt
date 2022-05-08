package com.example.drillin_part_1_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.drillin_part_1_3.adapters.WordAdapter
import com.example.drillin_part_1_3.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    companion object{
        const val LETTER = "letter"
        const val SUFFIX_SEARCH = "https://google.com/search?q="
    }

    private lateinit var binding: ActivityDetailBinding
    lateinit var wordRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val letter = intent?.extras?.getString(LETTER).toString()

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        wordRecyclerView = binding.wordRecyclerView
        wordRecyclerView.layoutManager = LinearLayoutManager(this)
        wordRecyclerView.adapter = WordAdapter(letter, this)
    }
}