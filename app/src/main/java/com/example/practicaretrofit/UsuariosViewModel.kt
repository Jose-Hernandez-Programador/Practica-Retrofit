import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import androidx.compose.runtime.*
import com.example.practicaretrofit.Usuario

class UsuariosViewModel : ViewModel() {

    var usuarios = mutableStateOf<List<Usuario>>(emptyList())
        private set

    init {
        obtenerUsuarios()
    }

    private fun obtenerUsuarios() {
        viewModelScope.launch {
            try {
                val respuesta = RetrofitClient.api.getUsuarios()
                usuarios.value = respuesta
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}