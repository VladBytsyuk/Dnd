package io.vbytsyuk.dnd.data

import androidx.room.Database
import androidx.room.RoomDatabase
import io.vbytsyuk.dnd.data.alignment.db.AlignmentEntity
import io.vbytsyuk.dnd.data.alignment.db.RoomAlignmentDao
import io.vbytsyuk.dnd.data.condition.db.ConditionEntity
import io.vbytsyuk.dnd.data.condition.db.RoomConditionDao
import io.vbytsyuk.dnd.data.damage.type.db.DamageTypeEntity
import io.vbytsyuk.dnd.data.damage.type.db.RoomDamageTypeDao
import io.vbytsyuk.dnd.data.magic.school.db.MagicSchoolEntity
import io.vbytsyuk.dnd.data.magic.school.db.RoomMagicSchoolDao
import io.vbytsyuk.dnd.data.weapon.property.db.RoomWeaponPropertyDao
import io.vbytsyuk.dnd.data.weapon.property.db.WeaponPropertyEntity

@Database(
    entities = [
        ConditionEntity::class,
        DamageTypeEntity::class,
        WeaponPropertyEntity::class,
        AlignmentEntity::class,
        MagicSchoolEntity::class,
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
    abstract fun getWeaponPropertyDao(): RoomWeaponPropertyDao
    abstract fun getAlignmentDao(): RoomAlignmentDao
    abstract fun getMagicSchoolDao(): RoomMagicSchoolDao
}
