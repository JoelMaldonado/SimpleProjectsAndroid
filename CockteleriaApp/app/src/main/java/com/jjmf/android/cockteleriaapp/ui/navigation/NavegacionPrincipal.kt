package com.jjmf.android.cockteleriaapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jjmf.android.cockteleriaapp.ui.features.Agregar.AgregarScreen
import com.jjmf.android.cockteleriaapp.ui.features.Detalle.DetalleScreen
import com.jjmf.android.cockteleriaapp.ui.features.Menu.MenuScreen

@Composable
fun NavegacionPrincipal() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Rutas.Menu.url){
        composable(
            route = Rutas.Menu.url
        ){
            MenuScreen(
                toAgregar = {
                    navController.navigate(Rutas.Agregar.url)
                },
                toDetalle = {
                    navController.navigate(Rutas.Detalle.sendId(it))
                }
            )
        }
        composable(
            route = Rutas.Agregar.url
        ){
            AgregarScreen(
                back = {
                    navController.popBackStack()
                }
            )
        }
        composable(Rutas.Detalle.url){
            it.arguments?.getString("id")?.let {id->
                DetalleScreen(
                    id = id
                )
            }
        }
    }
}