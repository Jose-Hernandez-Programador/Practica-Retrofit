package com.example.practicaretrofit

import UsuariosViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
fun PantallaUsuarios(viewModel: UsuariosViewModel = viewModel()) {

    val listaUsuarios = viewModel.usuarios.value

    LazyColumn (modifier = Modifier.navigationBarsPadding()){

        items(listaUsuarios) { usuario ->

            Column(modifier = Modifier.padding(8.dp)) {

                Text(text = "ID: ${usuario.id}")
                Text(text = "Nombre: ${usuario.name}")
                Text(text = "Email: ${usuario.email}")
                Text(text = "Teléfono: ${usuario.phone}")

            }
        }
    }
}