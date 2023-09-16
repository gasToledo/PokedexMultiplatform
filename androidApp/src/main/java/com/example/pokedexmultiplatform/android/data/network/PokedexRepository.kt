package com.example.pokedexmultiplatform.android.data.network

import com.example.pokedexmultiplatform.android.domain.PokedexResponse

interface PokedexRepository {

    suspend fun getPokedex(): List<PokedexResponse>
}