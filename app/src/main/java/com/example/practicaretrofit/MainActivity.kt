package com.example.practicaretrofit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.practicaretrofit.ui.theme.PracticaRetrofitTheme
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

        }
    }
}

@Preview
@Composable
fun PantallaInicio (){
    Column(modifier = Modifier.fillMaxSize()
        .background (color= Color(0xFFE3E0DE)),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally)
         {

        Spacer(modifier = Modifier.height(120.dp)) //Espacio entre la parte superior y el texto

        Text(text = "Practica Retrofit",
            modifier = Modifier.fillMaxWidth(),
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            textAlign = TextAlign.Center)

        Text(text = "Selecciona la opción que deseas",
            modifier = Modifier.fillMaxWidth(),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center)



        /*Parte de los botones*/
        Card( modifier = Modifier.fillMaxWidth()
            .padding(40.dp),
            elevation = androidx.compose.material3.CardDefaults.cardElevation(
            defaultElevation = 8.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF90D1D1)
            )
        )
        {
            /*Contenido de la Card*/
            Column(modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally){

            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.fillMaxWidth(0.6f),
                contentPadding = PaddingValues(vertical = 12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFF0AD97)
                )

            )
            {
                Text(
                    text = "Usuarios",
                    fontWeight = FontWeight.Black,
                    fontSize = 20.sp
                )
            }

            Button(onClick = { /*TODO*/ }) {
                Text(
                    text = "Chistes",
                    fontWeight = FontWeight.Black
                )
            }

            Button(onClick = { /*TODO*/ }) {
                Text(
                    text = "Imagenes",
                    fontWeight = FontWeight.Black
                )
            }

        }
        }
    }
    }
