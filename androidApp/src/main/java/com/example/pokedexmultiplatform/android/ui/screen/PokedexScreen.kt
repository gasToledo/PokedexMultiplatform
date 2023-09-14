package com.example.pokedexmultiplatform.android.ui.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.pokedexmultiplatform.android.R
import com.example.pokedexmultiplatform.android.data.network.ImageBuilder
import com.example.pokedexmultiplatform.android.domain.Pokedex
import com.example.pokedexmultiplatform.android.domain.PokedexResponse
import com.example.pokedexmultiplatform.android.ui.PokedexViewModel

@Composable
fun PokedexScreen() {

    Box(modifier = Modifier
        .fillMaxSize()
        .padding(vertical = 2.dp, horizontal = 0.5.dp)){
        PokedexGrid()
    }
}

@Composable
private fun PokedexGrid() {

    val listaNumeroPrueba = listOf(1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1)
    LazyVerticalGrid(columns = GridCells.Fixed(count = 3),
        contentPadding = PaddingValues(3.dp),
        modifier = Modifier
        .fillMaxSize()
        .padding(vertical = 2.dp, horizontal = 0.5.dp), verticalArrangement = Arrangement.Top, horizontalArrangement = Arrangement.SpaceAround) {


        itemsIndexed(listaNumeroPrueba){ index, numero ->
            PokemonCard(index = index, numero = numero)
        }
    }
}



@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun PokemonCard(index : Int, numero : Int) {

    Card(modifier = Modifier
        .size(width = 0.dp, height = 135.dp)
        .safeContentPadding()
        .padding(3.dp),
        shape = MaterialTheme.shapes.medium,
        elevation = 5.dp,
        onClick = { /*TODO*/ }) {

        Column(modifier = Modifier.fillMaxSize().safeContentPadding().padding(2.dp), verticalArrangement = Arrangement.SpaceAround, horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painter = painterResource(id = R.drawable.pokeball),
                contentDescription = "la pokeball",
                modifier = Modifier.size(80.dp).clip(shape = MaterialTheme.shapes.small))

            Text(text = "Pokemón",
                textAlign = TextAlign.Center,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                color = Color.DarkGray)
        }

    }

}