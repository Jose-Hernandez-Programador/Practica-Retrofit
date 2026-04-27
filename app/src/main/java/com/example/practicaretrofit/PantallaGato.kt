package com.example.practicaretrofit

import GatoViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
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
import coil.compose.AsyncImage
import androidx.compose.ui.res.painterResource

class PantallaGato : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
        PantallaGatos()
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
fun ContenedorGato(viewModel: GatoViewModel = viewModel()) {

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


        floatingActionButton = {
            FloatingActionButton(onClick = { viewModel.ObtenerGato() })
            {
                Icon(
                    imageVector = Icons.Default.Refresh,
                    contentDescription = "↻")
            }
        }

        ){  PaddingValues ->
        Column(modifier = Modifier
            .padding(PaddingValues)
            .background(Color(0xFFFFFFFF))
        ) {

        ListaGatos()
        }
    }
}

@Preview
@Composable
fun ListaGatos(viewModel: GatoViewModel = viewModel(),
    modifier: Modifier = Modifier)//conecta la vista con el ViewModel
{
    var gatitos = viewModel.gatitos.value
    var loader= viewModel.load.value

    Box(modifier=Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center) {
        if (loader) {
            CircularProgressIndicator()//muestra un circulo girando
        }
        else{
            Column(modifier = Modifier.fillMaxSize()
                .navigationBarsPadding(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
                gatitos.forEach { gato ->
                //forEache recorre la lista de gatitos y crea un elemento para cada uno
                    AsyncImage(//viene de coil y se usa para cargar imagenes de internet
                        model = gato.url,//carga la imagen desde la url
                        contentDescription = "Imagen de gato", //descripcion de la imagen
                        modifier = Modifier
                            .size(200.dp)
                            .padding(8.dp)
                    )

                }
            }
        }
    }
}