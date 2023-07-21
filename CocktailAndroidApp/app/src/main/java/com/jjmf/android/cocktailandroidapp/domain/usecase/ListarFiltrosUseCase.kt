package com.jjmf.android.cocktailandroidapp.domain.usecase

import com.jjmf.android.cocktailandroidapp.core.EstadosResult
import com.jjmf.android.cocktailandroidapp.domain.model.Filtro
import com.jjmf.android.cocktailandroidapp.domain.repository.FiltroRepository
import javax.inject.Inject

class ListarFiltrosUseCase @Inject constructor(
    private val repository: FiltroRepository,
) {
    suspend operator fun invoke(tipoFiltro: TipoFiltro): EstadosResult<List<Filtro>> {
        return try {
            repository.getList(tipoFiltro)
        }catch (e:Exception){
            EstadosResult.Error(e.message.toString())
        }
    }

}


enum class TipoFiltro {
    Bebidas,
    Envase,
    Ingredientes,
    Alcohol
}