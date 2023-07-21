package com.jjmf.android.diezmovec.ui.features.Menu

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jjmf.android.diezmovec.ui.features.Diezmos.DiezmosScreen
import com.jjmf.android.diezmovec.ui.features.Menu.components.NavBottom
import com.jjmf.android.diezmovec.ui.features.Ofrendas.OfrendasScreen
import com.jjmf.android.diezmovec.ui.navigation.Rutas

@Composable
fun MenuScreen(
    viewModel: MenuViewModel = hiltViewModel(),
) {

    val navController = rememberNavController()
    Column(
        Modifier.fillMaxSize()
    ) {
        NavHost(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            navController = navController,
            startDestination = Rutas.Ofrenda.url
        ) {
            composable(Rutas.Ofrenda.url) {
                OfrendasScreen()
            }
            composable(Rutas.Diezmo.url) {
                DiezmosScreen()
            }
        }

        NavBottom(
            navController = navController
        )
    }
}