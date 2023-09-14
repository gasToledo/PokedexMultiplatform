package com.example.pokedexmultiplatform.android.domain.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pokedexmultiplatform.android.ui.PokedexViewModel
import com.example.pokedexmultiplatform.android.ui.screen.PokedexScreen
import com.example.pokedexmultiplatform.android.ui.screen.PokedexStart

@Composable
fun PokedexNavigation(pokedexViewModel: PokedexViewModel) {

    val navcontroller = rememberNavController()


    NavHost(navController = navcontroller, startDestination = PokedexScreens.PokedexStart.route) {
        composable(route = PokedexScreens.PokedexStart.route){
            pokedexViewModel.screenUbication = "pokedex_start"
            PokedexStart(navcontroller)

        }

        composable(route = PokedexScreens.PokedexScreen.route){
            pokedexViewModel.screenUbication = "pokedex_screen"
            PokedexScreen(pokedexViewModel)

        }
    }
}