package com.example.practicaretrofit

import ChisteViewModel
import UsuariosViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.practicaretrofit.ui.theme.PracticaRetrofitTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh

class PantallaChiste : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
        PantallaChistes()
        }
    }
}

@Preview
@Composable
fun PantallaChistes() {
    Box(modifier = Modifier.fillMaxSize()
        .background(Color.White))
    {
        Pantalla()
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
fun Pantalla(viewModel: ChisteViewModel = viewModel()) {

    Scaffold(
        topBar = {
            /*Barra superior*/
            TopAppBar({
                Text(
                    text = "Chistes",
                    fontWeight = FontWeight.Bold
                )
            },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF474645),
                    titleContentColor = Color.White )
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { viewModel.obtenerChiste() })
            {
                Icon(
                    imageVector = Icons.Default.Refresh,
                    contentDescription = "↻")
            }
        }

        ){  paddingValues ->
        Column(modifier = Modifier
            .padding(paddingValues)
            .background(Color(0xFFFFFFFF))
        ) {

            Chistes(viewModel)
        }
    }
}

@Preview
@Composable
fun Chistes(viewModel: ChisteViewModel = viewModel(),
                  modifier: Modifier = Modifier)//conecta la vista con el ViewModel
{

    val chiste = viewModel.chiste.value
    val cargando = viewModel.carga.value

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        if (cargando) {

            CircularProgressIndicator(
                color = Color.Blue, //cambia el color del circulo del loader
                strokeWidth = 7.dp //cambia el grosor del circulo del loader
            )

        } else {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 6.dp),
                elevation = CardDefaults.cardElevation(6.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ) {
                Column(
                    modifier = Modifier.padding(8.dp),
                    verticalArrangement = Arrangement.spacedBy
                        (4.dp, alignment = Alignment.CenterVertically)
                )
                {
                    Text(
                        text = chiste?.value ?: "No hay chiste",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )

                }
            }
        }
    }
}
