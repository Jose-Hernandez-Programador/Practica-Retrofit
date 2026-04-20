import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import androidx.compose.runtime.*
import com.example.practicaretrofit.Usuario

class UsuariosViewModel : ViewModel() //Creacion de la clase ViewModel

    {
    var usuarios = mutableStateOf<List<Usuario>>(emptyList())//Se crea una variable que guarda una lista vacia de usuarios
        //mutableStateOf: Permite actualizar la lista de usuarios
        var cargando =  mutableStateOf(true)

        private set //Nadie puede modificar la lista desde fuera de la clase

    init {
        obtenerUsuarios() //Se llama a la funcion para obtener los usuarios
    }

    private fun obtenerUsuarios() { //Funcion que obtiene los usuarios
        viewModelScope.launch /*Ejecuta la corrutina en un segundo plano*/ {
            try {

                cargando.value = true  // empieza a cargar

                val respuesta = RetrofitClient.api.getUsuarios() //Se llama a INTERNET usando la API y el objeto con la funcion de interfaz
                usuarios.value = respuesta //guarda los datos y se actualiza la lista de usuarios
            } catch (e: Exception){ /*Maneja errores si falla internet*/

                e.printStackTrace() // se utiliza para manejar errores y excepciones en la consola
            } finally {
                cargando.value = false // termina de cargar
            }
        }
    }
}