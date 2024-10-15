package io.vbytsyuk.dnd.domain.core.background

import io.vbytsyuk.dnd.domain.core.background.Background.Statement
import io.vbytsyuk.dnd.domain.core.equipment.Equipment
import io.vbytsyuk.dnd.domain.core.equipment.Item
import io.vbytsyuk.dnd.domain.core.equipment.equipped
import io.vbytsyuk.dnd.domain.core.equipment.unequipped
import io.vbytsyuk.dnd.domain.core.language.Language
import io.vbytsyuk.dnd.domain.core.language.LanguageChecker
import io.vbytsyuk.dnd.domain.core.proficiencies.Proficiencies
import io.vbytsyuk.dnd.domain.core.proficiencies.Skills
import io.vbytsyuk.dnd.domain.core.skills.Skill
import io.vbytsyuk.dnd.domain.core.units.GoodVsEvil.GOOD
import io.vbytsyuk.dnd.domain.core.units.LawVsChaos.CHAOTIC
import io.vbytsyuk.dnd.domain.core.units.LawVsChaos.LAWFUL
import io.vbytsyuk.dnd.domain.core.units.gold

data class Acolyte(
    val language1: Language,
    val language2: Language,
) : io.vbytsyuk.dnd.domain.core.background.Background {

    override val description = """
        You have spent your life in the service of a temple to a specific god or pantheon of gods. You act as an 
        intermediary between the realm of the holy and the mortal world, performing sacred rites and offering 
        sacrifices in order to conduct worshipers into the presence of the divine. You are not necessarily a cleric — 
        performing sacred rites is not the same thing as channeling divine power.

        Choose a god, a pantheon of gods, or some other quasi-divine being, and work with your DM to detail the nature 
        of your religious service. The Gods article contains a sample pantheon. Were you a lesser functionary in a 
        temple, raised from childhood to assist the priests in the sacred rites? Or were you a high priest who suddenly 
        experienced a call to serve your god in a different way? Perhaps you were the leader of a small cult outside of 
        any established temple structure, or even an occult group that served a fiendish master that you now deny.
    """.trimIndent()
    override val proficiencies = Proficiencies(
        skills = Skills(Skill.Wisdom.Insight, Skill.Intelligence.Religion).list,
        languages = LanguageChecker(specific = setOf(language1, language2)),
    )
    override val equipment = Equipment(
        Item("A holy symbol (a gift to you when you entered the priesthood)").equipped(),
        Item("A prayer book or prayer wheel").unequipped(),
        Item("Stick of incense").unequipped(count = 5),
        Item("Vestments").unequipped(),
        Item("A set of common clothes").unequipped(),
        Item("A pouch").unequipped(),
    )
    override val startCoins = 15.gold
    override val features = listOf(
        io.vbytsyuk.dnd.domain.core.background.Background.Feature(
            name = "Shelter of the Faithful",
            description = """
                As an acolyte, you command the respect of those who share your faith, and you can perform the religious 
                ceremonies of your deity. You and your adventuring companions can expect to receive free healing and 
                care at a temple, shrine, or other established presence of your faith, though you must provide any 
                material components needed for spells. Those who share your religion will support you (but only you) at 
                a modest lifestyle.

                You might also have ties to a specific temple dedicated to your chosen deity or pantheon, and you have 
                a residence there. This could be the temple where you used to serve, if you remain on good terms with 
                it, or a temple where you have found a new home. While near your temple, you can call upon the priests 
                for assistance, provided the assistance you ask for is not hazardous and you remain in good standing 
                with your temple.
            """.trimIndent(),
        ),
    )

    @Suppress("MaxLineLength")
    override val suggestedCharacteristics = io.vbytsyuk.dnd.domain.core.background.Background.SuggestedCharacteristics(
        description = """
            Acolytes are shaped by their experience in temples or other religious communities. Their study of the 
            history and tenets of their faith and their relationships to temples, shrines, or hierarchies affect their 
            mannerisms and ideals. Their flaws might be some hidden hypocrisy or heretical idea, or an ideal or bond 
            taken to an extreme.
        """.trimIndent(),
        personalityTraits = listOf(
            Statement("I idolize a particular hero of my faith, and constantly refer to that person's deeds and example."),
            Statement("I can find common ground between the fiercest enemies, empathizing with them and always working towards peace."),
            Statement("I see omens in every event and action. The gods try to speak to us, we just need to listen."),
            Statement("Nothing can shake my optimistic attitude."),
            Statement("I quote (or misquote) sacred texts and proverbs in almost every situation."),
            Statement("I am tolerant (or intolerant) of other faiths and respect (or condemn) the worship of other gods."),
            Statement("I've enjoyed fine food, drink, and high society among my temple's elite. Rough living grates on me."),
            Statement("I've spent so long in the temple that I have little practical experience dealing with people in the outside world."),
        ),
        ideals = listOf(
            Statement(
                "Tradition. The ancient traditions of worship and sacrifice must be preserved and upheld.",
                LAWFUL
            ),
            Statement("Charity. I always try to help those in need, no matter what the personal cost.", GOOD),
            Statement(
                "Change. We must help bring about the changes the gods are constantly working in the world.",
                CHAOTIC
            ),
            Statement("Power. I hope to one day rise to the top of my faith's religious hierarchy.", LAWFUL),
            Statement(
                "Faith. I trust that my deity will guide my actions, I have faith that if I work hard, things will go well.",
                LAWFUL
            ),
            Statement("Aspiration. I seek to prove myself worthy of my god's favor by matching my actions against their teachings."),
        ),
        bonds = listOf(
            Statement("I would die to recover an ancient relic of my faith that was lost long ago."),
            Statement("I will someday get revenge on the corrupt temple hierarchy who branded me a heretic."),
            Statement("I owe my life to the priest who took me in when my parents died."),
            Statement("Everything I do is for the common people."),
            Statement("I will do anything to protect the temple where I served."),
            Statement("I seek to preserve a sacred text that my enemies consider heretical and seek to destroy."),
        ),
        flaws = listOf(
            Statement("I judge others harshly, and myself even more severely."),
            Statement("I put too much trust in those who wield power within my temple's hierarchy."),
            Statement("My piety sometimes leads me to blindly trust those that profess faith in my god."),
            Statement("I am inflexible in my thinking."),
            Statement("I am suspicious of strangers and expect the worst of them."),
            Statement("Once I pick a goal, I become obsessed with it to the detriment of everything else in my life."),
        ),
    )

    init { require(language1 != language2) }
}
