package com.example.cocktails.model.repository.data.source.remote

import com.example.cocktails.model.repository.data.source.remote.dto.DrinksDetailDto
import com.example.cocktails.model.repository.data.source.remote.dto.DrinksListDto
import retrofit2.http.GET
import retrofit2.http.Query


interface DrinksService {

    @GET("/api/json/v1/1/filter.php?a=Non_Alcoholic")
    suspend fun getDrinks(): DrinksListDto


    @GET("api/json/v1/1/lookup.php")
    suspend fun getDrinkDetails(@Query("i") id: String): DrinksDetailDto
}