package io.vbytsyuk.dnd

class JvmPlatform : Platform {
    override val name: String = "Java ${System.getProperty("java.version")}"
}

actual fun getPlatform(): Platform = JvmPlatform()
