package com.example.appdelclima.presentacion.clima.pronostico


import com.example.appdelclima.repository.modelos.ListForecast
import com.istea.appdelclima.repository.modelos.Clima

sealed class PronosticoEstado {
    data class Exitoso (
        val climas: List<ListForecast>,
    ) : PronosticoEstado()
    data class Error(
        val mensaje :String = "",
    ) : PronosticoEstado()
    data object Vacio: PronosticoEstado()
    data object Cargando: PronosticoEstado()

}