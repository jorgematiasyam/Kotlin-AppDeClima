package com.istea.appdelclima.presentacion.clima.actual

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.appdelclima.presentacion.clima.actual.ClimaIntencion
import com.example.appdelclima.router.Router
import com.example.appdelclima.presentacion.clima.actual.ClimaEstado
import com.istea.appdelclima.repository.Repositorio
import kotlinx.coroutines.launch
class ClimaViewModel(
    val respositorio: Repositorio,
    val router: Router,
    val lat : Float,
    val lon : Float,
    val nombre: String
) : ViewModel() {
    var uiState by mutableStateOf<ClimaEstado>(ClimaEstado.Vacio)
    fun ejecutar(intencion: ClimaIntencion){
        when(intencion){
            ClimaIntencion.actualizarClima -> traerClima()
        }
    }
    fun traerClima() {
        uiState = ClimaEstado.Cargando
        viewModelScope.launch {
            try{
                val clima = respositorio.traerClima(lat = lat, lon = lon)
                uiState = ClimaEstado.Exitoso(
                    temperatura = clima.main.temp,
                    descripcion = clima.weather.first().description,
                    st = 10.2//clima.main.feelsLike,
                )
            } catch (exception: Exception){
                uiState = ClimaEstado.Error(exception.localizedMessage ?: "Error desconocido")
            }
        }
    }
}
class ClimaViewModelFactory(
    private val repositorio: Repositorio,
    private val router: Router,
    private val lat: Float,
    private val lon: Float,
    private val nombre: String,
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ClimaViewModel::class.java)) {
            return ClimaViewModel(repositorio,router,lat,lon,nombre) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}