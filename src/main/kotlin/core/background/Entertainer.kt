package io.vbytsyuk.dnd.core.background

import io.vbytsyuk.dnd.core.background.Background.Feature
import io.vbytsyuk.dnd.core.background.Background.Statement
import io.vbytsyuk.dnd.core.equipment.Equipment
import io.vbytsyuk.dnd.core.equipment.Item
import io.vbytsyuk.dnd.core.equipment.equipped
import io.vbytsyuk.dnd.core.equipment.unequipped
import io.vbytsyuk.dnd.core.proficiencies.Proficiencies
import io.vbytsyuk.dnd.core.proficiencies.Skills
import io.vbytsyuk.dnd.core.skills.Skill
import io.vbytsyuk.dnd.core.tools.DisguiseKit
import io.vbytsyuk.dnd.core.tools.MusicalInstrument
import io.vbytsyuk.dnd.core.units.GoodVsEvil.*
import io.vbytsyuk.dnd.core.units.LawVsChaos.CHAOTIC
import io.vbytsyuk.dnd.core.units.LawVsChaos.LAWFUL
import io.vbytsyuk.dnd.core.units.gold
import io.vbytsyuk.dnd.core.weapon.Weapon

data class Entertainer(
    val musicalInstrument: MusicalInstrument,
    val routine: Routine = Routine.entries.random(),
) : Background {

    override val description = """
        You thrive in front of an audience. You know how to entrance them, entertain them, and even inspire them. 
        Your poetics can stir the hearts of those who hear you, awakening grief or joy, laughter or anger. Your music 
        raises their spirits or captures their sorrow. Your dance steps captivate, your humor cuts to the quick. 
        Whatever techniques you use, your art is your life.
    """.trimIndent()
    override val proficiencies = Proficiencies(
        skills = entertainerSkills.list,
        tools = { it is DisguiseKit || it == musicalInstrument },
    )
    override val startCoins = 15.gold
    override val equipment = Equipment(
        musicalInstrument.unequipped(),
        Item("the favor of an admirer (love letter, lock of hair, or trinket)").unequipped(),
        Item("costume clothes").unequipped(),
        Item("a pouch").unequipped(),
    )
    override val features = listOf(ByPopularDemand)
    override val suggestedCharacteristics = entertainerSuggestedCharacteristics

    enum class Routine {
        ACTOR, DANCER, FIRE_EATER, JESTER, JUGGLER, INSTRUMENTALIST, POET, SINGER, STORYTELLER, TUMBLER;
    }
}


data class Gladiator(
    val weapon: Weapon,
) : Background {


    override val description = """
        A gladiator is as much an entertainer as any minstrel or circus performer, trained to make the arts of combat 
        into a spectacle the crowd can enjoy. This kind of flashy combat is your entertainer routine, though you might 
        also have some skills as a tumbler or actor. Using your By Popular Demand feature, you can find a place to 
        perform in any place that features combat for entertainment — perhaps a gladiatorial arena or secret pit 
        fighting club. You can replace the musical instrument in your equipment package with an inexpensive but unusual 
        weapon, such as a trident or net.
    """.trimIndent()
    override val proficiencies = Proficiencies(
        skills = entertainerSkills.list,
        weapons = { it == weapon },
        tools = { it is DisguiseKit },
    )
    override val equipment = Equipment(
        weapon.equipped(),
        Item("the favor of an admirer (love letter, lock of hair, or trinket)").unequipped(),
        Item("costume clothes").unequipped(),
        Item("a pouch").unequipped(),
    )
    override val startCoins = 15.gold
    override val features = listOf(ByPopularDemand)
    override val suggestedCharacteristics = entertainerSuggestedCharacteristics
}

private val entertainerSkills = Skills(Skill.Dexterity.Acrobatics, Skill.Charisma.Performance)

private val ByPopularDemand = Feature(
    name = "By Popular Demand",
    description = """
        You can always find a place to perform, usually in an inn or tavern but possibly with a circus, at a 
        theater, or even in a noble's court. At such a place, you receive free lodging and food of a modest or 
        comfortable standard (depending on the quality of the establishment), as long as you perform each night. 
        In addition, your performance makes you something of a local figure. When strangers recognize you in a 
        town where you have performed, they typically take a liking to you.
    """.trimIndent()
)

private val entertainerSuggestedCharacteristics: Background.SuggestedCharacteristics
    get() = Background.SuggestedCharacteristics(
        description = """
            Successful entertainers have to be able to capture and hold an audience's attention, so they tend to have 
            flamboyant or forceful personalities. They're inclined toward the romantic and often cling to high-minded 
            ideals about the practice of art and the appreciation of beauty.
        """.trimIndent(),
        personalityTraits = listOf(
            Statement("I know a story relevant to almost every situation."),
            Statement("Whenever I come to a new place, I collect local rumors and spread gossip."),
            Statement("I'm a hopeless romantic, always searching for that \"special someone.\""),
            Statement("Nobody stays angry at me or around me for long, since I can defuse any amount of tension."),
            Statement("I love a good insult, even one directed at me."),
            Statement("I get bitter if I'm not the center of attention."),
            Statement("I'll settle for nothing less than perfection."),
            Statement("I change my mood or my mind as quickly as I change key in a song."),
        ),
        ideals = listOf(
            Statement("Beauty. When I perform, I make the world better than it was.", GOOD),
            Statement("Tradition. The stories, legends, and songs of the past must never be forgotten, for they teach us who we are.", LAWFUL),
            Statement("Creativity. The world is in need of new ideas and bold action.", CHAOTIC),
            Statement("Greed. I'm only in it for the money and fame.", EVIL),
            Statement("People. I like seeing the smiles on people's faces when I perform. That's all that matters.", NEUTRAL),
            Statement("Honesty. Art should reflect the soul; it should come from within and reveal who we really are."),
            
        ),
        bonds = listOf(
            Statement("My instrument is my most treasured possession, and it reminds me of someone I love."),
            Statement("Someone stole my precious instrument, and someday I'll get it back."),
            Statement("I want to be famous, whatever it takes."),
            Statement("I idolize a hero of the old tales and measure my deeds against that person's."),
            Statement("I will do anything to prove myself superior to my hated rival."),
            Statement("I would do anything for the other members of my old troupe."),
        ),
        flaws = listOf(
            Statement("I'll do anything to win fame and renown."),
            Statement("I'm a sucker for a pretty face."),
            Statement("A scandal prevents me from ever going home again. That kind of trouble seems to follow me around."),
            Statement("I once satirized a noble who still wants my head. It was a mistake that I will likely repeat."),
            Statement("I have trouble keeping my true feelings hidden. My sharp tongue lands me in trouble."),
            Statement("Despite my best efforts, I am unreliable to my friends."),
        )
    )