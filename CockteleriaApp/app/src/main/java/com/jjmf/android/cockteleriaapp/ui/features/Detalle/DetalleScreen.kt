package com.jjmf.android.cockteleriaapp.ui.features.Detalle

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.jjmf.android.cockteleriaapp.R

@Composable
fun DetalleScreen(
    id: String,
    viewModel: DetalleViewModel = hiltViewModel(),
) {


    val cocktail = viewModel.cocktail

    LaunchedEffect(key1 = Unit){
        viewModel.init(id)
    }

    val context = LocalContext.current
    viewModel.error?.let {
        Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        viewModel.error = null
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
            shape = RoundedCornerShape(15.dp),
            colors = CardDefaults.elevatedCardColors(
                containerColor = Color.Gray.copy(0.3f)
            )
        ) {
            AsyncImage(
                model = cocktail?.img,
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                error = painterResource(id = R.drawable.beber),
                contentScale = ContentScale.Crop
            )
        }
        Text(
            text = cocktail?.titulo.toString(),
        )
        Text(text = "Preparacion", fontWeight = FontWeight.Medium, fontSize = 18.sp)
        Text(
            text = cocktail?.preparacion.toString(),
        )
        Text(text = "Ingredientes", fontWeight = FontWeight.Medium, fontSize = 18.sp)
        LazyVerticalGrid(columns = GridCells.Fixed(2)){
            items(cocktail?.ingredientes ?: emptyList()){
                Text(text = "- $it")
            }
        }
    }
}