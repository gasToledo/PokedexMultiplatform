package com.example.pokedexmultiplatform.android.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pokedexmultiplatform.android.R
import com.example.pokedexmultiplatform.android.domain.navigation.PokedexScreens


@Composable
fun PokedexStart(navController: NavController) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .safeContentPadding()
    ) {

        Image(
            painter = painterResource(id = R.drawable.pokedex_background),
            contentDescription = "Fondo de imagen",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillWidth
        )

        PokedexLog(navController)
    }
}

@Composable
private fun PokedexLog(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .safeContentPadding()
            .padding(5.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.padding(vertical = 20.dp))

        Text(
            text = "Bienvenido a tu",
            fontWeight = FontWeight.Bold,
            fontSize = 45.sp,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.SansSerif,
            color = Color.DarkGray
        )

        Image(
            painter = painterResource(id = R.drawable.pokedex_logo),
            contentDescription = "Pokedex Logo",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.padding(vertical = 40.dp))

        IconButton(onClick = { navController.navigate(PokedexScreens.PokedexScreen.route) }) {
            Image(
                painter = painterResource(id = R.drawable.pokeball),
                contentDescription = "Pokeball image",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(250.dp)
            )
        }

        Text(
            text = "Pulsa la Pokeball para entrar",
            fontWeight = FontWeight.SemiBold,
            fontSize = 28.sp,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.SansSerif,
            color = Color.DarkGray
        )


    }
}
