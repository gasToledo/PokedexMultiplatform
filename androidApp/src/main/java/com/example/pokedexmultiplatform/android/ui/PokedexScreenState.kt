package com.example.pokedexmultiplatform.android.ui

import com.example.pokedexmultiplatform.serializable.PokedexResponse

sealed class PokedexScreenState {

    object Loading : PokedexScreenState()

    object Error : PokedexScreenState()

    class ShowPokedex(val pokedex: List<PokedexResponse>) : PokedexScreenState()

}