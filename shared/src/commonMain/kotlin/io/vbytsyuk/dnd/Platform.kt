package io.vbytsyuk.dnd

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform


