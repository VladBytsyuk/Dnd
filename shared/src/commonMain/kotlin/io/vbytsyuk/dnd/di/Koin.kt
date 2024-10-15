package io.vbytsyuk.dnd.di

import io.vbytsyuk.dnd.di.modules.readerModule
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.dsl.KoinAppDeclaration

object Koin {

    var app: KoinApplication? = null

    fun init(config: KoinAppDeclaration? = null): KoinApplication = app ?: start(config).also { app = it }

    fun stop() {
        stopKoin()
    }

    private fun start(config: KoinAppDeclaration? = null) = startKoin {
        config?.invoke(this)
        modules(
            databaseModule(),
            readerModule(),
        )
    }
}
