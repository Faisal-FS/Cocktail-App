package com.example.cocktails.model.repository.data.source.remote.dto


import com.example.cocktails.model.repository.models.DrinkListItem
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DrinkDto(
    @Json(name = "strDrink")
    val strDrink: String = "",
    @Json(name = "strDrinkThumb")
    val strDrinkThumb: String = "",
    @Json(name = "idDrink")
    val idDrink: String = ""
){
    fun toDrinkListItem() = DrinkListItem(
        drinkName = strDrink,
        drinkThumb = strDrinkThumb,
        id = idDrink
    )
}