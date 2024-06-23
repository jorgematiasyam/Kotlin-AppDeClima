package com.example.appdelclima.presentacion.clima

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.appdelclima.repository.Clima

class ClimaViewModel : ViewModel() {

    var uiState by mutableStateOf<ClimaEstado>(ClimaEstado.Vacio)


    fun ejecutar(intencion: ClimaIntencion) {
        when (intencion) {
            ClimaIntencion.BorrarTodo -> borrarTodo()
            ClimaIntencion.MostrarCaba -> mostrarCaba()
            ClimaIntencion.MostrarCordoba -> mostrarCordoba()
            ClimaIntencion.MostrarError -> mostrarError()

        }

    }


    private val climaCordoba = Clima(
        ciudad = "Cordoba",
        temperatura = 14,
        estado = "nublado",
        humedad = 18.0F,
        st = 10,
        viento = 30,
        latitud = 547543,
        longitud = 87665,

        )
    private val climaCABA = Clima(
        ciudad = "CABA",
        temperatura = 19,
        estado = "soleado",
        humedad = 17.0F,
        st = 15,
        viento = 40,
        latitud = 677543,
        longitud = 76565,

        )




    private fun mostrarError(){
        uiState = ClimaEstado.Error("Este es un error")
    }

    private fun borrarTodo() {
        uiState = ClimaEstado.Vacio
    }

    private fun mostrarCaba() {
        uiState = ClimaEstado.Exitoso(
            ciudad = climaCABA.ciudad,
            temperatura = climaCABA.temperatura,
            descripcion = climaCABA.estado,
            st = climaCABA.st,

        )
    }

    private fun mostrarCordoba() {
        uiState = ClimaEstado.Exitoso(
            ciudad = climaCordoba.ciudad,
            temperatura = climaCordoba.temperatura,
            descripcion = climaCordoba.estado,
            st = climaCordoba.st,

        )
    }
}