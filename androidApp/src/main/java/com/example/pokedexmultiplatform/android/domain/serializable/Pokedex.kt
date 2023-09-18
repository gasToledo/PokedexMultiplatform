package com.example.pokedexmultiplatform.android.domain.serializable

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Pokedex(
    /*@SerialName(value = "count")
    val count: Int,
    @SerialName(value = "next")
    val next: String,
    @SerialName(value = "previous")
    val previous: String,*/
    @SerialName(value = "results")
    val responses: List<PokedexResponse>
)
