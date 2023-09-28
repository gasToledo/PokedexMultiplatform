package com.example.pokedexmultiplatform.serializable

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Pokedex(
    @SerialName(value = "results")
    val responses: List<PokedexResponse>
)