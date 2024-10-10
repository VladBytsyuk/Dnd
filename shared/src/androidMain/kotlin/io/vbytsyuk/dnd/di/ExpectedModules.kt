package io.vbytsyuk.dnd.di

import android.content.Context
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
    factory<RulebookDatabaseProvider> { AndroidRulebookDatabaseProvider(context = get()) }
}

class AndroidRulebookDatabaseProvider(val context: Context) : RulebookDatabaseProvider {

    override fun provide(): RulebookDatabase = getDatabaseBuilder().build()

    fun getDatabaseBuilder(): RoomDatabase.Builder<RulebookDatabase> {
        val appContext = context.applicationContext
        val dbFile = appContext.getDatabasePath(RulebookDatabase.FILENAME)
        return Room.databaseBuilder<RulebookDatabase>(context = appContext, name = dbFile.absolutePath)
            .setDriver(BundledSQLiteDriver())
            .setQueryCoroutineContext(Dispatchers.IO)
    }
}
