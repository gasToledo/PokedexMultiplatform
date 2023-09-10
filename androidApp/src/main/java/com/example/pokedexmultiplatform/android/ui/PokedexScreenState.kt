package com.example.pokedexmultiplatform.android.ui

import com.example.pokedexmultiplatform.android.domain.Pokedex

sealed class PokedexScreenState {

    object Loading : PokedexScreenState()

    object Error : PokedexScreenState()

    class ShowPokedex(val pokedex: Pokedex) : PokedexScreenState()
}