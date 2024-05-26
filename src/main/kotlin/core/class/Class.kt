package io.vbytsyuk.dnd.core.`class`

import io.vbytsyuk.dnd.core.HpDice
import io.vbytsyuk.dnd.core.proficiencies.Proficiencies
import io.vbytsyuk.dnd.core.proficiencies.ProficiencySkills

sealed class Class(
    val hpDice: HpDice,
    val proficiencies: Proficiencies,
) {

    init {
        proficiencies.check()
    }

    private fun Proficiencies.check() {
        skills.check()
    }

    private fun ProficiencySkills.check() {
        require(selected.list.all { it in allowed }) {
            """
                Incorrect proficient skills for ${this@Class::class.simpleName}.
                Selected ${selected.list},
                but should be ${selected.list.size} of $allowed.
            """.trimIndent()
        }
    }
}
