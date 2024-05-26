package io.vbytsyuk.dnd.core.proficiencies

import io.vbytsyuk.dnd.core.skills.Skill

interface Skills {
    val list: List<Skill>
}

data class Skills2(
    val skill1: Skill,
    val skill2: Skill,
) : Skills {
    override val list = setOf(skill1, skill2).toList()

    init {
        checkListSize(requiredSize = 2)
    }
}

data class Skills3(
    val skill1: Skill,
    val skill2: Skill,
    val skill3: Skill,
) : Skills {
    override val list = setOf(skill1, skill2, skill3).toList()

    init {
        checkListSize(requiredSize = 3)
    }
}

data class Skills4(
    val skill1: Skill,
    val skill2: Skill,
    val skill3: Skill,
    val skill4: Skill,
) : Skills {
    override val list = setOf(skill1, skill2, skill3, skill4).toList()

    init {
        checkListSize(requiredSize = 4)
    }
}

private fun Skills.checkListSize(requiredSize: Int) {
    require(list.size == requiredSize){
        "Incorrect skills. Selected $list, but should be $requiredSize unique skills."
    }
}
