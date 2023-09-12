package com.example.pokedexmultiplatform.android.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.pokedexmultiplatform.android.data.network.ImageBuilder
import com.example.pokedexmultiplatform.android.domain.Pokedex
import com.example.pokedexmultiplatform.android.domain.PokedexResponse
import com.example.pokedexmultiplatform.android.ui.PokedexViewModel

@Composable
fun PokedexScreen(pokedexViewModel: PokedexViewModel) {

    Box(modifier = Modifier
        .fillMaxSize()
        .padding(5.dp)){
        //PokedexGrid(pokedexViewModel = pokedexViewModel)
    }


}

@Composable
private fun PokedexGrid(pokedexViewModel: PokedexViewModel) {

    val pokedexList = pokedexViewModel.getPokedex()
    LazyVerticalGrid(columns = GridCells.Fixed(count = 3)) {

        items(pokedexList){ pokemon ->
            PokemonCard(pokemon = pokemon)
        }
    }
}



@Composable
private fun PokemonCard(pokemon : PokedexResponse) {

    Column(verticalArrangement = Arrangement.SpaceBetween) {
        
        AsyncImage(model = ImageBuilder.buildPokemonImageByUrl(pokemon.name), contentDescription = "pokemon image")
        
        Text(text = pokemon.name)
    }

    


}