package io.vbytsyuk.dnd.di

import io.vbytsyuk.dnd.di.modules.readerModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

class KoinInitializer {

    fun init(config: KoinAppDeclaration? = null) = startKoin {
        config?.invoke(this)
        modules(
            databaseModule(),
            readerModule(),
        )
    }
}
