import io.gitlab.arturbosch.detekt.Detekt

plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.jetbrainsCompose) apply false
    alias(libs.plugins.compose.compiler) apply false
    alias(libs.plugins.kotlinJvm) apply false
    alias(libs.plugins.kotlinMultiplatform) apply false
    alias(libs.plugins.room) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.detekt) apply false
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
