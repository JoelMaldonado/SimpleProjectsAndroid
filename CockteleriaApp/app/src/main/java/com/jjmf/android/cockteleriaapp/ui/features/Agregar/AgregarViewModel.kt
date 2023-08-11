package com.jjmf.android.cockteleriaapp.ui.features.Agregar

import android.graphics.Bitmap
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.jjmf.android.cockteleriaapp.data.repository.CocktailRepository
import com.jjmf.android.cockteleriaapp.domain.model.Cocktail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import java.io.ByteArrayOutputStream
import javax.inject.Inject

@HiltViewModel
class AgregarViewModel @Inject constructor(
    private val repository: CocktailRepository,
) : ViewModel() {

    var img by mutableStateOf<Bitmap?>(null)
    var titulo by mutableStateOf("")
    var preparacion by mutableStateOf("")
    var ingrediente by mutableStateOf("")
    val listIngredientes = mutableListOf<String>()

    var back by mutableStateOf(false)
    var error by mutableStateOf<String?>(null)

    fun insert() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val uri = if (img!=null){
                    val fb = FirebaseStorage.getInstance().reference.child("cocktails")
                        .child("${titulo}_${System.currentTimeMillis()}.png")
                    val byteArray = ByteArrayOutputStream().also {
                        img?.compress(Bitmap.CompressFormat.PNG, 100, it)
                    }.toByteArray()
                    fb.putBytes(byteArray).await().storage.downloadUrl.await().toString()
                }else ""

                val cocktail = Cocktail(
                    titulo = titulo,
                    preparacion = preparacion,
                    ingredientes = listIngredientes,
                    img = uri
                )
                repository.insert(cocktail)
                back = true
            } catch (e: Exception) {
                error = null
            }
        }
    }
}