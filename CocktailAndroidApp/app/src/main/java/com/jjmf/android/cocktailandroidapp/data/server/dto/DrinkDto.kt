package com.jjmf.android.cocktailandroidapp.data.server.dto

import com.google.gson.annotations.SerializedName

data class DrinkDto(
    @SerializedName("idDrink") val id: String?,
    @SerializedName("strDrink") val strDrink: String?,
    @SerializedName("strVideo") val linkYoutube: String?,
    @SerializedName("strCategory") val strCategory: String?,
    @SerializedName("strAlcoholic") val strAlcoholic: String?,
    @SerializedName("strGlass") val strGlass: String?,
    @SerializedName("strDrinkThumb") val imagen: String?,
    @SerializedName("strIngredient1") val ingrediente1: String?,
    @SerializedName("strIngredient2") val ingrediente2: String?,
    @SerializedName("strIngredient3") val ingrediente3: String?,
    @SerializedName("strIngredient4") val ingrediente4: String?,
    @SerializedName("strIngredient5") val ingrediente5: String?,
    @SerializedName("strIngredient6") val ingrediente6: String?,
    @SerializedName("strInstructions") val instruccionEn: String?,
    @SerializedName("strInstructionsES") val instruccionEs: String?,
    @SerializedName("strMeasure1") val medida1: String?,
    @SerializedName("strMeasure2") val medida2: String?,
    @SerializedName("strMeasure3") val medida3: String?,
    @SerializedName("strMeasure4") val medida4: String?,
    @SerializedName("strMeasure5") val medida5: String?,
    @SerializedName("strMeasure6") val medida6: String?,
)