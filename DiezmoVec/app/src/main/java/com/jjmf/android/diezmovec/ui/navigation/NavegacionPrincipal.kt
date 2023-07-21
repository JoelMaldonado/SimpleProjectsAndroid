package com.jjmf.android.diezmovec.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jjmf.android.diezmovec.ui.features.Diezmos.DiezmosScreen
import com.jjmf.android.diezmovec.ui.features.Menu.MenuScreen
import com.jjmf.android.diezmovec.ui.features.Ofrendas.OfrendasScreen
import javax.inject.Inject

@Composable
fun NavegacionPrincipal() {
    val navControleler = rememberNavController()
    NavHost(navController = navControleler, startDestination = Rutas.Menu.url){
        composable(Rutas.Menu.url){
            MenuScreen()
        }
    }
}