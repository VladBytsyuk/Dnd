package io.vbytsyuk.dnd.clients.cli

import io.vbytsyuk.dnd.clients.cli.print.StringPrinter
import io.vbytsyuk.dnd.core.StatBlock
import io.vbytsyuk.dnd.core.background.Acolyte
import io.vbytsyuk.dnd.core.character.Character
import io.vbytsyuk.dnd.core.`class`.Fighter
import io.vbytsyuk.dnd.core.equipment.Equipment
import io.vbytsyuk.dnd.core.equipment.equipped
import io.vbytsyuk.dnd.core.language.Language.Dwarvish
import io.vbytsyuk.dnd.core.language.Language.Orc
import io.vbytsyuk.dnd.core.proficiencies.Skills2
import io.vbytsyuk.dnd.core.race.Tiefling
import io.vbytsyuk.dnd.core.sheet.Sheet
import io.vbytsyuk.dnd.core.skills.Skill.Dexterity.Acrobatics
import io.vbytsyuk.dnd.core.skills.Skill.Strength.Athletics
import io.vbytsyuk.dnd.core.units.Alignment
import io.vbytsyuk.dnd.core.units.Exp
import io.vbytsyuk.dnd.core.units.Wallet
import io.vbytsyuk.dnd.core.weapon.Shortsword
import io.vbytsyuk.dnd.test.T
import org.junit.jupiter.api.Test

class StringPrinterTest : T<Character, String> {

    @Test
    fun `test character print function`() = check()

    override val dataSet: Collection<T.Data<Character, String>> = listOf(
        T.Data(name = "Alice", input = CHARACTER, output = PRINTED),
    )

    override fun act(input: Character): String = StringPrinter().print(Sheet(character = input))

    companion object {

        private val CHARACTER = Character(
            name = "Alice",
            race = Tiefling.Fierna,
            `class` = Fighter(proficientSkills = Skills2(Acrobatics, Athletics)),
            alignment = Alignment.LAWFUL_EVIL,
            background = Acolyte(language1 = Dwarvish, language2 = Orc),
            initialRawStatBlock = StatBlock(
                strength = 15,
                dexterity = 14,
                constitution = 12,
                intelligence = 10,
                wisdom = 10,
                charisma = 10,
            ),
            exp = Exp(value = 5340),
            equipment = Equipment(
                Shortsword.equipped(),
            ),
            wallet = Wallet(copper = 6584, silver = 6495, gold = 3924, platinum = 4344),
            personality = Character.Personality(
                trait = "Trait",
                ideal = "Ideal",
                bond = "Bond",
                flaw = "Flaw"
            )
        )

        private const val PRINTED = """
Alice, Fierna, 4 lvl (5340 xp), Fighter, 35/35 hp (4/4 d10 hit dices), Alignment = LAWFUL_EVIL
Death saving throws: [___|___]
Background = Acolyte(language1=Dwarvish, language2=Orc)
AC: 12, Initiative: +2, Speed: 30 ft, Size: MEDIUM, Dark vision = 60
Proficiencies:
    Armor: Light, Medium, Heavy, Shield
    Weapon: Simple, Matrial
    Tools: 
    Languages: Common, Infernal, Dwarvish, Orc
Skills: Proficiency = +2,
    STR = 15(+2),	savingThrow = *(+4)		{Athletics=*(+4)}
    DEX = 14(+2),	savingThrow = (+2)		{Acrobatics=*(+4), SleightOfHand=(+2), Stealth=(+2)}
    CON = 12(+1),	savingThrow = *(+3)		{}
    INT = 10(+0),	savingThrow = (+0)		{Arcana=(+0), History=(+0), Investigation=(+0), Nature=(+0), Religion=*(+2)}
    WIS = 11(+0),	savingThrow = (+0)		{AnimalHandling=(+0), Insight=*(+2), Medicine=(+0), Perception=(+0), Survival=(+0)}
    CHA = 12(+1),	savingThrow = (+1)		{Deception=(+1), Intimidation=(+1), Performance=(+1), Persuasion=(+1)}
Equipment: Shortsword*
Money: 6584 copper, 6495 silver, 3924 gold, 4344 platinum
Attacks:
	Shortsword	+4	1d6+4 PIERCING
Personality:
    Trait: Trait
    Ideal: Ideal
    Bond: Bond
    Flaw: Flaw
"""
    }
}
