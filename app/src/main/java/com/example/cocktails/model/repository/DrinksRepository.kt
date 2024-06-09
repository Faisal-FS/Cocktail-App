package com.example.cocktails.model.repository

import com.example.cocktails.model.repository.models.DrinkDetail
import com.example.cocktails.model.repository.models.DrinkListItem

interface DrinksRepository {

    suspend fun getDrinks(): List<DrinkListItem>?

    suspend fun getDrinkDetails(id: String): DrinkDetail?
}