package com.jjmf.android.cocktailandroidapp.data.repository

import com.jjmf.android.cocktailandroidapp.core.EstadosResult
import com.jjmf.android.cocktailandroidapp.data.server.dto.toFiltro
import com.jjmf.android.cocktailandroidapp.data.server.interfaces.ApiInterface
import com.jjmf.android.cocktailandroidapp.domain.model.Filtro
import com.jjmf.android.cocktailandroidapp.domain.repository.FiltroRepository
import com.jjmf.android.cocktailandroidapp.domain.usecase.TipoFiltro
import javax.inject.Inject

class FiltroRepositoryImpl @Inject constructor(
    private val api: ApiInterface,
) : FiltroRepository {
    override suspend fun getList(tipoFiltro: TipoFiltro): EstadosResult<List<Filtro>> {
        return try {
            val call = when(tipoFiltro){
                TipoFiltro.Bebidas -> api.listarFiltrosBebidas()
                TipoFiltro.Envase -> api.listarFiltrosEnvase()
                TipoFiltro.Ingredientes -> api.listarFiltrosIngredientes()
                TipoFiltro.Alcohol -> api.listarFiltrosAlcohol()
            }
            if (call.isSuccessful) {
                val body = call.body()
                if (body != null) EstadosResult.Correcto(body.data?.map { it.toFiltro() } ?: emptyList())
                else EstadosResult.Error("Error al solicitar")
            } else EstadosResult.Error(call.message())
        } catch (e: Exception) {
            EstadosResult.Error(e.message.toString())
        }
    }

}