package com.example.drilling_part_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.example.drilling_part_1.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    lateinit var binding: ActivityDetailBinding
    lateinit var recyclerView: RecyclerView

    companion object{
        const val LETTER = "letter"
        const val SERCH_PREFIX = "https://www.google.com/search?q="
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val letter = intent?.extras?.getString(LETTER).toString()

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView = binding.wordRecyclerView
        recyclerView.adapter = WordAdapter(letter, this)

        recyclerView.addItemDecoration(
            DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        )

        title = "Начинается с $letter"
    }
}