package com.example.pokedexmultiplatform.android.ui

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedexmultiplatform.android.data.network.PokedexRepository
import com.example.pokedexmultiplatform.android.domain.PokedexResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokedexViewModel @Inject constructor(pokedexMainRepository: PokedexRepository) :
    ViewModel() {

    private val _pokedex = MutableLiveData<PokedexScreenState>(PokedexScreenState.Loading)
    val pokedex : LiveData<PokedexScreenState> = _pokedex

    var screenUbication by mutableStateOf("pokedex_screen")


    init {
        viewModelScope.launch {
           _pokedex.value = PokedexScreenState.ShowPokedex(pokedexMainRepository.getPokedex())
        }
    }
}
