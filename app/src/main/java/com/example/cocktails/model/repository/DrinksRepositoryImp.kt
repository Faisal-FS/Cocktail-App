package com.example.cocktails.model.repository

import android.util.Log
import com.example.cocktails.model.repository.data.source.remote.RemoteDataSource
import com.example.cocktails.model.repository.models.DrinkDetail
import com.example.cocktails.model.repository.models.DrinkListItem

class DrinksRepositoryImp(private val remoteDataSource: RemoteDataSource): DrinksRepository {
    companion object {
        const val TAG = "DrinksRepositoryImp"
    }

    
    override suspend fun getDrinks(): List<DrinkListItem>? {

        try {
            val drinksDto = remoteDataSource.getDrinks()

            val drinksList = drinksDto.drinks.map {
                it.toDrinkListItem()
            }

            return drinksList

        } catch (e: Exception){
            Log.e(TAG, "getDrinks: ", e)
            return null
        }
    }

    override suspend fun getDrinkDetails(id: String): DrinkDetail? {
        try {
            val drinkDetailDto = remoteDataSource.getDrinksDetail(id)

            val drinkDetail = drinkDetailDto.drinks.first().toDrinkDetail()

            return drinkDetail
        } catch (e: Exception){
            Log.e(TAG, "getDrinkDetails: ", e)
            return null
        }
    }
}