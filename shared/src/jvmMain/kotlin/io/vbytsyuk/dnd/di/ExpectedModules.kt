package io.vbytsyuk.dnd.di

import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import io.vbytsyuk.dnd.db.RulebookDatabase
import io.vbytsyuk.dnd.db.RulebookDatabaseProvider
import kotlinx.coroutines.Dispatchers
import org.koin.core.module.Module
import org.koin.dsl.module
import java.io.File

actual fun databaseModule(): Module = module {
    factory<RulebookDatabaseProvider> { JvmRulebookDatabaseProvider() }
}

class JvmRulebookDatabaseProvider : RulebookDatabaseProvider {

    override fun provide(): RulebookDatabase = getDatabaseBuilder().build()

    private fun getDatabaseBuilder(): RoomDatabase.Builder<RulebookDatabase> {
        val dbFile = File(RulebookDatabase.FILENAME)
        return Room.databaseBuilder<RulebookDatabase>(name = dbFile.absolutePath)
            .setDriver(BundledSQLiteDriver())
            .setQueryCoroutineContext(Dispatchers.IO)
    }
}
