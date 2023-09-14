package com.example.pokedexmultiplatform.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Surface
import com.example.pokedexmultiplatform.android.domain.navigation.PokedexNavigation
import com.example.pokedexmultiplatform.android.ui.PokedexViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val pokedexViewModel by viewModels<PokedexViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface {
                PokedexTheme(darkTheme = false) {
                    PokedexNavigation(pokedexViewModel = pokedexViewModel)
                }
            }
        }
    }
}
