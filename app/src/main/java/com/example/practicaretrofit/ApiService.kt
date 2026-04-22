package com.example.practicaretrofit

import retrofit2.http.GET


/*{ → objeto → Chiste
[ → lista → List<Chiste>*/
interface ApiService {

    @GET("users") //Llama a la Api y obtiene los usuarios
    suspend fun getUsuarios(): List<Usuario> //Retorna una lista de usuarios y significa que la app puede tardar en responder

}

interface ChisteApiService {
    @GET("jokes/random")
    suspend fun getChiste(): Chiste
}
interface GatoApiService {
    @GET("v1/images/search")
    suspend fun getGato(): List<Gato>
}