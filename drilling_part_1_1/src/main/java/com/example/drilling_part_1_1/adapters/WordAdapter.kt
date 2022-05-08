package com.example.drilling_part_1_1.adapters

import android.content.Context
import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.drilling_part_1_1.DetailActivity.Companion.SEARCH_PREFIX
import com.example.drilling_part_1_1.R

class WordAdapter(private val letter:String, context: Context): RecyclerView.Adapter<WordAdapter.WordViewHolder>() {

    private val filteredWords: List<String>

    init {
        val words = context.resources.getStringArray(R.array.words).toList()

        filteredWords = words.filter { it.startsWith(letter, ignoreCase = true) }
            .shuffled()
            .take(5)
            .sorted()
    }

    class WordViewHolder(view: View): RecyclerView.ViewHolder(view){
        val button: Button = view.findViewById(R.id.button)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordAdapter.WordViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.letter_or_word_view, parent, false)
        return WordViewHolder(layout)
    }

    override fun onBindViewHolder(holder: WordAdapter.WordViewHolder, position: Int) {
        val word = filteredWords[position]
        holder.button.text = word

        holder.button.setOnClickListener {
            val context = holder.itemView.context
            val query:Uri = Uri.parse("${SEARCH_PREFIX}${word}${" " + context.resources.getString(R.string.translation)}")
            val intent = Intent(ACTION_VIEW, query)
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int = filteredWords.size
}