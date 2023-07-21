package com.jjmf.android.cocktailandroidapp.data.server.dto

import com.google.gson.annotations.SerializedName
import com.jjmf.android.cocktailandroidapp.domain.model.Filtro

data class FiltroDto(
    @SerializedName("strCategory") val categoria: String?,
    @SerializedName("strGlass") val glass: String?,
    @SerializedName("strIngredient1") val ingrediente: String?,
    @SerializedName("strAlcoholic") val alcohol: String?,
)

fun FiltroDto.toFiltro(): Filtro {
    return Filtro(
        categoria = categoria ?: "Sin valor",
        glass = glass ?: "Sin valor",
        ingrediente = ingrediente ?: "Sin valor",
        alcohol = alcohol ?: "Sin valor"
    )
}