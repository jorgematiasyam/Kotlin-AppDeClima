package com.example.appdelclima.router

import androidx.navigation.NavHostController
import android.annotation.SuppressLint

class Enrutador(
    val navHostController: NavHostController
): Router {


    @SuppressLint("DefaultLocale")
    override fun navegar(ruta: Ruta) {
        when(ruta){
            Ruta.Ciudades -> navHostController.navigate(ruta.id)

            is Ruta.Clima -> {
                val route = String.format(format="%s?lat=%f&lon=%f",ruta.id,ruta.lat,ruta.lon)
                navHostController.navigate(route)
            }
        }
    }
}