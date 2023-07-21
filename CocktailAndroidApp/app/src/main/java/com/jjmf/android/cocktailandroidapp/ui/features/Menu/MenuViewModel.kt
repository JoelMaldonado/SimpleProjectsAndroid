package com.jjmf.android.cocktailandroidapp.ui.features.Menu

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jjmf.android.cocktailandroidapp.core.EstadosResult
import com.jjmf.android.cocktailandroidapp.domain.model.Cocktail
import com.jjmf.android.cocktailandroidapp.domain.model.Drink
import com.jjmf.android.cocktailandroidapp.domain.model.Filtro
import com.jjmf.android.cocktailandroidapp.domain.repository.CocktailRepository
import com.jjmf.android.cocktailandroidapp.domain.repository.DrinkRepository
import com.jjmf.android.cocktailandroidapp.domain.usecase.ListarFiltrosUseCase
import com.jjmf.android.cocktailandroidapp.domain.usecase.TipoFiltro
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MenuViewModel @Inject constructor(
    private val listarFiltrosUseCase: ListarFiltrosUseCase,
    private val repository: CocktailRepository,
    private val repo: DrinkRepository
) : ViewModel() {

    var listFiltro by mutableStateOf<List<Filtro>>(emptyList())
    var listDrink by mutableStateOf<List<Drink>>(emptyList())
    var listCocktail = mutableStateListOf<Cocktail>()

    fun init() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                when (val res = listarFiltrosUseCase(TipoFiltro.Bebidas)) {
                    is EstadosResult.Correcto -> {
                        listFiltro = res.datos ?: emptyList()
                    }
                    is EstadosResult.Error -> Log.d("tagito", res.mensajeError)
                }
                when(val res = repo.getList()){
                    is EstadosResult.Correcto -> listDrink = res.datos ?: emptyList()
                    is EstadosResult.Error -> Log.d("tagito", res.mensajeError)
                }
            } catch (e: Exception) {
                Log.d("tagito", e.message.toString())
            }
        }
    }

    fun getListTragos(categ: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                when (val res = repository.listarCocktails(categ)) {
                    is EstadosResult.Correcto -> {
                        res.datos?.forEach {
                            val cock = Cocktail(
                                id = it.id,
                                nombre = it.nombre,
                                imagen = it.imagen,
                                categ = categ
                            )
                            listCocktail.add(cock)
                        }
                    }
                    is EstadosResult.Error -> Log.d("tagito", res.mensajeError)
                }
            } catch (e: Exception) {
                Log.d("tagito", e.message.toString())
            }
        }

    }
}