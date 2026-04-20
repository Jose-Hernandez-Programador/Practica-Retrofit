package com.example.practicaretrofit

import android.content.Intent
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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.practicaretrofit.ui.theme.PracticaRetrofitTheme
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
        PantallaInicio()
        }
    }
}

@Preview
@Composable
fun PantallaInicio () {

    val usuarios=LocalContext.current
    val chistes=LocalContext.current
    val imagenes=LocalContext.current

    Box( modifier = Modifier
        .fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize()
                .background(Color(0xFFF5F5F5)),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {

            Spacer(modifier = Modifier.height(120.dp)) //Espacio entre la parte superior y el texto

            Text(
                text = "Practica Retrofit",
                modifier = Modifier.fillMaxWidth(),
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                textAlign = TextAlign.Center
            )

            Text(
                text = "Selecciona la opción que deseas",
                modifier = Modifier.fillMaxWidth(),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(30.dp))/*Espacio entre el texto y la card de menú*/


            /*Contenedor de las cards*/
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),/*Separa el texto de arriba*/
                contentAlignment = Alignment.TopCenter
            ) {

                /*Contenedor de los botones*/
                Card(
                    modifier = Modifier.fillMaxWidth()
                        .padding(horizontal = 40.dp),
                    elevation = androidx.compose.material3.CardDefaults.cardElevation(
                        defaultElevation = 8.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    )
                )
                {
                    /*Contenido de la Card*/
                    Column(
                        modifier = Modifier
                            .padding(top = 40.dp)/*genera un espacio en la parte superior del contenido*/
                            .padding(16.dp)
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {

                        Button(
                            onClick = { val intent = Intent(usuarios, PantallaUsuario::class.java)
                                usuarios.startActivity(intent) },
                            modifier = Modifier.fillMaxWidth(0.6f), /*“Ocupa el 60% del ancho disponible del contenedor padre”*/
                            contentPadding = PaddingValues(vertical = 14.dp), /*Crea un espacio interno entre el contenido (texto) y los bordes del botón*/
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF3B82F6)
                            )
                        )
                        {
                            Text(
                                text = "Usuarios",
                                fontWeight = FontWeight.Black,
                                fontSize = 20.sp
                            )
                        }

                        Button(
                            onClick = { /*TODO*/ },
                            modifier = Modifier.fillMaxWidth(0.6f),
                            contentPadding = PaddingValues(vertical = 14.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF3B82F6)
                            )
                        ) {
                            Text(
                                text = "Chistes",
                                fontWeight = FontWeight.Black,
                                fontSize = 20.sp

                            )
                        }

                        Button(
                            onClick = { /*TODO*/ },
                            modifier = Modifier.fillMaxWidth(0.6f),
                            contentPadding = PaddingValues(vertical = 14.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF3B82F6)
                            )
                        ) {
                            Text(
                                text = "Imagenes",
                                fontWeight = FontWeight.Black,
                                fontSize = 20.sp
                            )
                        }


                    }
                }

                // Card superior (MENÚ)
                Card(
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .offset(y = (-15).dp), // se mueve hacia arriba la sube
                    shape = RoundedCornerShape(50), // estilo pill
                    elevation = CardDefaults.cardElevation(6.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFF2563EB)
                    )
                ) {
                    Text(
                        text = "Menú",
                        modifier = Modifier.fillMaxWidth()
                            .padding(vertical = 12.dp),
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp,
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
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
