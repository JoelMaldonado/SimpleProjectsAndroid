package com.jjmf.android.storeapp.data.server.interfaces

import com.jjmf.android.storeapp.data.server.dto.ProductoDto
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("products")
    suspend fun listarProductos() : Response<List<ProductoDto>>

}