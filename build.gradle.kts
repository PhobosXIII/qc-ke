val ktorVersion: String by project
val kotlinVersion: String by project
val kotlinCssVersion: String by project
val logbackVersion: String by project

plugins {
    application
    kotlin("jvm") version "1.5.20"
}

group = "ru.quect"
version = "4.0.0"

application {
    mainClass.set("io.ktor.server.netty.EngineMain")
}

kotlin.sourceSets["main"].kotlin.srcDirs("src")
kotlin.sourceSets["test"].kotlin.srcDirs("test")

sourceSets["main"].resources.srcDirs("resources")
sourceSets["test"].resources.srcDirs("testresources")

repositories {
    mavenLocal()
    maven { url = uri("https://kotlin.bintray.com/ktor") }
    maven { url = uri("https://kotlin.bintray.com/kotlin-js-wrappers") }
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("ch.qos.logback:logback-classic:$logbackVersion")
    implementation("io.ktor:ktor-server-netty:$ktorVersion")
    implementation("io.ktor:ktor-server-core:$ktorVersion")
    implementation ("io.ktor:ktor-server-sessions:$ktorVersion")
    implementation ("io.ktor:ktor-locations:$ktorVersion")
    implementation ("io.ktor:ktor-auth:$ktorVersion")
    implementation ("io.ktor:ktor-auth-jwt:$ktorVersion")
    implementation ("io.ktor:ktor-serialization:$ktorVersion")
    implementation("io.ktor:ktor-html-builder:$ktorVersion")
    implementation("org.jetbrains:kotlin-css-jvm:$kotlinCssVersion")
    testImplementation("io.ktor:ktor-server-tests:$ktorVersion")
}
