package io.vbytsyuk.dnd.db

import androidx.room.Database
import androidx.room.RoomDatabase
import io.vbytsyuk.dnd.db.condition.ConditionDao
import io.vbytsyuk.dnd.db.condition.ConditionEntity

@Database(
    entities = [
        ConditionEntity::class,
    ],
    version = RulebookDatabase.VERSION,
)
abstract class RulebookDatabase : RoomDatabase() {

    companion object {
        const val VERSION = 1
        const val FILENAME = "rulebook.db"
    }

    abstract fun getConditionDao(): ConditionDao
}
