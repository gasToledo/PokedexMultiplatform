package com.example.pokedexmultiplatform.android.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedexmultiplatform.android.data.repository.PokedexMainRepository
import com.example.pokedexmultiplatform.android.domain.Pokedex
import com.example.pokedexmultiplatform.android.domain.PokedexResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokedexViewModel @Inject constructor(pokedexMainRepository: PokedexMainRepository) :
    ViewModel() {

    private val _pokedex = MutableLiveData(emptyList<Pokedex>())
    val pokedex = _pokedex

    private val _screenState: MutableStateFlow<PokedexScreenState> =
        MutableStateFlow(PokedexScreenState.Loading)

    //val screenState: Flow<PokedexScreenState> = _screenState

    var screenUbication by mutableStateOf("pokedex_screen")

    /*private val coroutineExceptionHandler =
        CoroutineExceptionHandler { coroutineContext, throwable ->
            Log.d("PokedexViewModel", "Error retrieving pokedex: ${throwable.message}")
        }*/


    init{
        viewModelScope.launch {
            //pokedexMainRepository.getPokedex()
        }


        /*
        viewModelScope.launch(coroutineExceptionHandler) {
            kotlin.runCatching {
                pokedexMainRepository.getPokedex()
            }.onSuccess {
                if (it.body() != null) {
                    pokedex.postValue(it.body()!!)
                    _screenState.value = PokedexScreenState.ShowPokedex(it.body()!!)
                } else {
                    _screenState.value = PokedexScreenState.Error
                }
            }.onFailure {
                Log.d("PokedexViewModel", "Error retrieving pokedex: ${it.message}")
                _screenState.value = PokedexScreenState.Error
            }
        }
         */
    }

    fun getPokedex() : List<PokedexResponse> {

        return emptyList()
    }

}