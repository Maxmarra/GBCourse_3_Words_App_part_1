package com.example.drilling_part_1_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.drilling_part_1_2.adapters.WordAdapter
import com.example.drilling_part_1_2.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    companion object{
        const val LETTER = "letter"
        const val PREFIX_SEARCH = "https://google.com/search?q="
    }

    private lateinit var binding: ActivityDetailBinding
    lateinit var wordRecyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val letter = intent?.extras?.getString(LETTER).toString()

        wordRecyclerView = binding.wordRv
        wordRecyclerView.layoutManager = LinearLayoutManager(this)
        wordRecyclerView.adapter = WordAdapter(letter, this)
    }
}