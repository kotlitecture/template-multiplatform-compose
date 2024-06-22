plugins {
    alias(libs.plugins.kotlinx.serialization)
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.ktor)
}

application {
    mainClass.set("io.ktor.server.netty.EngineMain")
}

dependencies {
    implementation(libs.logback)
    implementation(libs.ktor.server.core)
    implementation(libs.ktor.server.cors)
    implementation(libs.ktor.server.netty)
    implementation(libs.ktor.server.config.yaml)
    implementation(libs.ktor.server.content.negotiation)
    implementation(libs.ktor.server.serialization.json)
    implementation(projects.shared.domain)
    testImplementation(libs.ktor.server.tests)
    testImplementation(libs.kotlin.test.junit)
}

// {platform.js.config}
tasks {
    val resourcesMain by lazy { project.layout.buildDirectory.dir("resources/main").get().asFile }
    register("runDevSPA") {
        group = "spa"
        dependsOn(":app:jsBrowserDevelopmentExecutableDistribution")
        doLast {
            copy {
                from(File(rootDir, "app/build/dist/js/developmentExecutable"))
                into(resourcesMain)
            }
        }
        finalizedBy("run")
    }
    register("runProdSPA") {
        group = "spa"
        dependsOn(":app:jsBrowserDistribution")
        doLast {
            copy {
                from(File(rootDir, "app/build/dist/js/productionExecutable"))
                into(resourcesMain)
            }
        }
        finalizedBy("run")
    }
    register("assembleSPA") {
        group = "spa"
        dependsOn(":app:jsBrowserDistribution")
        doLast {
            copy {
                from(File(rootDir, "app/build/dist/js/productionExecutable"))
                into(resourcesMain)
            }
        }
        finalizedBy("assemble")
    }
}
// {platform.js.config}
