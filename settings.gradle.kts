plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}
rootProject.name = "Dnd"
include("core")
include("clients:cli")
include("test")
