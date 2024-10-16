package io.vbytsyuk.dnd.domain

import io.vbytsyuk.dnd.domain.alignment.Alignment
import io.vbytsyuk.dnd.domain.condition.Condition
import io.vbytsyuk.dnd.domain.damage.type.DamageType
import io.vbytsyuk.dnd.domain.weapon.property.WeaponProperty

data class Rulebook(
    val conditions: List<Condition>,
    val damageTypes: List<DamageType>,
    val weaponProperties: List<WeaponProperty>,
    val alignments: List<Alignment>,
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
    """.trimIndent()
}
