package com.example.pokedexmultiplatform.android.data.network

import com.example.pokedexmultiplatform.android.domain.Pokedex
import com.example.pokedexmultiplatform.android.domain.PokedexResponse
import retrofit2.Response

interface PokedexRepository {

    suspend fun getPokedex() : List<PokedexResponse>
}