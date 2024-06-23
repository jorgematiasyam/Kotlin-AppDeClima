import com.istea.appdelclima.repository.Repositorio
import com.istea.appdelclima.repository.modelos.Ciudad
import com.istea.appdelclima.repository.modelos.Clima
import com.istea.appdelclima.repository.modelos.Clima2
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.http.HttpStatusCode
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
class RepositorioApi : Repositorio {
    private val apiKey = "95e93e4f7a36fc511148468d1774792d"
    private val cliente = HttpClient(){
        install(ContentNegotiation){
            json(Json {
                ignoreUnknownKeys = true
            })
        }
    }
        override suspend fun buscarCiudad(ciudad: String): Array<Ciudad> {
            println("Buscar Ciudad")
            val respuesta = cliente.get("https://api.openweathermap.org/geo/1.0/direct?q=lon&limit=5&appid=95e93e4f7a36fc511148468d1774792d"){
            }
            if (respuesta.status == HttpStatusCode.OK){
                println("Status OK")
                val ciudades = respuesta.body<Array<Ciudad>>()
                return ciudades
            }else{
                println("Status no ok")
                throw Exception()
            }
        }
        override suspend fun traerClima(ciudad: Ciudad): Clima2 {
            val respuesta = cliente.get("https://api.openweathermap.org/data/2.5/weather"){
                parameter("units","metric")
                parameter("appid",apiKey)
            }
            if (respuesta.status == HttpStatusCode.OK){
                val clima = respuesta.body<Clima2>()
                return clima
            }else{
                throw Exception()
            }
        }
        override suspend fun traerPronostico(ciudad: Ciudad): List<Clima2> {
            TODO("Not yet implemented")
        }
        }