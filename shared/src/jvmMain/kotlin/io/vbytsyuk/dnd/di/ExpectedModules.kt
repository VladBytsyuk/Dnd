package io.vbytsyuk.dnd.di

import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import io.vbytsyuk.dnd.data.RulebookDatabaseProvider
import io.vbytsyuk.dnd.data.RulebookRoomDatabase
import kotlinx.coroutines.Dispatchers
import org.koin.core.module.Module
import org.koin.dsl.module
import java.io.File

actual fun databaseModule(): Module = module {
    factory<RulebookDatabaseProvider> { JvmRulebookDatabaseProvider() }
}

class JvmRulebookDatabaseProvider : RulebookDatabaseProvider {

    override fun provide(): RulebookRoomDatabase = getDatabaseBuilder().build()

    private fun getDatabaseBuilder(): RoomDatabase.Builder<RulebookRoomDatabase> {
        val dbFile = File(RulebookRoomDatabase.FILENAME)
        return Room.databaseBuilder<RulebookRoomDatabase>(name = dbFile.absolutePath)
            .setDriver(BundledSQLiteDriver())
            .setQueryCoroutineContext(Dispatchers.IO)
    }
}
