package com.example.cocktails.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cocktails.model.repository.DrinksRepository
import com.example.cocktails.model.repository.models.DrinkListItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor (
    private val mainRepository: DrinksRepository
): ViewModel() {

    private val _drinks = MutableLiveData<List<DrinkListItem>>()
    val drinks: LiveData<List<DrinkListItem>> = _drinks

    companion object {
        const val TAG = "MainViewModel"
    }

    init {
        getDrinks()
    }

    private fun getDrinks() {
        viewModelScope.launch {

            val drinks = mainRepository.getDrinks()
            drinks?.let {
                _drinks.postValue(it)
            } ?: run {
                Log.e(TAG, "getDrinks: Something went wrong.")
            }

        }
    }

    fun onDrinkClicked(drinkListItem: DrinkListItem) {
        Log.d(TAG, "onDrinkClicked: $drinkListItem")

    }

}