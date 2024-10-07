plugins {
    kotlin("jvm")
}

group = "io.vbytsyuk.dnd.test"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(20)
}
