package com.jjmf.android.diezmovec.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CajaTexto(
    modifier: Modifier = Modifier,
    valor: String,
    newValor: (String) -> Unit,
    label: String,
    keyboardType: KeyboardType = KeyboardType.Text,
) {
    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),
        value = valor,
        onValueChange = newValor,
        label = {
            Text(text = label)
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            capitalization = KeyboardCapitalization.Words
        )
    )
}