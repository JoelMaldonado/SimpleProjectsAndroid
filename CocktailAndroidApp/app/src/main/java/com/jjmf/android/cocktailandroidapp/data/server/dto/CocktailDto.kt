package com.jjmf.android.cocktailandroidapp.data.server.dto

import com.google.gson.annotations.SerializedName
import com.jjmf.android.cocktailandroidapp.domain.model.Cocktail

data class CocktailDto(
    @SerializedName("idDrink") val id: String?,
    @SerializedName("strDrink") val nombre: String?,
    @SerializedName("strDrinkThumb") val imagen: String?
)

fun CocktailDto.toCocktail() : Cocktail{
    return Cocktail(
        nombre = nombre ?: "Sin valor",
        imagen = imagen ?: "Sin valor",
        id = id ?: "Sin valor",
        categ = ""
    )
}