package com.example.drilling_part_1_1.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.drilling_part_1_1.DetailActivity
import com.example.drilling_part_1_1.DetailActivity.Companion.LETTER
import com.example.drilling_part_1_1.R

class LetterAdapter : RecyclerView.Adapter<LetterAdapter.LetterViewHolder>() {

    private val alphabet = ('A').rangeTo('Z').toList()

    class LetterViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val button: Button = view.findViewById(R.id.button)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LetterViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(
            R.layout.letter_or_word_view, parent, false
        )
        return LetterViewHolder(layout)

    }

    override fun onBindViewHolder(holder: LetterAdapter.LetterViewHolder, position: Int) {
        val letter = alphabet[position]
        holder.button.text = letter.toString()

        holder.button.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(LETTER, holder.button.text.toString())
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = alphabet.size
}