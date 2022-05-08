package com.example.drillin_part_1_3

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.drillin_part_1_3.R
import com.example.drillin_part_1_3.adapters.LetterAdapter
import com.example.drillin_part_1_3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var letterRecyclerView: RecyclerView
    private var isLinearLayout = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        letterRecyclerView = binding.letterRecyclerView

        chooseLayout()
    }


    private fun chooseLayout(){
        if(isLinearLayout){
            letterRecyclerView.layoutManager = LinearLayoutManager(this)
        }else{
            letterRecyclerView.layoutManager = GridLayoutManager(this, 4)
        }
        letterRecyclerView.adapter = LetterAdapter()

    }

    private fun setIcon(menuItem: MenuItem){

        menuItem.icon = if(isLinearLayout)
            ContextCompat.getDrawable(this, R.drawable.ic_list)
        else
            ContextCompat.getDrawable(this, R.drawable.ic_grid)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_layout, menu)

        val layoutButton = menu?.findItem(R.id.switch_menu_layout)
        if (layoutButton != null) {
            setIcon(layoutButton)
        }

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.switch_menu_layout -> {
                isLinearLayout = !isLinearLayout
                chooseLayout()
                setIcon(item)
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }


    }
}