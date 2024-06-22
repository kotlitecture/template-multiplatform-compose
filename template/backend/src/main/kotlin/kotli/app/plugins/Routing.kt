package kotli.app.plugins

import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.response.respond
import io.ktor.server.routing.get
import io.ktor.server.routing.routing
import kotlinx.serialization.Serializable

fun Application.configureRouting() {
    routing {
        get("/api/health") {
            call.respond(Health("Hello World!"))
        }
    }
}

@Serializable
data class Health(
    val text: String
)
