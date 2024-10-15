package io.vbytsyuk.dnd.data

import androidx.room.Database
import androidx.room.RoomDatabase
import io.vbytsyuk.dnd.data.condition.db.ConditionEntity
import io.vbytsyuk.dnd.data.condition.db.RoomConditionDao
import io.vbytsyuk.dnd.data.damage.type.db.DamageTypeEntity
import io.vbytsyuk.dnd.data.damage.type.db.RoomDamageTypeDao

@Database(
    entities = [
        ConditionEntity::class,
        DamageTypeEntity::class,
    ],
    version = RulebookRoomDatabase.VERSION,
)
abstract class RulebookRoomDatabase : RoomDatabase() {

    companion object {
        const val VERSION = 1
        const val FILENAME = "rulebook.db"
    }

    abstract fun getConditionDao(): RoomConditionDao
    abstract fun getDamageTypeDao(): RoomDamageTypeDao
}
