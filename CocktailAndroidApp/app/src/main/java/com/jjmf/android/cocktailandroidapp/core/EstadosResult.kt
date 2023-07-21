package com.jjmf.android.cocktailandroidapp.core

sealed class EstadosResult<out T> {
    data class Correcto<T>(val datos: T?) : EstadosResult<T>()
    data class Error(val mensajeError: String) : EstadosResult<Nothing>()
}
