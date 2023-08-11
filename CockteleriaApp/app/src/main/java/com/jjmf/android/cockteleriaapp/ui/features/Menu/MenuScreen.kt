package com.jjmf.android.cockteleriaapp.ui.features.Menu

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.jjmf.android.cockteleriaapp.R
import com.jjmf.android.cockteleriaapp.domain.model.Cocktail

@Composable
fun MenuScreen(
    toAgregar: () -> Unit,
    toDetalle:(String)->Unit,
    viewModel: MenuViewModel = hiltViewModel(),
) {

    LaunchedEffect(key1 = Unit) {
        viewModel.init()
    }

    val context = LocalContext.current
    viewModel.error?.let {
        Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        viewModel.error = null
    }


    Column(
        modifier = Modifier.fillMaxSize().padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalArrangement = Arrangement.spacedBy(15.dp),
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            items(viewModel.list) {cocktail->
                ItemCocktail(cocktail){
                    if (cocktail.id != null){
                        toDetalle(cocktail.id!!)
                    }
                }
            }
        }
        Button(
            onClick = toAgregar
        ) {
            Text(text = "Agregar")
        }

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemCocktail(cocktail: Cocktail, click:()->Unit) {
    ElevatedCard(
        modifier = Modifier.fillMaxWidth(),
        onClick = click,
        colors = CardDefaults.elevatedCardColors(
            containerColor = Color.White
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            verticalArrangement = Arrangement.spacedBy(5.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = cocktail.img,
                contentDescription = null,
                modifier = Modifier
                    .size(150.dp)
                    .background(Color.Gray.copy(0.3f)),
                contentScale = ContentScale.Crop,
                error = painterResource(id = R.drawable.beber)
            )
            Text(text = cocktail.titulo.toString())
        }
    }
}
