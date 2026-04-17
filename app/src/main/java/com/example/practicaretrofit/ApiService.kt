package com.example.practicaretrofit

import retrofit2.http.GET

interface ApiService {

    @GET("users") //Llama a la Api y obtiene los usuarios
    suspend fun getUsuarios(): List<Usuario> //Retorna una lista de usuarios y significa que la app puede tardar en responder
    }
