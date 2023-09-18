package com.example.pokedexmultiplatform.android.core

import com.example.pokedexmultiplatform.android.data.network.PokedexKtorRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MainModule {


    /*@Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://pokeapi.co/api/v2/")
            .build()*/


    @Provides
    @Singleton
    fun provideHttpClient(): HttpClient =
        HttpClient {
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                })
            }
        }

    @Provides
    @Singleton
    fun providePokedexKtorRepository(httpClient: HttpClient): PokedexKtorRepository =
        PokedexKtorRepository(httpClient)

    /*@Provides
    @Singleton
    fun providesPokedexService(retrofit: Retrofit): PokedexService =
        retrofit.create(PokedexService::class.java)

    @Provides
    @Singleton
    fun providePokedexRepository(pokedexService: PokedexService): PokedexRepository =
        PokedexRepositoryImp(pokedexService)*/
}