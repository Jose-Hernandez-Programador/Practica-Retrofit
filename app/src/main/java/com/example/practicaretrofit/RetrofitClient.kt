import com.example.practicaretrofit.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private const val BASE_URL = "https://jsonplaceholder.typicode.com/" //URL de la API

    val api: ApiService by lazy {
        Retrofit.Builder() //Crea una instancia de Retrofit y construye la API
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()) //Convierte el JSON a objetos Kotlin
            .build()
            .create(ApiService::class.java) //Crea una instancia de la API usando la interfaz ApiService
    }
}