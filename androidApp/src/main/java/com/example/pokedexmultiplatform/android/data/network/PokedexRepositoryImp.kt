package com.example.pokedexmultiplatform.android.data.network

import com.example.pokedexmultiplatform.android.domain.PokedexResponse
import javax.inject.Inject

class PokedexRepositoryImp @Inject constructor(private val pokedexService: PokedexService) :
    PokedexRepository {
    override suspend fun getPokedex(): List<PokedexResponse> {

        return pokedexService.get().body()?.responses ?: emptyList()

    }

}