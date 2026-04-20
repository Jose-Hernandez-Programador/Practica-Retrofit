package com.example.practicaretrofit

import UsuariosViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialogDefaults.containerColor
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
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
import androidx.lifecycle.viewmodel.compose.viewModel

class PantallaUsuario : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PantallaUsuarios()
        }
    }
}


@Preview
@Composable
fun PantallaUsuarios() {
Box(modifier = Modifier.fillMaxSize()
    .background(Color.White))
     {
Contenedor()
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
fun Contenedor() {

    Scaffold(
        topBar = {
            /*Barra superior*/
            TopAppBar({
                    Text(
                        text = "Usuarios",
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

            ListaUsuarios()
        }
    }
    }


        /*
        modifier = TODO(),
        bottomBar = TODO(),
        snackbarHost = TODO(),
        floatingActionButton = TODO(),
        floatingActionButtonPosition = TODO(),
        containerColor = TODO(),
        contentColor = TODO(),
        contentWindowInsets = TODO(),

        */



@Preview
@Composable
fun ListaUsuarios(viewModel: UsuariosViewModel = viewModel(),
                  modifier: Modifier = Modifier)//conecta la vista con el ViewModel
{

    val listaUsuarios = viewModel.usuarios.value //obtiene la lista de usuarios desde el ViewModel
    val cargando = viewModel.cargando.value

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        if (cargando) {

            CircularProgressIndicator()

        } else {
            LazyColumn(modifier = Modifier.navigationBarsPadding()) {

                items(listaUsuarios)/*recorre la lista de usuarios*/
                { usuario -> /*represta cada usuario en la lista*/
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
                            verticalArrangement = Arrangement.spacedBy(
                                4.dp,
                                alignment = Alignment.CenterVertically
                            )
                        )
                        {

                            Text(
                                text = usuario.id.toString(),
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp
                            )

                            Spacer(modifier = Modifier.height(4.dp))

                            Text(
                                text = usuario.name,
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp
                            )

                            Spacer(modifier = Modifier.height(4.dp))

                            Text(
                                text = usuario.email,
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp
                            )

                            Spacer(modifier = Modifier.height(4.dp))

                            Text(
                                text = usuario.phone,
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp
                            )

                        }
                    }
                }
            }
        }
    }
}

/*
items(listaUsuarios) { usuario ->

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 6.dp),
        elevation = CardDefaults.cardElevation(6.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {

        Column(modifier = Modifier.padding(16.dp)) {

            Text(
                text = usuario.name,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = usuario.email,
                fontSize = 14.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = usuario.phone,
                fontSize = 14.sp,
                color = Color.DarkGray
            )
        }
    }
} */