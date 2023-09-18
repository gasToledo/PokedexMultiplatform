package com.example.pokedexmultiplatform.android.data.network.retrofit

import com.example.pokedexmultiplatform.android.domain.serializable.Pokedex
import retrofit2.Response
import retrofit2.http.GET

interface PokedexService {

    @GET("pokemon/?limit=800")
    suspend fun get(): Response<Pokedex>
}