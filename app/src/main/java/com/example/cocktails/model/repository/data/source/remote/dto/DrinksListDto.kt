package com.example.cocktails.model.repository.data.source.remote.dto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DrinksListDto(
    @Json(name = "drinks")
    val drinks: List<DrinkDto> = listOf()
)