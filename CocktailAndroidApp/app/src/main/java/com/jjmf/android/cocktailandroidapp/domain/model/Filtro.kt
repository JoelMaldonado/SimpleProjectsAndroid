package com.jjmf.android.cocktailandroidapp.domain.model

import com.google.gson.annotations.SerializedName

data class Filtro(
    val categoria: String,
    val glass: String,
    val ingrediente: String,
    val alcohol: String
)
