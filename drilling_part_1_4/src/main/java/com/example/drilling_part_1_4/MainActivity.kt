package com.example.drilling_part_1_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.drilling_part_1_4.adapters.LetterAdapter
import com.example.drilling_part_1_4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var letterRecyclerView: RecyclerView
    var isLinearLayout = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        letterRecyclerView = binding.letterRv


        chooseLayout()
        letterRecyclerView.addItemDecoration(
            DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        )
    }

    private fun chooseLayout() {
        if (isLinearLayout)
            letterRecyclerView.layoutManager = LinearLayoutManager(this)
        else letterRecyclerView.layoutManager = GridLayoutManager(this, 4)

        letterRecyclerView.adapter = LetterAdapter()
    }

    private fun setIcon(menuItem: MenuItem) {
        menuItem.icon = if (isLinearLayout) ContextCompat.getDrawable(this, R.drawable.icon_list)
        else ContextCompat.getDrawable(this, R.drawable.icon_grid)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_layout, menu)

        val layout = menu?.findItem(R.id.switch_menu)
        if (layout != null) {
            setIcon(layout)
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.switch_menu -> {
                isLinearLayout = !isLinearLayout
                chooseLayout()
                setIcon(item)
                return true
            }
            else -> onOptionsItemSelected(item)
        }


    }
}