plugins {
    kotlin("jvm") version "1.9.23"
}

group = "io.vbytsyuk.dnd"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":core"))

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}