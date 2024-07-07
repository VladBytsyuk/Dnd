package io.vbytsyuk.dnd.core.race

import io.vbytsyuk.dnd.core.StatBlock
import io.vbytsyuk.dnd.core.StatType.CON
import io.vbytsyuk.dnd.core.armor.Armor.Type.Light
import io.vbytsyuk.dnd.core.armor.Armor.Type.Medium
import io.vbytsyuk.dnd.core.proficiencies.Proficiencies
import io.vbytsyuk.dnd.core.skills.Skill.Intelligence.History
import io.vbytsyuk.dnd.core.tools.BrewersSupplies
import io.vbytsyuk.dnd.core.tools.MasonsTools
import io.vbytsyuk.dnd.core.tools.SmithsTools
import io.vbytsyuk.dnd.core.tools.Tools
import io.vbytsyuk.dnd.core.units.*
import io.vbytsyuk.dnd.core.units.Damage.Type.POISON
import io.vbytsyuk.dnd.core.units.Language.Common
import io.vbytsyuk.dnd.core.units.Language.Dwarvish
import io.vbytsyuk.dnd.core.weapon.Battleaxe
import io.vbytsyuk.dnd.core.weapon.Handaxe
import io.vbytsyuk.dnd.core.weapon.LightHammer
import io.vbytsyuk.dnd.core.weapon.Warhammer

sealed class Dwarf(
    override val description: String,
    override val bonusStatBlock: StatBlock,
    selectedTool: Tools,
    proficiencies: Proficiencies = Proficiencies(),
    traits: List<Trait> = emptyList(),
) : Race {

    override val size = Size.MEDIUM
    override val baseSpeed = Speed(25.feet)
    override val darkVision = 60.feet
    override val proficiencies = Proficiencies(
        weapons = { it in listOf(Battleaxe, Handaxe, LightHammer, Warhammer) },
        languages = { it in listOf(Common, Dwarvish) },
        tools = { it == selectedTool },
    ) + proficiencies
    override val traits = listOf(DwarvenResilience, Stonecunning) + traits
    override val ageInfo = AgeInfo(mature = 50.years, limit = 350.years)
    override val alignmentRecommendation = """
        Most dwarves are lawful, believing firmly in the benefits of a well-ordered society. They tend toward good as 
        well, with a strong sense of fair play and a belief that everyone deserves to share in the benefits of a just 
        order.
    """.trimIndent()
    override val names = Names(
        male = listOf(
            "Adrik", "Alberich", "Baern", "Barendd", "Brottor", "Bruenor", "Dain", "Darrak", "Delg", "Eberk",
            "Einkil", "Fargrim", "Flint", "Gardain", "Harbek", "Kildrak", "Morgran", "Orsik", "Oskar", "Rangrim",
            "Rurik", "Taklinn", "Thoradin", "Thorin", "Tordek", "Traubon", "Travok", "Ulfgar", "Veit", "Vondal",
        ),
        female = listOf(
            "Amber", "Artin", "Audhild", "Bardryn", "Dagnal", "Diesa", "Eldeth", "Falkrunn", "Finellen", "Gunnloda",
            "Gurdis", "Helja", "Hlin", "Kathra", "Kristryd", "Ide", "Liftrasa", "Mardred", "Riswynn", "Sannl",
            "Torbera", "Torgga", "Vistra",
        ),
        surnames = listOf(
            "Balderk", "Battlehammer", "Brawnanvil", "Dankil", "Fireforge", "Frostbeard", "Gorunn", "Holderhek",
            "Ironfist", "Loderr", "Lutgehr", "Rumnaheim", "Strakeln", "Torunn", "Ungart",
        )
    )

    class Mountain(selectedTool: Tools) : Dwarf(
        description = "As a mountain dwarf, you're strong and hardy, accustomed to a difficult life in rugged terrain.",
        bonusStatBlock = StatBlock(strength = 2, constitution = 2),
        selectedTool = selectedTool,
        proficiencies = Proficiencies(armor = { it.type is Light || it.type is Medium }),
        traits = listOf(DwarvenArmorTraining),
    )

    class Hill(selectedTool: Tools) : Dwarf(
        description = "As a hill dwarf, you have keen senses, deep intuition, and remarkable resilience.",
        bonusStatBlock = StatBlock(constitution = 2, wisdom = 1),
        selectedTool = selectedTool,
        traits = listOf(DwarvenToughness),
    )


    init {
        requireSelectedToolAllowed(selectedTool)
    }

    private fun requireSelectedToolAllowed(tool: Tools) = require(tool in allowedTools) {
        "Incorrect tool selected ($tool). Should be one of $allowedTools"
    }

    companion object {
        private val allowedTools = listOf(SmithsTools, BrewersSupplies, MasonsTools)
    }
}

val DwarvenResilience = Trait(
    name = "Dwarven Resilience",
    description = "You have advantage on saving throws against poison, and you have resistance against poison damage.",
    affect = Affect(savingThrows = { it == CON }, resistances = { it == POISON })
)

val Stonecunning = Trait(
    name = "Stonecunning",
    description = """
        Whenever you make an Intelligence (History) check related to the origin of stonework, you are considered 
        proficient in the History skill and add double your proficiency bonus to the check, instead of your normal 
        proficiency bonus.
    """.trimIndent(),
    affect = Affect(skills = { it is History }),
)

val DwarvenToughness = Trait(
    name = "Dwarven Toughness",
    description = "Your hit point maximum increases by 1, and it increases by 1 every time you gain a level.",
    affect = Affect(hpForLevel = 1),
)

val DwarvenArmorTraining = Trait(
    name = "Dwarven Armor Training",
    description = "You have proficiency with light and medium armor.",
)
