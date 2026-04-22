package com.example.practicaretrofit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practicaretrofit.ui.theme.PracticaRetrofitTheme

class PantallaGato : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

        }
    }
}

@Preview
@Composable
fun PantallaGatos() {
    Box(modifier = Modifier.fillMaxSize()
        .background(Color.White))
    {
        ContenedorGato()
        Text(
            text = "Created by Jose Programador",
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier
                .align(Alignment.BottomStart) // alineación a la izquierda inferior
                .padding(12.dp)
                .navigationBarsPadding()//crea espacio para la barra de navegación
        )


    }
}


@OptIn(ExperimentalMaterial3Api::class)

@Preview
@Composable
fun ContenedorGato() {

    Scaffold(
        topBar = {
            /*Barra superior*/
            TopAppBar({
                Text(
                    text = "Imagen Gato",
                    fontWeight = FontWeight.Bold
                )
            },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF474645),
                    titleContentColor = Color.White )
            )
        },

        ){  PaddingValues ->
        Column(modifier = Modifier
            .padding(PaddingValues)
            .background(Color(0xFFFFFFFF))
        ) {

            Chistes()
        }
    }
}