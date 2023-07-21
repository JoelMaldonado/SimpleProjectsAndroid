package com.jjmf.android.cocktailandroidapp.data.server.mapper

import com.jjmf.android.cocktailandroidapp.data.server.dto.DrinkDto
import com.jjmf.android.cocktailandroidapp.domain.model.Drink


fun DrinkDto.toDrink(): Drink {
    val ingredientes = mutableListOf<String>()
    if (ingrediente1!=null) ingredientes.add(ingrediente1)
    if (ingrediente2!=null) ingredientes.add(ingrediente2)
    if (ingrediente3!=null) ingredientes.add(ingrediente3)
    if (ingrediente4!=null) ingredientes.add(ingrediente4)
    if (ingrediente5!=null) ingredientes.add(ingrediente5)
    if (ingrediente6!=null) ingredientes.add(ingrediente6)
    val medidas = mutableListOf<String>()
    if (medida1!=null) ingredientes.add(medida1)
    if (medida2!=null) ingredientes.add(medida2)
    if (medida3!=null) ingredientes.add(medida3)
    if (medida4!=null) ingredientes.add(medida4)
    if (medida5!=null) ingredientes.add(medida5)
    if (medida6!=null) ingredientes.add(medida6)
    return Drink(
        id = id ?: "Sin valor",
        nombre = strDrink ?: "Sin valor",
        linkYoutube = linkYoutube ?: "Sin valor",
        strCategory = strCategory ?: "Sin valor",
        strAlcoholic = strAlcoholic ?: "Sin valor",
        strGlass = strGlass ?: "Sin valor",
        imagen = imagen ?: "Sin valor",
        instrucciones = instruccionEs ?: (instruccionEn ?: ""),
        ingredientes = ingredientes,
        medidas = medidas,
    )
}