package com.example.cocktails.model.repository.data.source.remote

import com.example.cocktails.model.repository.data.source.remote.dto.DrinksDetailDto
import com.example.cocktails.model.repository.data.source.remote.dto.DrinksListDto

interface RemoteDataSource {
    suspend fun getDrinks(): DrinksListDto

    suspend fun getDrinksDetail(id: String): DrinksDetailDto
}