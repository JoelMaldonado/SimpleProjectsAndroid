package com.jjmf.android.cocktailandroidapp.ui.features.Menu

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.SubcomposeAsyncImage
import com.jjmf.android.cocktailandroidapp.ui.theme.ColorP1
import com.jjmf.android.cocktailandroidapp.util.show

@Composable
fun MenuScreen(
    viewModel: MenuViewModel = hiltViewModel(),
) {

    val context = LocalContext.current

    LaunchedEffect(key1 = Unit) {
        viewModel.init()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        Text(
            text = "Ordinary Drink",
            color = ColorP1,
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp
        )
        LazyVerticalGrid(columns = GridCells.Fixed(4)) {
            items(viewModel.listDrink) {

                Column(
                    modifier = Modifier.clickable {
                        context.show(it.instrucciones)
                    }
                ) {
                    SubcomposeAsyncImage(
                        model = it.imagen,
                        contentDescription = null,
                        modifier = Modifier.size(60.dp),
                        contentScale = ContentScale.Crop,
                        loading = {
                            CircularProgressIndicator()
                        }
                    )
                    Text(text = it.nombre, fontSize = 12.sp)
                }
            }
        }
    }
}
