package com.example.pokedexmultiplatform.android.data.network

import com.example.pokedexmultiplatform.android.domain.Pokedex
import retrofit2.Response

interface PokedexRepository {

    suspend fun getPokedex() : Response<Pokedex>
}