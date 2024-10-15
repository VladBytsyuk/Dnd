

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.room)
    alias(libs.plugins.ksp)
    alias(libs.plugins.kotlinSerialization)
}

kotlin {
    jvm()

    sourceSets {
        commonMain.dependencies {
            implementation(libs.koin.core)
            api(libs.koin.core)
            implementation(libs.koin.compose)
            implementation(libs.koin.composeVM)
            implementation(libs.kotlin.serizlization)
            implementation(libs.okio.common)
            api(libs.androidx.room.runtime)
            implementation(libs.sqlite.bundled)
            implementation(libs.sqlite)
            implementation(libs.sqlite.bundled)

            // put your Multiplatform dependencies here
        }

        commonTest {
            dependencies {
                implementation(libs.kotlin.test)
                implementation(libs.okio.test)
            }
        }
    }
}

dependencies {
    add("kspJvm", libs.androidx.room.compiler)
}

room {
    schemaDirectory("$projectDir/schemas")
}
