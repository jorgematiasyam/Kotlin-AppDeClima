package com.example.appdelclima.ui.theme

sealed class Intencion {
    object BorrarTodo : Intencion()
    object MostrarCordoba : Intencion()
    object MostrarCaba : Intencion()
    object MostrarError : Intencion()

}