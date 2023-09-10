package com.example.pokedexmultiplatform.android.domain

import com.google.gson.annotations.SerializedName

data class PokedexResponse(
    @SerializedName(value = "name")
    val name: String,
    @SerializedName(value = "url")
    val url: String
)
