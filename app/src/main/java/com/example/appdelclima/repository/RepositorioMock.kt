package com.istea.appdelclima.repository
import com.example.appdelclima.repository.modelos.ListForecast
import com.istea.appdelclima.repository.modelos.Ciudad
import com.istea.appdelclima.repository.modelos.Clima
class RepositorioMock  : Repositorio {

    val cordoba = Ciudad(name = "Cordoba",
        lat = -23.0f,
        lon = -24.3f,
        country = "Argentina")
    val bsAs =Ciudad(name = "Buenos Aires",
        lat = -23.0f,
        lon = -24.3f,
        country = "Argentina")
    val laPlata =Ciudad(name = "La Plata",
        lat = -23.0f,
        lon = -24.3f,
        country = "Argentina")

    val ciudades = listOf(cordoba,bsAs,laPlata)




    override suspend fun buscarCiudad(ciudad: String): List<Ciudad> {
        return ciudades.filter { it.name.contains(ciudad,ignoreCase = true) }
    }
    override suspend fun traerClima(lat: Float, lon: Float): Clima {
        TODO("Not yet implemented")
    }
    override suspend fun traerPronostico(nombre: String): List<ListForecast> {
        TODO("Not yet implemented")
    }
}