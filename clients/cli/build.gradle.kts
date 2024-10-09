plugins {
    kotlin("jvm")
}

group = "io.vbytsyuk.dnd.clients.cli"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":core"))

    testImplementation(project(":test"))
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(20)
}
