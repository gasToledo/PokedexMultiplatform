package com.example.pokedexmultiplatform.android.data.network

import com.example.pokedexmultiplatform.android.domain.Pokedex
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class PokedexRepositoryImp @Inject constructor(private val pokedexService: PokedexService) : PokedexRepository {
    override suspend fun getPokedex(): Response<Pokedex> {

        return withContext(Dispatchers.IO) {
            pokedexService.get()
        }
    }

}