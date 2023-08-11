package com.jjmf.android.cockteleriaapp.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CajaTexto(
    modifier: Modifier = Modifier,
    valor: String,
    newValor: (String) -> Unit,
    label: String,
    placeholder: String? = null,
) {

    OutlinedTextField(
        value = valor,
        onValueChange = newValor,
        label = {
            Text(text = label)
        },
        placeholder = {
            placeholder?.let {
                Text(text = it)
            }
        },
        modifier = modifier.fillMaxWidth(),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            containerColor = Color.Transparent
        )
    )

}