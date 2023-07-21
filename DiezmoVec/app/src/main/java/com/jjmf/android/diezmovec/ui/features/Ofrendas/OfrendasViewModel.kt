package com.jjmf.android.diezmovec.ui.features.Ofrendas

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OfrendasViewModel @Inject constructor(

) : ViewModel() {

    var titulo by mutableStateOf("")
    var monto by mutableStateOf("")

    var list = mutableStateListOf<Ofrenda>()

    fun agregar() {
        list.add(
            Ofrenda(
                titulo = titulo,
                monto = monto.toDoubleOrNull() ?: 0.0
            )
        )
        titulo = ""
        monto = ""
    }


}

data class Ofrenda(
    val titulo: String,
    val monto: Double,
)