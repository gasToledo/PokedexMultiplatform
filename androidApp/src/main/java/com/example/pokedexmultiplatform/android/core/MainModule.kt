package com.example.pokedexmultiplatform.android.core

import com.example.pokedexmultiplatform.android.data.network.PokedexRepository
import com.example.pokedexmultiplatform.android.data.network.PokedexRepositoryImp
import com.example.pokedexmultiplatform.android.data.network.PokedexService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MainModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://pokeapi.co/api/v2/")
            .build()

    @Provides
    @Singleton
    fun providesPokedexService(retrofit: Retrofit) = retrofit.create(PokedexService::class.java)

    @Provides
    @Singleton
    fun providePokedexRepository(pokedexRepository: PokedexRepositoryImp): PokedexRepository = pokedexRepository
}