import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.10"
    kotlin("plugin.serialization") version "1.4.10"
    application
}
group = "dev.loosername"
version = "1.0-SNAPSHOT"

application {
    mainClassName = "dev.loosername.MainKt"
}

repositories {
    jcenter()
    mavenCentral()
}
dependencies {
    implementation("io.javalin:javalin:3.11.0")
    implementation("io.javalin:javalin-openapi:3.11.0")
    implementation("org.slf4j:slf4j-simple:1.7.30")
    implementation("io.swagger.core.v3:swagger-core:2.1.5")
    implementation("org.webjars:swagger-ui:3.36.0")
    implementation("org.webjars.npm:redoc:2.0.0-rc.31")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.0.1")
    testImplementation(kotlin("test-junit5"))
}
tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}