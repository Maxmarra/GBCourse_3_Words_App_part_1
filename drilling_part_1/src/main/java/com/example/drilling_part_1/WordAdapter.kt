package com.example.drilling_part_1

import android.content.Context
import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.drilling_part_1.DetailActivity.Companion.SERCH_PREFIX

class WordAdapter(private val letter:String, context: Context)
    : RecyclerView.Adapter<WordAdapter.WordViewHolder>() {

    var filteredWords: List<String>

    init {
        val words = context.resources.getStringArray(R.array.words)

        filteredWords = words
            .filter { it.startsWith(letter, ignoreCase = true)}
            .shuffled()
            .take(5)
            .sorted()
    }

    class WordViewHolder(val view: View):RecyclerView.ViewHolder(view){
        val button: Button = view.findViewById(R.id.letter_button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordAdapter.WordViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return WordViewHolder(layout)
    }

    override fun onBindViewHolder(holder: WordAdapter.WordViewHolder, position: Int) {
        val word = filteredWords[position]
        holder.button.text = word

        holder.button.setOnClickListener {
            val context = holder.view.context

            val query:Uri = Uri.parse("${SERCH_PREFIX}${word}${" " + context.resources.getString(R.string.translation)}")

            val intent = Intent(ACTION_VIEW, query )
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = filteredWords.size
}