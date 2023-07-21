package com.jjmf.android.diezmovec.ui.navigation

sealed class Rutas(val url:String){
    object Menu : Rutas("menu")
    object Diezmo : Rutas("diezmo")
    object Ofrenda : Rutas("ofrenda")
}
