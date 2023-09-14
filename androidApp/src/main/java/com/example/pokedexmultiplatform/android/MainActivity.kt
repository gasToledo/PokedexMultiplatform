package com.example.pokedexmultiplatform.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import com.example.pokedexmultiplatform.android.domain.navigation.PokedexNavigation
import com.example.pokedexmultiplatform.android.ui.PokedexViewModel
import com.example.pokedexmultiplatform.android.ui.screen.PokedexScreen
import com.example.pokedexmultiplatform.android.ui.screen.PokedexStart
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
