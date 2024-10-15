package io.vbytsyuk.dnd.data

import androidx.room.Database
import androidx.room.RoomDatabase
import io.vbytsyuk.dnd.data.condition.ConditionEntity
import io.vbytsyuk.dnd.data.condition.RoomConditionDao

@Database(
    entities = [
        ConditionEntity::class,
    ],
    version = RulebookRoomDatabase.VERSION,
)
abstract class RulebookRoomDatabase : RoomDatabase() {

    companion object {
        const val VERSION = 1
        const val FILENAME = "rulebook.db"
    }

    abstract fun getConditionDao(): RoomConditionDao
}
