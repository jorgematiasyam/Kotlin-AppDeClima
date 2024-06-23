package com.example.appdelclima.presentacion.ciudades
import CiudadesView
import CiudadesViewModel
import CiudadesViewModelFactory
import RepositorioApi
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.istea.appdelclima.repository.RepositorioApi

@Composable
fun CiudadesPage(){

    val viewModel : CiudadesViewModel = viewModel(
        factory = CiudadesViewModelFactory(
            repositorio = RepositorioApi()
        )
    )
    CiudadesView(
        state = viewModel.uiState,
        onAction = { intencion ->
            viewModel.ejecutar(intencion)
        }
    )
}