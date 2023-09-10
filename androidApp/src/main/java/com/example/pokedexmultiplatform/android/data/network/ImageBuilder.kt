package com.example.pokedexmultiplatform.android.data.network

object ImageBuilder {

    fun buildPokemonImageByUrl(detailUrl: String): String {
        val pokemonId = detailUrl.split('/')[6]
        return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$pokemonId.png"
    }
}