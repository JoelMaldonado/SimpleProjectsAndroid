package com.jjmf.android.diezmovec.ui.features.Diezmos

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun DiezmosScreen(
    viewModel: DiezmosViewModel = hiltViewModel(),
) {

    val context = LocalContext.current
    Button(onClick = {
        viewModel.exportToExcel()
    }) {
        Text(text = "Exportar")
    }
}