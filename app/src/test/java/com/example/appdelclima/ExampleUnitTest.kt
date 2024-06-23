package com.example.appdelclima

import CiudadesViewModel
import CiudadesViewModelFactory
import com.example.appdelclima.presentacion.ciudades.CiudadesEstado
import com.example.appdelclima.presentacion.ciudades.CiudadesIntencion
import com.example.appdelclima.router.MockRouter
import com.istea.appdelclima.repository.RepositorioMock
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert.*
import org.junit.After
import org.junit.Test
import org.junit.Before
import kotlin.time.Duration.Companion.seconds

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    private val mainThreadSurrogate = newSingleThreadContext("UI thread")
    @Before
    fun setUp() {
        Dispatchers.setMain(mainThreadSurrogate)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        mainThreadSurrogate.close()
    }

    @Test
    fun ciudadesViewModel_buscar_cor()  = runTest(timeout = 3.seconds) {
        val repositorio = RepositorioMock()
        val router = MockRouter()

        val factory = CiudadesViewModelFactory(repositorio,router)
        val viewModel = factory.create(CiudadesViewModel::class.java)
        val estadoEsperado = CiudadesEstado.Resultado(listOf(repositorio.cordoba))

        launch(Dispatchers.Main) {
            viewModel.ejecutar(intencion = CiudadesIntencion.Buscar("cor"))
            delay(2.seconds)
            assertEquals(estadoEsperado, viewModel.uiState)
        }
    }
}