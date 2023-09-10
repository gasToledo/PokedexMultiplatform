package com.example.pokedexmultiplatform.android.data.repository

import com.example.pokedexmultiplatform.android.data.network.PokedexRepository
import javax.inject.Inject

class PokedexMainRepository @Inject constructor(private val pokedexRepository: PokedexRepository) :
    PokedexRepository {
    override suspend fun getPokedex() = pokedexRepository.getPokedex()

}