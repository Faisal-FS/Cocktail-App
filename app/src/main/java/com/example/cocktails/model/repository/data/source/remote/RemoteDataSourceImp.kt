package com.example.cocktails.model.repository.data.source.remote

import com.example.cocktails.model.repository.data.source.remote.dto.DrinksDetailDto
import com.example.cocktails.model.repository.data.source.remote.dto.DrinksListDto

class RemoteDataSourceImp(
    private val drinksService: DrinksService
): RemoteDataSource {

    override suspend fun getDrinks(): DrinksListDto {
        return drinksService.getDrinks()
    }

    override suspend fun getDrinksDetail(id: String): DrinksDetailDto {
        return drinksService.getDrinkDetails(id)
    }
}