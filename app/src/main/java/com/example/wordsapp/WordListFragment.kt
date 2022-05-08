package com.example.wordsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wordsapp.databinding.FragmentWordListBinding

class WordListFragment : Fragment() {

    companion object{
        const val LETTER = "letter"
        var SEARCH_PREFIX = "https://www.google.com/search?q="
    }

    private var _binding:FragmentWordListBinding? = null
    private val binding get() = _binding!!
    lateinit var wordRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWordListBinding.inflate(
            inflater, container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        wordRecyclerView = binding.recyclerView
        wordRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        val letter = activity?.intent?.extras?.getString(LETTER).toString()
        wordRecyclerView.adapter = WordAdapter(letter, this.requireContext())
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}