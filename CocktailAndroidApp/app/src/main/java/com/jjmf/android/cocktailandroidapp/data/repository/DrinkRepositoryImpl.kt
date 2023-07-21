package com.jjmf.android.cocktailandroidapp.data.repository

import com.jjmf.android.cocktailandroidapp.core.EstadosResult
import com.jjmf.android.cocktailandroidapp.data.server.interfaces.ApiInterface
import com.jjmf.android.cocktailandroidapp.data.server.mapper.toDrink
import com.jjmf.android.cocktailandroidapp.domain.model.Drink
import com.jjmf.android.cocktailandroidapp.domain.repository.DrinkRepository
import javax.inject.Inject

class DrinkRepositoryImpl @Inject constructor(
    private val api: ApiInterface,
) : DrinkRepository {
    override suspend fun getList(): EstadosResult<List<Drink>> {
        return try {
            val call = api.listarByLetra("a")
            if (call.isSuccessful) {
                val body = call.body()
                if (body?.data != null) EstadosResult.Correcto(body.data.map { it.toDrink() })
                else EstadosResult.Error("Error en su solicitud")
            } else EstadosResult.Error(call.message())
        } catch (e: Exception) {
            EstadosResult.Error(e.message.toString())
        }
    }
}