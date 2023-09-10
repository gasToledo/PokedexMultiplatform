package com.example.pokedexmultiplatform.android.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedexmultiplatform.android.data.repository.PokedexMainRepository
import com.example.pokedexmultiplatform.android.domain.Pokedex
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokedexViewModel @Inject constructor(pokedexMainRepository: PokedexMainRepository) :
    ViewModel() {

    val pokedex = MutableLiveData<Pokedex>()

    private val _screenState: MutableStateFlow<PokedexScreenState> =
        MutableStateFlow(PokedexScreenState.Loading)

    val screenState: Flow<PokedexScreenState> = _screenState

    private val coroutineExceptionHandler =
        CoroutineExceptionHandler { coroutineContext, throwable ->
            Log.d("PokedexViewModel", "Error retrieving pokedex: ${throwable.message}")
        }


    init {
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
    }


}