package com.example.cocktails.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import coil.load
import com.example.cocktails.R
import com.example.cocktails.databinding.ActivityDetailBinding
import com.example.cocktails.model.repository.models.DrinkDetail
import com.example.cocktails.viewmodel.DetailViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityDetailBinding.inflate(layoutInflater)
    }

    private val viewModel by viewModels<DetailViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val drinkId = intent.getStringExtra("drinkId")

        drinkId?.let {
            viewModel.getDrinkDetails(it)
        }

        setObservers()

    }

    private fun setObservers() {
        viewModel.drinkDetail.observe(this){
            populateDrinkDetail(it)
        }
    }

    private fun populateDrinkDetail(drinkDetail: DrinkDetail?) {
        drinkDetail?.let {
            binding.ivDrinkThumb.load(it.thumb)
            binding.tvDrinkName.text = it.name
            binding.tvDrinkCategory.text = it.category
            binding.tvDrinkAlcoholic.text = it.alcoholic
            binding.tvDrinkInstructions.text = it.instructions
        }
    }
}