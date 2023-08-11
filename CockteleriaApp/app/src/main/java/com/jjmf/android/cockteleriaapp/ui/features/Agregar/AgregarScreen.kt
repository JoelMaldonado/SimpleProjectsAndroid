package com.jjmf.android.cockteleriaapp.ui.features.Agregar

import android.graphics.Bitmap
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.jjmf.android.cockteleriaapp.R
import com.jjmf.android.cockteleriaapp.ui.components.CajaTexto

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AgregarScreen(
    back: () -> Unit,
    viewModel: AgregarViewModel = hiltViewModel(),
) {

    val context = LocalContext.current

    val takePicture = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicturePreview(),
        onResult = {
            viewModel.img = it
        }
    )


    viewModel.error?.let {
        Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        viewModel.error = null
    }

    if (viewModel.back) {
        LaunchedEffect(key1 = Unit) {
            back()
            viewModel.back = false
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(25.dp),
        verticalArrangement = Arrangement.spacedBy(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        ElevatedCard(
            modifier = Modifier.size(200.dp),
            onClick = {
                      takePicture.launch(null)
            },
            shape = RoundedCornerShape(15.dp),
            colors = CardDefaults.elevatedCardColors(
                containerColor = Color.Gray.copy(0.3f)
            )
        ) {
            AsyncImage(
                model = viewModel.img,
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                error = painterResource(id = R.drawable.beber),
                contentScale = ContentScale.Crop
            )
        }

        CajaTexto(
            valor = viewModel.titulo,
            newValor = { viewModel.titulo = it },
            label = "Titulo"
        )
        CajaTexto(
            valor = viewModel.preparacion,
            newValor = { viewModel.preparacion = it },
            label = "Preparación",
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(100.dp),
            placeholder = "Ingrese la preparación del cocktel"
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            CajaTexto(
                valor = viewModel.ingrediente,
                newValor = {
                    viewModel.ingrediente = it
                },
                label = "Ingrediente",
                modifier = Modifier.weight(1f)
            )
            Button(
                onClick = {
                    if (viewModel.ingrediente.isNotEmpty()) {
                        viewModel.listIngredientes.add(viewModel.ingrediente)
                        viewModel.ingrediente = ""
                    }
                }
            ) {
                Text(text = "Agregar")
            }
        }
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(viewModel.listIngredientes) {
                Text(
                    text = it,
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.Red.copy(0.3f))
                        .padding(10.dp)
                )
            }
        }
        Button(
            onClick = viewModel::insert
        ) {
            Text(text = "Guardar")
        }
    }
}