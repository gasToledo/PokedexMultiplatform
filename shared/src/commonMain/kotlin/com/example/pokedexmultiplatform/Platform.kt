package com.example.pokedexmultiplatform

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform