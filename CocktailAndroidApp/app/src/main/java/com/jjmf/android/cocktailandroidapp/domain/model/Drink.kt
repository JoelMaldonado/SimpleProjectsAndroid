package com.jjmf.android.cocktailandroidapp.domain.model

data class Drink(
    val id: String,
    val nombre: String,
    val linkYoutube: String,
    val strCategory: String,
    val strAlcoholic: String,
    val strGlass: String,
    val imagen: String,
    val instrucciones: String,
    val ingredientes: List<String>,
    val medidas: List<String>,
)