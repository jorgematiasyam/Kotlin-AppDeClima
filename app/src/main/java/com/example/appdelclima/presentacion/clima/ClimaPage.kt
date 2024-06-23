package com.istea.appdelclima.presentacion.clima
import ClimaViewModel
import ClimaViewModelFactory
import RepositorioApi
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.appdelclima.router.Enrutador
import com.istea.appdelclima.presentacion.ciudades.CiudadesViewModel
import com.istea.appdelclima.presentacion.ciudades.CiudadesViewModelFactory
import com.istea.appdelclima.repository.RepositorioApi
import com.istea.appdelclima.repository.RepositorioMock
import com.istea.appdelclima.repository.modelos.Ciudad
import com.istea.appdelclima.router.Enrutador
import com.istea.appdelclima.router.Router

@Composable
fun ClimaPage(

    navHostController: NavHostController,
    lat : Float,
    lon : Float
){
    val viewModel : ClimaViewModel = viewModel(
        factory = ClimaViewModelFactory(
            repositorio = RepositorioApi(),

            router = Enrutador(navHostController),
            lat = lat,
            lon = lon
        )
    )
    ClimaView(
        state = viewModel.uiState,
        onAction = { intencion ->
            viewModel.ejecutar(intencion)
        }
    )
}