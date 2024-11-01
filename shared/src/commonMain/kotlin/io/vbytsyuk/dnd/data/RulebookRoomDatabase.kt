package io.vbytsyuk.dnd.data

import androidx.room.Database
import androidx.room.RoomDatabase
import io.vbytsyuk.dnd.data.ability.score.db.AbilityScoreDao
import io.vbytsyuk.dnd.data.ability.score.db.AbilityScoreEntity
import io.vbytsyuk.dnd.data.alignment.db.AlignmentDao
import io.vbytsyuk.dnd.data.alignment.db.AlignmentEntity
import io.vbytsyuk.dnd.data.background.db.BackgroundDao
import io.vbytsyuk.dnd.data.background.db.BackgroundEntity
import io.vbytsyuk.dnd.data.condition.db.ConditionDao
import io.vbytsyuk.dnd.data.condition.db.ConditionEntity
import io.vbytsyuk.dnd.data.damage.type.db.DamageTypeDao
import io.vbytsyuk.dnd.data.damage.type.db.DamageTypeEntity
import io.vbytsyuk.dnd.data.equipment.base.db.EquipmentDao
import io.vbytsyuk.dnd.data.equipment.base.db.EquipmentEntity
import io.vbytsyuk.dnd.data.equipment.category.db.EquipmentCategoryDao
import io.vbytsyuk.dnd.data.equipment.category.db.EquipmentCategoryEntity
import io.vbytsyuk.dnd.data.language.db.LanguageDao
import io.vbytsyuk.dnd.data.language.db.LanguageEntity
import io.vbytsyuk.dnd.data.magic.school.db.MagicSchoolDao
import io.vbytsyuk.dnd.data.magic.school.db.MagicSchoolEntity
import io.vbytsyuk.dnd.data.proficiency.db.ProficiencyDao
import io.vbytsyuk.dnd.data.proficiency.db.ProficiencyEntity
import io.vbytsyuk.dnd.data.rule.base.db.RuleDao
import io.vbytsyuk.dnd.data.rule.base.db.RuleEntity
import io.vbytsyuk.dnd.data.rule.section.db.RuleSectionDao
import io.vbytsyuk.dnd.data.rule.section.db.RuleSectionEntity
import io.vbytsyuk.dnd.data.skill.db.SkillDao
import io.vbytsyuk.dnd.data.skill.db.SkillEntity
import io.vbytsyuk.dnd.data.weapon.property.db.RoomWeaponPropertyDao
import io.vbytsyuk.dnd.data.weapon.property.db.WeaponPropertyEntity

@Database(
    entities = [
        ConditionEntity::class,
        DamageTypeEntity::class,
        WeaponPropertyEntity::class,
        AlignmentEntity::class,
        MagicSchoolEntity::class,
        LanguageEntity::class,
        RuleSectionEntity::class,
        RuleEntity::class,
        AbilityScoreEntity::class,
        SkillEntity::class,
        EquipmentCategoryEntity::class,
        EquipmentEntity::class,
        BackgroundEntity::class,
        ProficiencyEntity::class,
    ],
    version = RulebookRoomDatabase.VERSION,
)
abstract class RulebookRoomDatabase : RoomDatabase() {

    companion object {
        const val VERSION = 1
        const val FILENAME = "rulebook.db"
    }

    abstract fun getConditionDao(): ConditionDao
    abstract fun getDamageTypeDao(): DamageTypeDao
    abstract fun getWeaponPropertyDao(): RoomWeaponPropertyDao
    abstract fun getAlignmentDao(): AlignmentDao
    abstract fun getMagicSchoolDao(): MagicSchoolDao
    abstract fun getLanguageDao(): LanguageDao
    abstract fun getRuleSectionDao(): RuleSectionDao
    abstract fun getRuleDao(): RuleDao
    abstract fun getAbilityScoreDao(): AbilityScoreDao
    abstract fun getSkillDao(): SkillDao
    abstract fun getEquipmentCategoryDao(): EquipmentCategoryDao
    abstract fun getEquipmentDao(): EquipmentDao
    abstract fun getBackgroundDao(): BackgroundDao
    abstract fun getProficiencyDao(): ProficiencyDao
}
