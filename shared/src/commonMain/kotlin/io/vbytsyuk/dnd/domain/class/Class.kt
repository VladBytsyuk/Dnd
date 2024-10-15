package io.vbytsyuk.dnd.domain.`class`

import io.vbytsyuk.dnd.domain.HpDice
import io.vbytsyuk.dnd.domain.proficiencies.Proficiencies
import io.vbytsyuk.dnd.domain.units.Level
import io.vbytsyuk.dnd.domain.units.Trait

interface Class {
    val hpDice: HpDice
    val proficiencies: Proficiencies
    val subClass: SubClass? get() = null
    val classTraitsMap: Map<Level, List<Trait>> get() = emptyMap()
    val traitsMap: Map<Level, List<Trait>>
        get() = buildTraitsMap()
}

interface SubClass {
    val subClassTraitsMap: Map<Level, List<Trait>>
}

private fun Class.buildTraitsMap(): Map<Level, List<Trait>> = buildMap {
    val levels = classTraitsMap.keys + (subClass?.subClassTraitsMap?.keys ?: emptySet())
    levels.forEach { level ->
        val classTraits = classTraitsMap[level] ?: emptyList()
        val subClassTraits = subClass?.subClassTraitsMap?.get(level) ?: emptyList()
        put(level, classTraits + subClassTraits)
    }
}
