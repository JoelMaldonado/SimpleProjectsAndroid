package com.jjmf.android.diezmovec.ui.features.Ofrendas

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.with
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jjmf.android.diezmovec.ui.components.CajaTexto
import com.jjmf.android.diezmovec.util.show
import kotlinx.coroutines.delay

@OptIn(ExperimentalAnimationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun OfrendasScreen(
    viewModel: OfrendasViewModel = hiltViewModel(),
) {

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
        verticalArrangement = Arrangement.spacedBy(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CajaTexto(
            valor = viewModel.titulo,
            newValor = {
                viewModel.titulo = it
            },
            label = "Titulo"
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            CajaTexto(
                modifier = Modifier.weight(1f),
                valor = viewModel.monto,
                newValor = {
                    viewModel.monto = it
                },
                label = "Monto",
                keyboardType = KeyboardType.Number
            )
            Button(
                onClick = viewModel::agregar
            ) {
                Text(text = "Agregar")
            }
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            item {
                Text(text = "Total S/${viewModel.list.sumOf { it.monto }}")
            }
            items(viewModel.list) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(15.dp)
                ) {
                    Column(
                        modifier = Modifier.weight(1f)
                    ){
                        Text(text = it.titulo, fontWeight = FontWeight.Medium)
                        Text(text = "S/${it.monto}", fontSize = 14.sp, color = Color.Gray)
                    }
                    IconButton(onClick = {
                        viewModel.list.remove(it)
                    }) {
                        Icon(imageVector = Icons.Default.Remove, contentDescription = null)
                    }
                }
            }
        }
        Button(
            onClick = {
                viewModel.list.clear()
                context.show("Se grego correctamente")
            }
        ) {
            Text(text = "Confirmar")
        }
    }

}