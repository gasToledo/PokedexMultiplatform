package com.example.pokedexmultiplatform.android.data.network.retrofit

import com.example.pokedexmultiplatform.android.domain.serializable.PokedexResponse

interface PokedexRepository {

    suspend fun getPokedex(): List<PokedexResponse>
}