package io.vbytsyuk.dnd.db

import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.coroutines.Dispatchers
import java.io.File

fun getDatabaseBuilder(): RoomDatabase.Builder<RulebookDatabase> {
    val dbFile = File(RulebookDatabase.FILENAME)
    return Room.databaseBuilder<RulebookDatabase>(name = dbFile.absolutePath)
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
}

fun getDatabase(): RulebookDatabase {
    return getDatabaseBuilder().build()
}
