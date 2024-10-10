package io.vbytsyuk.dnd.di

import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

class KoinInitializer {

    fun init(config: KoinAppDeclaration? = null) = startKoin {
        config?.invoke(this)
        modules(
            databaseModule(),
        )
    }
}
