package com.jjmf.android.cockteleriaapp.domain.model

import com.google.firebase.firestore.Exclude

data class Cocktail(
    @get:Exclude var id:String? = null,
    val titulo:String? = null,
    val preparacion:String? = null,
    val img:String? = null,
    val ingredientes:List<String>? = null,
)
