plugins {
    alias(libs.plugins.kotlinx.serialization)
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.ktor)
}

application {
    mainClass.set("io.ktor.server.netty.EngineMain")
}

tasks {
    processResources {
        dependsOn(":app:jsBrowserDevelopmentExecutableDistribution")
        from(File(rootDir, "app/build/dist/js/developmentExecutable"))
    }
}

dependencies {
    implementation(libs.logback)
    implementation(libs.ktor.server.core)
    implementation(libs.ktor.server.cors)
    implementation(libs.ktor.server.netty)
    implementation(libs.ktor.server.config.yaml)
    implementation(libs.ktor.server.content.negotiation)
    implementation(libs.ktor.server.serialization.json)
    testImplementation(libs.ktor.server.tests)
    testImplementation(libs.kotlin.test.junit)
}