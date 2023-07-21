package com.jjmf.android.cocktailandroidapp.data.server.interfaces

import com.jjmf.android.cocktailandroidapp.core.Wrapper
import com.jjmf.android.cocktailandroidapp.data.server.dto.CocktailDto
import com.jjmf.android.cocktailandroidapp.data.server.dto.DrinkDto
import com.jjmf.android.cocktailandroidapp.data.server.dto.FiltroDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("api/json/v1/1/search.php")
    suspend fun listarByLetra(@Query("f") letra:String) : Response<Wrapper<List<DrinkDto>>>

    @GET("api/json/v1/1/list.php?c=list")
    suspend fun listarFiltrosBebidas(): Response<Wrapper<List<FiltroDto>>>
    @GET("api/json/v1/1/list.php?g=list")
    suspend fun listarFiltrosEnvase(): Response<Wrapper<List<FiltroDto>>>
    @GET("api/json/v1/1/list.php?i=list")
    suspend fun listarFiltrosIngredientes(): Response<Wrapper<List<FiltroDto>>>
    @GET("api/json/v1/1/list.php?a=list")
    suspend fun listarFiltrosAlcohol(): Response<Wrapper<List<FiltroDto>>>
    @GET("api/json/v1/1/filter.php")
    suspend fun listarByCategoria(@Query("c") categ: String): Response<Wrapper<List<CocktailDto>>>

}