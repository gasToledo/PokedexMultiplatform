package com.example.pokedexmultiplatform.android.domain.serializable

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokedexResponse(
    @SerialName(value = "name")
    val name: String,
    @SerialName(value = "url")
    val url: String
)
