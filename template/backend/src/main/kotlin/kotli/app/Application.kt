package kotli.app

import io.ktor.server.application.Application
import kotli.app.plugins.configureRouting
import kotli.app.plugins.configureCors
import kotli.app.plugins.configureSerialization
import kotli.app.plugins.configureSinglePageApplication

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureSinglePageApplication()
    configureSerialization()
    configureRouting()
    configureCors()
}
