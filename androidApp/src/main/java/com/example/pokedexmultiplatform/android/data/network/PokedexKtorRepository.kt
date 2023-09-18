package com.example.pokedexmultiplatform.android.data.network

import com.example.pokedexmultiplatform.android.domain.serializable.Pokedex
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class PokedexKtorRepository(private val httpClient: HttpClient) {

    suspend fun getPokedex(): Pokedex =
        httpClient.get("https://pokeapi.co/api/v2/pokemon?limit=1200").body()
}