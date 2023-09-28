package com.example.pokedexmultiplatform.android.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.pokedexmultiplatform.android.R
import com.example.pokedexmultiplatform.android.ui.PokedexScreenState
import com.example.pokedexmultiplatform.android.ui.PokedexViewModel
import com.example.pokedexmultiplatform.network.ImageBuilder
import com.example.pokedexmultiplatform.serializable.PokedexResponse

@Composable
fun PokedexScreen(pokedexViewModel: PokedexViewModel) {

    val pokedexList by pokedexViewModel.pokedex.observeAsState(PokedexScreenState.Loading)

    Image(
        painter = painterResource(id = R.drawable.pokedex_background),
        contentDescription = "Fondo de imagen",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.FillWidth
    )

    when (pokedexList) {
        PokedexScreenState.Error -> TODO()
        PokedexScreenState.Loading -> {

            Box(
                modifier = Modifier
                    .fillMaxSize(), contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }

        }

        is PokedexScreenState.ShowPokedex -> {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 2.dp, horizontal = 0.5.dp)
            ) {
                PokedexGrid((pokedexList as PokedexScreenState.ShowPokedex).pokedex)
            }
        }
    }


}

@Composable
private fun PokedexGrid(pokedexList: List<PokedexResponse>) {

    LazyVerticalGrid(
        columns = GridCells.Fixed(count = 3),
        contentPadding = PaddingValues(3.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 2.dp, horizontal = 0.5.dp),
        verticalArrangement = Arrangement.Top,
        horizontalArrangement = Arrangement.SpaceAround
    ) {

        items(pokedexList) {
            PokemonCard(pokemon = it)
        }
    }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun PokemonCard(pokemon: PokedexResponse) {

    Card(modifier = Modifier
        .size(width = 0.dp, height = 135.dp)
        .safeContentPadding()
        .padding(3.dp),
        shape = MaterialTheme.shapes.medium,
        elevation = 5.dp,
        onClick = { /*TODO*/ }) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .safeContentPadding()
                .padding(2.dp),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            AsyncImage(
                model = ImageBuilder.buildPokemonImageByUrl(pokemon.url),
                placeholder = painterResource(id = R.drawable.pokeball),
                contentDescription = "Imagen de ${pokemon.name}",
                modifier = Modifier
                    .size(80.dp)
                    .clip(shape = MaterialTheme.shapes.small)
            )

            Text(
                text = pokemon.name.uppercase(),
                textAlign = TextAlign.Center,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                color = Color.DarkGray
            )
        }

    }

}