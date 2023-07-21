package com.jjmf.android.cocktailandroidapp.domain.repository

import com.jjmf.android.cocktailandroidapp.core.EstadosResult
import com.jjmf.android.cocktailandroidapp.domain.model.Cocktail

interface CocktailRepository {
    suspend fun listarCocktails(categ:String) : EstadosResult<List<Cocktail>>
}