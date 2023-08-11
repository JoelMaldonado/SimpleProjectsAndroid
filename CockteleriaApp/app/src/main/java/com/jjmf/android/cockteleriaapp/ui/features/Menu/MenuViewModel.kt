package com.jjmf.android.cockteleriaapp.ui.features.Menu

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jjmf.android.cockteleriaapp.data.repository.CocktailRepository
import com.jjmf.android.cockteleriaapp.domain.model.Cocktail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MenuViewModel @Inject constructor(
    private val repository: CocktailRepository
) : ViewModel(){

    var list by mutableStateOf<List<Cocktail>>(emptyList())
    var error by mutableStateOf<String?>(null)
    fun init() {
        viewModelScope.launch(Dispatchers.IO){
            try {
                repository.getListFlow().collect(){res->
                    list = res
                }
            }catch (e:Exception){
                error = e.message
            }
        }
    }


}