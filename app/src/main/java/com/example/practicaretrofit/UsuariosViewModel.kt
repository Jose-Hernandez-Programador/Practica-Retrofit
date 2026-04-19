import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import androidx.compose.runtime.*
import com.example.practicaretrofit.Usuario

class UsuariosViewModel : ViewModel() //Creacion de la clase ViewModel

    {
    var usuarios = mutableStateOf<List<Usuario>>(emptyList())//Se crea una lista vacia de usuarios
        private set //Nadie puede modificar la lista desde fuera de la clase

    init {
        obtenerUsuarios() //Se llama a la funcion para obtener los usuarios
    }

    private fun obtenerUsuarios() {
        viewModelScope.launch /*Ejecuta la corrutina en un segundo plano*/ {
            try {
                val respuesta = RetrofitClient.api.getUsuarios() //Se llama a la funcion de la API
                usuarios.value = respuesta //guarda los datos y se actualiza la lista de usuarios
            } catch (e: Exception) /*Maneja errores si falla internet*/
            {
                e.printStackTrace()
            }
        }
    }
}