package com.example.pokedexmultiplatform.android.data.network.retrofit

import com.example.pokedexmultiplatform.android.domain.serializable.PokedexResponse
import javax.inject.Inject

class PokedexRepositoryImp @Inject constructor(private val pokedexService: PokedexService) :
    PokedexRepository {
    override suspend fun getPokedex(): List<PokedexResponse> {

        return pokedexService.get().body()?.responses ?: emptyList()

    }

}