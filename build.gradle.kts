import io.gitlab.arturbosch.detekt.Detekt

plugins {
    kotlin("jvm") version "1.9.23"
    id("io.gitlab.arturbosch.detekt") version "1.23.3"
}

group = "io.vbytsyuk.dnd"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":core"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.register<Detekt>("DndDetekt") {
    setSource(files("$rootDir"))
    debug = true
    config.setFrom(files("$rootDir/config/detekt/detekt.yml"))
    reports {
        html.required.set(true)
    }
    include("**/*.kt")
    include("**/*.kts")
    exclude("resources/")
    exclude("build/")
}
