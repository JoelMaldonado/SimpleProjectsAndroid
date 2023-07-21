package com.jjmf.android.cocktailandroidapp.domain.repository

import com.jjmf.android.cocktailandroidapp.core.EstadosResult
import com.jjmf.android.cocktailandroidapp.domain.model.Filtro
import com.jjmf.android.cocktailandroidapp.domain.usecase.TipoFiltro

interface FiltroRepository {
    suspend fun getList(tipoFiltro: TipoFiltro) : EstadosResult<List<Filtro>>
}