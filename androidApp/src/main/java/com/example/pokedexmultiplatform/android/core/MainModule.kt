package com.example.pokedexmultiplatform.android.core

import com.example.pokedexmultiplatform.android.data.network.PokedexRepository
import com.example.pokedexmultiplatform.android.data.network.PokedexRepositoryImp
import com.example.pokedexmultiplatform.android.data.network.PokedexService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.util.KtorDsl
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

    /*@Singleton
    @Provides
    fun provideHttpClient(): HttpClient =
        HttpClient {
            install(ContentNegotiation) {
                json(
                    Json {
                    ignoreUnkownKey = true
                })
            }
        }*/


    @Provides
    @Singleton
    fun providesPokedexService(retrofit: Retrofit): PokedexService =
        retrofit.create(PokedexService::class.java)

    @Provides
    @Singleton
    fun providePokedexRepository(pokedexService: PokedexService): PokedexRepository =
        PokedexRepositoryImp(pokedexService)
}