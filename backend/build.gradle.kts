plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(ktorLibs.plugins.ktor)
    alias(libs.plugins.kotlin.serialization)
}

group = "io.github.phobosxiii"
version = "1.0.0-SNAPSHOT"

application {
    mainClass = "io.ktor.server.cio.EngineMain"
}

dependencies {
    implementation(projects.shared)

    implementation(ktorLibs.serialization.kotlinx.json)
    implementation(ktorLibs.server.auth)
    implementation(ktorLibs.server.auth.jwt)
    implementation(ktorLibs.server.callLogging)
    implementation(ktorLibs.server.cio)
    implementation(ktorLibs.server.contentNegotiation)
    implementation(ktorLibs.server.core)
    implementation(ktorLibs.server.websockets)
    implementation(libs.logback.classic)

    implementation(exposedLibs.core)
    implementation(exposedLibs.dao)
    implementation(exposedLibs.jdbc)
    implementation(libs.hikaricp)
    implementation(libs.postgresql)
    implementation(libs.h2)

    testImplementation(kotlin("test"))
    testImplementation(ktorLibs.server.testHost)
}
