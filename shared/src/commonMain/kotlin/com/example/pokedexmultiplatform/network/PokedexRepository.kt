package com.example.pokedexmultiplatform.network

import com.example.pokedexmultiplatform.serializable.Pokedex
import io.github.aakira.napier.Napier
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class PokedexRepository {
    suspend fun getPokedex(): Pokedex =
        HttpClient {
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                })
            }
            install(Logging) {
                level = LogLevel.ALL
                logger = object : Logger {
                    override fun log(message: String) {
                        Napier.v(tag = "HttpClient", message = message)
                    }
                }
                logger
            }
        }.get("https://pokeapi.co/api/v2/pokemon?limit=1200").body()
}