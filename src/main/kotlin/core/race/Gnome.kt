package io.vbytsyuk.dnd.core.race

import io.vbytsyuk.dnd.core.StatBlock
import io.vbytsyuk.dnd.core.StatType.*
import io.vbytsyuk.dnd.core.proficiencies.Proficiencies
import io.vbytsyuk.dnd.core.proficiencies.Skills
import io.vbytsyuk.dnd.core.skills.Skill.Intelligence.History
import io.vbytsyuk.dnd.core.skills.Skill.Wisdom.AnimalHandling
import io.vbytsyuk.dnd.core.tools.TinkersTools
import io.vbytsyuk.dnd.core.units.*
import io.vbytsyuk.dnd.core.units.Language.COMMON
import io.vbytsyuk.dnd.core.units.Language.GNOMISH

sealed class Gnome(
    description: String,
    bonusStatBlock: StatBlock,
    proficiencies: Proficiencies = Proficiencies(),
    feats: List<Feat> = emptyList(),
) : Race(
    description = description,
    bonusStatBlock = bonusStatBlock,
    size = Size.SMALL,
    baseSpeed = Speed(25.feet),
    darkVision = 60.feet,
    ageInfo = AgeInfo(mature = 18.years, limit = 350.years..500.years),
    proficiencies = Proficiencies(
        languages = { it in listOf(COMMON, GNOMISH) },
    ) + proficiencies,
    alignmentRecommendation = """
        Gnomes are most often good. Those who tend toward law are sages, engineers, researchers, scholars, 
        investigators, or inventors. Those who tend toward chaos are minstrels, tricksters, wanderers, or fanciful 
        jewelers. Gnomes are good-hearted, and even the tricksters among them are more playful than vicious.
    """.trimIndent(),
    feats = listOf(
        Feat(
            name = "Gnome Cunning",
            description = "You have advantage on all Intelligence, Wisdom, and Charisma saving throws against magic.",
            affect = Affect(savingThrows = listOf(INT, WIS, CHA)),
        ),
    ) + feats,
    names = Names(
        male = listOf(
            "Alston", "Alvyn", "Boddynock", "Brocc", "Burgell", "Dimble", "Eldon", "Erky", "Fonkin", "Frug", "Gerbo",
            "Gimble", "Glim", "Jebeddo", "Kellen", "Namfoodle", "Orryn", "Roondar", "Seebo", "Sindri", "Warryn",
            "Wrenn", "Zook",
        ),
        female = listOf(
            "Bimpnollin", "Breena", "Caramip", "Carlin", "Donella", "Duvamil", "ElIa", "ElIyjobell", "ElIywick",
            "Lilli", "Loopmottin", "Lorilla", "Mardnab", "Nissa", "Nyx", "Oda", "Orla", "Roywyn", "Shamil", "Tana",
            "Waywocket", "Zanna",
        ),
        surnames = listOf(
            "Beren", "Daergel", "Folkor", "Garrick", "Nackle", "Murnig", "Ningel", "Raulnor", "Scheppen", "Timbers",
            "Turen",
        ),
        nicknames = listOf(
            "Aleslosh", "Ashhearlh", "Badger", "Cloak", "Doublelock", "Filchbatler", "Fnipper", "Ku", "Nim", "Oneshoe",
            "Pock", "Sparklegem", "Stumbleduck"),
    )
) {

    data object Forest : Gnome(
        description = "As a forest gnome, you have a natural knack for illusion and inherent quickness and stealth.",
        bonusStatBlock = StatBlock(intelligence = 2, dexterity = 1),
        feats = listOf(
            Feat(
                name = "Natural Illusionist",
                description = "You know the minor illusion cantrip. Intelligence is your spellcasting ability for it.",
                affect = Affect(spells = mapOf(Spell("Minor illusion") to INT)),
            ),
            Feat(
                name = "Speak with Small Beasts",
                description = """
                    Through sounds and gestures, you can communicate simple ideas with Small or smaller beasts. Forest 
                    gnomes love animals and often keep squirrels, badgers, rabbits, moles, woodpeckers, and other 
                    creatures as beloved pets.
                """.trimIndent(),
                affect = Affect(skills = Skills(AnimalHandling)),
            )
        ),
    )

    data object Rock : Gnome(
        description = "As a rock gnome, you have a natural inventiveness and hardiness beyond that of other gnomes.",
        bonusStatBlock = StatBlock(intelligence = 2, constitution = 1),
        proficiencies = Proficiencies(
            tools = { it == TinkersTools },
        ),
        feats = listOf(
            Feat(
                name = "Artificer’s Lore",
                description = """
                    Whenever you make an Intelligence (History) check related to magic items, alchemical objects, or 
                    technological devices, you can add twice your proficiency bonus, instead of any proficiency bonus 
                    you normally apply.
                """.trimIndent(),
                affect = Affect(skills = Skills(History)),
            ),
            Feat(
                name = "Tinker",
                description = """
                    You have proficiency with artisan’s tools (tinker’s tools). Using those tools, you can spend 1 hour 
                    and 10 gp worth of materials to construct a Tiny clockwork device (AC 5, 1 hp). The device ceases to
                    function after 24 hours (unless you spend 1 hour repairing it to keep the device functioning), or 
                    when you use your action to dismantle it; at that time, you can reclaim the materials used to create
                    it. You can have up to three such devices active at a time. When you create a device, choose one of
                    the following options:

                    Clockwork Toy: This toy is a clockwork animal, monster, or person, such as a frog, mouse, bird, 
                    dragon, or soldier. When placed on the ground, the toy moves 5 feet across the ground on each of 
                    your turns in a random direction. It makes noises as appropriate to the creature it represents.

                    Fire Starter: The device produces a miniature flame, which you can use to light a candle, torch, 
                    or campfire. Using the device requires your action.

                    Music Box: When opened, this music box plays a single song at a moderate volume. The box stops 
                    playing when it reaches the song’s end or when it is closed.
                """.trimIndent(),
            )
        ),
    )
}
