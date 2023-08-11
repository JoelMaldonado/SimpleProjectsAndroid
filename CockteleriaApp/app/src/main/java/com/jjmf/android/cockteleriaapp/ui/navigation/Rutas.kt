package com.jjmf.android.cockteleriaapp.ui.navigation

sealed class Rutas(val url:String){
    object Menu : Rutas(url = "menu")
    object Agregar : Rutas(url = "agregar")
    object Detalle : Rutas(url = "detalle?{id}"){
        fun sendId(id:String) = "detalle?$id"
    }
}
