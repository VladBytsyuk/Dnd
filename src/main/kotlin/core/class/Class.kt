package io.vbytsyuk.dnd.core.`class`

import io.vbytsyuk.dnd.core.HpDice
import io.vbytsyuk.dnd.core.StatType
import io.vbytsyuk.dnd.core.proficiencies.Skills
import io.vbytsyuk.dnd.core.skills.Skill

sealed class Class(
    val hpDice: HpDice,
    val proficientSavingThrows: List<StatType>,
    val allowedProficientSkills: List<Skill>,
    val selectedProficientSkills: Skills,
) {

    init {
        checkProficientSkills()
    }

    private fun checkProficientSkills() {
        require(selectedProficientSkills.list.all { it in allowedProficientSkills }) {
            """
                Incorrect proficient skills. Selected ${selectedProficientSkills.list},
                but should be ${selectedProficientSkills.list.size} of $allowedProficientSkills.
            """.trimIndent()
        }
    }
}
