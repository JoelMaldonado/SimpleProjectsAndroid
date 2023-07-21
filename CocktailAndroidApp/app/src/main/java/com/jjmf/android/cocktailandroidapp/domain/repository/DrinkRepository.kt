package com.jjmf.android.cocktailandroidapp.domain.repository

import com.jjmf.android.cocktailandroidapp.core.EstadosResult
import com.jjmf.android.cocktailandroidapp.domain.model.Drink

interface DrinkRepository {
    suspend fun getList() : EstadosResult<List<Drink>>
}