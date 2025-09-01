package com.example.cocktails.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cocktails.model.repository.DrinksRepository
import com.example.cocktails.model.repository.models.DrinkDetail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor (
    private val mainRepository: DrinksRepository
): ViewModel() {

    companion object {
        const val TAG = "DetailViewModel"
    }

    private val _drinkDetail = MutableLiveData<DrinkDetail>()
    val drinkDetail: LiveData<DrinkDetail> = _drinkDetail

    fun getDrinkDetails(id: String){
        viewModelScope.launch {

            val drinkDetail = mainRepository.getDrinkDetails(id)

            drinkDetail?.let {
                _drinkDetail.postValue(it)
            } ?: run {
                Log.e(TAG, "getDrinkDetails: error in getting the details")
            }


        }
    }

}