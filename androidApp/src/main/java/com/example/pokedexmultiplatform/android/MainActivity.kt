package com.example.pokedexmultiplatform.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import com.example.pokedexmultiplatform.android.domain.navigation.PokedexNavigation
import com.example.pokedexmultiplatform.android.ui.PokedexViewModel
import com.example.pokedexmultiplatform.network.PokedexRepository

class MainActivity : ComponentActivity() {

    private lateinit var pokedexRepository : PokedexRepository
    private lateinit var pokedexViewModel : PokedexViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface {
                PokedexTheme(darkTheme = false) {
                    pokedexRepository = PokedexRepository()
                    pokedexViewModel = PokedexViewModel(pokedexRepository)

                    PokedexNavigation(pokedexViewModel = pokedexViewModel)
                }
            }
        }
    }
}
