package com.example.appdelclima

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.appdelclima.ui.theme.Intencion

class MainPageViewModel : ViewModel() {

    var uiState by mutableStateOf<Estado>(Estado.Vacio)


    fun ejecutarIntencion(intencion: Intencion) {
        when (intencion) {
            Intencion.BorrarTodo -> borrarTodo()
            Intencion.MostrarCaba -> mostrarCaba()
            Intencion.MostrarCordoba -> mostrarCordoba()
            Intencion.MostrarError -> mostrarError()

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
        uiState = Estado.Error("Este es un error")
    }

    private fun borrarTodo() {
        uiState = Estado.Vacio
    }

    private fun mostrarCaba() {
        uiState = Estado.Exitoso(
            ciudad = climaCABA.ciudad,
            temperatura = climaCABA.temperatura,
            descripcion = climaCABA.estado,
            st = climaCABA.st,

        )
    }

    private fun mostrarCordoba() {
        uiState = Estado.Exitoso(
            ciudad = climaCordoba.ciudad,
            temperatura = climaCordoba.temperatura,
            descripcion = climaCordoba.estado,
            st = climaCordoba.st,

        )
    }
}