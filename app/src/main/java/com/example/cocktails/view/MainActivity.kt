package com.example.cocktails.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.example.cocktails.R
import com.example.cocktails.databinding.ActivityMainBinding
import com.example.cocktails.model.repository.models.DrinkListItem
import com.example.cocktails.view.adapters.DrinksAdapter
import com.example.cocktails.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>()

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private lateinit var drinksAdapter: DrinksAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setObservers()
        setUI()
    }

    private fun setUI() {
        drinksAdapter = DrinksAdapter {
            startActivity(
                Intent(this, DetailActivity::class.java)
                    .apply {
                        putExtra("drinkId", it.id)
                    }
            )
        }

        binding.rvCocktails.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true)
        binding.rvCocktails.adapter = drinksAdapter
    }

    private fun setObservers() {
        viewModel.drinks.observe(this) {
            setDrinks(it)
        }
    }

    private fun setDrinks(drinks: List<DrinkListItem>?) {
        drinksAdapter.submitList(drinks)
    }
}