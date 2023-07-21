package com.jjmf.android.diezmovec.ui.features.Menu.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Directions
import androidx.compose.material.icons.filled.Group
import androidx.compose.material.icons.filled.Tv
import androidx.compose.material.icons.rounded.Directions
import androidx.compose.material.icons.rounded.Group
import androidx.compose.material.icons.rounded.Tv
import androidx.compose.material3.BottomAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.jjmf.android.diezmovec.ui.navigation.Rutas

@Composable
fun NavBottom(
    navController: NavHostController
) {
    val isSelected = remember { mutableStateOf(1) }

    BottomAppBar(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            IconBottom(
                isSelected = isSelected.value == 1,
                iconOn = Icons.Default.Group,
                iconOff = Icons.Rounded.Group,
                text = "Ofrendas"
            ) {
                isSelected.value = 1
                navController.backQueue.clear()
                navController.navigate(Rutas.Ofrenda.url)
            }
            IconBottom(
                isSelected = isSelected.value == 2,
                iconOn = Icons.Default.Tv,
                iconOff = Icons.Rounded.Tv,
                text = "Diezmo"
            ) {
                isSelected.value = 2
                navController.backQueue.clear()
                navController.navigate(Rutas.Diezmo.url)
            }
        }
    }
}