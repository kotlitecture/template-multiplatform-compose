package kotli.app.plugins

import io.ktor.server.application.Application
import io.ktor.server.http.content.singlePageApplication
import io.ktor.server.routing.routing

fun Application.configureSinglePageApplication() {
    routing {
        singlePageApplication {
            defaultPage = "index.html"
            useResources = true
            filesPath = ""
        }
    }
}
