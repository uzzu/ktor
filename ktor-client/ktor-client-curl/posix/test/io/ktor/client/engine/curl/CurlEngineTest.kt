import io.ktor.client.*
import io.ktor.client.engine.curl.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import kotlinx.coroutines.*
import kotlin.test.*

@Test
fun test() = runBlocking {
    val client = HttpClient(Curl) {
        install(Logging) {
            level = LogLevel.ALL
        }
    }

    client.get<String>(urlString = "http://httpbin.org/get")
    client.put<String>(urlString = "http://httpbin.org/put") {
        body = "PUUUUT"
    }

    client.post<String>(urlString = "http://httpbin.org/post") {
        body = "POOST"
    }

    client.close()
}
