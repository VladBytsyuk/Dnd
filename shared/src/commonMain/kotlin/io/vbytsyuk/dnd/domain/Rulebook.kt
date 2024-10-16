package io.vbytsyuk.dnd.domain

import io.vbytsyuk.dnd.domain.alignment.Alignment
import io.vbytsyuk.dnd.domain.condition.Condition
import io.vbytsyuk.dnd.domain.damage.type.DamageType
import io.vbytsyuk.dnd.domain.language.Language
import io.vbytsyuk.dnd.domain.magic.school.MagicSchool
import io.vbytsyuk.dnd.domain.rule.Rule
import io.vbytsyuk.dnd.domain.weapon.property.WeaponProperty

data class Rulebook(
    val conditions: List<Condition>,
    val damageTypes: List<DamageType>,
    val weaponProperties: List<WeaponProperty>,
    val alignments: List<Alignment>,
    val magicSchools: List<MagicSchool>,
    val languages: List<Language>,
    val rules: List<Rule>,
) {

    override fun toString(): String = """
        Conditions:
            $conditions
            
        DamageTypes:
            $damageTypes
            
        Weapon properties:
            $weaponProperties
            
        Alignments:
            $alignments
            
        Magic schools:
            $magicSchools
            
        Languages:
            $languages
            
        Rules:
            $rules
    """.trimIndent()
}
