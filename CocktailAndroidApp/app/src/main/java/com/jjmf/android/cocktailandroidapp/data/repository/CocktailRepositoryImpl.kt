package com.jjmf.android.cocktailandroidapp.data.repository

import com.jjmf.android.cocktailandroidapp.core.EstadosResult
import com.jjmf.android.cocktailandroidapp.data.server.dto.toCocktail
import com.jjmf.android.cocktailandroidapp.data.server.interfaces.ApiInterface
import com.jjmf.android.cocktailandroidapp.domain.model.Cocktail
import com.jjmf.android.cocktailandroidapp.domain.repository.CocktailRepository
import javax.inject.Inject

class CocktailRepositoryImpl @Inject constructor(
    private val api: ApiInterface
) : CocktailRepository {
    override suspend fun listarCocktails(categ:String): EstadosResult<List<Cocktail>> {
        return try {
            val call = api.listarByCategoria(categ)
            if (call.isSuccessful){
                val body = call.body()
                if (body?.data !=null){
                    EstadosResult.Correcto(body.data.map { it.toCocktail() })
                }else EstadosResult.Error("Error en su solicitud")
            }else EstadosResult.Error(call.message())
        }catch (e:Exception){
            EstadosResult.Error(e.message.toString())
        }
    }
}