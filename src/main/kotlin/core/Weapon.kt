package io.vbytsyuk.dnd.core

import io.vbytsyuk.dnd.core.Damage.Type.*
import io.vbytsyuk.dnd.core.Dice.*
import io.vbytsyuk.dnd.core.Weapon.Property.*
import io.vbytsyuk.dnd.core.money.CoinType.*
import io.vbytsyuk.dnd.core.money.Coins

sealed class Weapon(
    val cost: Coins,
    val damage: Damage,
    val weight: Double,
    val properties: List<Property> = emptyList(),
) {

    sealed class Property {
        data class Ammunition(val shortRange: Int, val longRange: Int) : Property()
        data object Finesse : Property()
        data object Heavy : Property()
        data object Light : Property()
        data object Loading : Property()
        data object Reach : Property()
        data object Reload : Property()
        data object Special : Property()
        data class Thrown(val shortRange: Int, val longRange: Int) : Property()
        data object TwoHanded : Property()
        data class Versatile(val twoHandedDice: Dice) : Property()
    }

    sealed class Simple(
        cost: Coins,
        damage: Damage,
        weight: Double,
        properties: List<Property> = emptyList(),
    ) : Weapon(cost, damage, weight, properties) {

        sealed class Melee(
            cost: Coins,
            damage: Damage,
            weight: Double,
            properties: List<Property> = emptyList(),
        ) : Simple(cost, damage, weight, properties) {

            data object Quarterstaff : Melee(
                cost = Coins(2, SILVER),
                damage = Damage(dice = D6, type = BLUDGEONING),
                weight = 4.0,
                properties = listOf(Versatile(twoHandedDice = D8)),
            )

            data object Mace : Melee(
                cost = Coins(5, GOLD),
                damage = Damage(dice = D6, type = BLUDGEONING),
                weight = 4.0,
            )

            data object Club : Melee(
                cost = Coins(1, SILVER),
                damage = Damage(dice = D4, type = BLUDGEONING),
                weight = 2.0,
                properties = listOf(Light)
            )

            data object Dagger : Melee(
                cost = Coins(2, GOLD),
                damage = Damage(dice = D4, type = PIERCING),
                weight = 1.0,
                properties = listOf(Light, Finesse, Thrown(shortRange = 20, longRange = 60)),
            )

            data object Spear : Melee(
                cost = Coins(1, GOLD),
                damage = Damage(dice = D6, type = PIERCING),
                weight = 3.0,
                properties = listOf(Thrown(shortRange = 20, longRange = 60), Versatile(twoHandedDice = D8)),
            )

            data object LightHammer : Melee(
                cost = Coins(2, GOLD),
                damage = Damage(dice = D4, type = BLUDGEONING),
                weight = 2.0,
                properties = listOf(Light, Thrown(shortRange = 20, longRange = 60)),
            )

            data object Javelin : Melee(
                cost = Coins(5, SILVER),
                damage = Damage(dice = D6, type = PIERCING),
                weight = 2.0,
                properties = listOf(Thrown(shortRange = 30, longRange = 120)),
            )

            data object Greatclub : Melee(
                cost = Coins(2, SILVER),
                damage = Damage(dice = D8, type = BLUDGEONING),
                weight = 10.0,
                properties = listOf(TwoHanded),
            )

            data object Handaxe : Melee(
                cost = Coins(5, GOLD),
                damage = Damage(dice = D6, type = SLASHING),
                weight = 2.0,
                properties = listOf(Light, Thrown(shortRange = 20, longRange = 60)),
            )

            data object Sickle : Melee(
                cost = Coins(1, GOLD),
                damage = Damage(dice = D4, type = SLASHING),
                weight = 2.0,
                properties = listOf(Light),
            )
        }

        sealed class Ranged(
            cost: Coins,
            damage: Damage,
            weight: Double,
            properties: List<Property> = emptyList(),
        ) : Simple(cost, damage, weight, properties) {

            data object LightCrossbow : Ranged(
                cost = Coins(25, GOLD),
                damage = Damage(dice = D8, type = PIERCING),
                weight = 5.0,
                properties = listOf(TwoHanded, Ammunition(shortRange = 80, longRange = 320), Loading),
            )

            data object Dart : Ranged(
                cost = Coins(5, COPPER),
                damage = Damage(dice = D4, type = PIERCING),
                weight = 0.25,
                properties = listOf(Thrown(shortRange = 20, longRange = 60), Finesse),
            )

            data object Shortbow : Ranged(
                cost = Coins(25, GOLD),
                damage = Damage(dice = D6, type = PIERCING),
                weight = 2.0,
                properties = listOf(Ammunition(shortRange = 80, longRange = 320), TwoHanded),
            )

            data object Sling : Ranged(
                cost = Coins(1, SILVER),
                damage = Damage(dice = D6, type = BLUDGEONING),
                weight = 0.1,
                properties = listOf(Ammunition(shortRange = 30, longRange = 120)),
            )
        }
    }

    sealed class Martial(
        cost: Coins,
        damage: Damage,
        weight: Double,
        properties: List<Property> = emptyList(),
    ) : Weapon(cost, damage, weight, properties) {

        sealed class Melee(
            cost: Coins,
            damage: Damage,
            weight: Double,
            properties: List<Property> = emptyList(),
        ) : Martial(cost, damage, weight, properties) {

            data object Halberd : Melee(
                cost = Coins(20, GOLD),
                damage = Damage(dice = D10, type = SLASHING),
                weight = 6.0,
                properties = listOf(TwoHanded, Reach, Heavy),
            )

            data object WarPick : Melee(
                cost = Coins(5, GOLD),
                damage = Damage(dice = D8, type = PIERCING),
                weight = 2.0,
            )

            data object Warhammer : Melee(
                cost = Coins(15, GOLD),
                damage = Damage(dice = D8, type = BLUDGEONING),
                weight = 2.0,
                properties = listOf(Versatile(twoHandedDice = D10)),
            )

            data object Battleaxe : Melee(
                cost = Coins(10, GOLD),
                damage = Damage(dice = D8, type = SLASHING),
                weight = 4.0,
                properties = listOf(Versatile(twoHandedDice = D10)),
            )

            data object Glaive : Melee(
                cost = Coins(20, GOLD),
                damage = Damage(dice = D10, type = SLASHING),
                weight = 6.0,
                properties = listOf(TwoHanded, Reach, Heavy),
            )

            data object Greatsword : Melee(
                cost = Coins(50, GOLD),
                damage = Damage(2, dice = D6, type = SLASHING),
                weight = 6.0,
                properties = listOf(TwoHanded, Heavy),
            )

            data object Lance : Melee(
                cost = Coins(10, GOLD),
                damage = Damage(dice = D12, type = PIERCING),
                weight = 6.0,
                properties = listOf(Reach, Special),
            )

            data object Longsword : Melee(
                cost = Coins(15, GOLD),
                damage = Damage(dice = D8, type = SLASHING),
                weight = 3.0,
                properties = listOf(Versatile(twoHandedDice = D10)),
            )

            data object Whip : Melee(
                cost = Coins(2, GOLD),
                damage = Damage(dice = D4, type = SLASHING),
                weight = 3.0,
                properties = listOf(Reach, Finesse),
            )

            data object Shortsword : Melee(
                cost = Coins(10, GOLD),
                damage = Damage(dice = D6, type = PIERCING),
                weight = 2.0,
                properties = listOf(Light, Finesse),
            )

            data object Maul : Melee(
                cost = Coins(10, GOLD),
                damage = Damage(2, dice = D6, type = BLUDGEONING),
                weight = 10.0,
                properties = listOf(TwoHanded, Heavy),
            )

            data object Morningstar : Melee(
                cost = Coins(15, GOLD),
                damage = Damage(dice = D8, type = PIERCING),
                weight = 4.0,
            )

            data object Pike : Melee(
                cost = Coins(5, GOLD),
                damage = Damage(dice = D10, type = PIERCING),
                weight = 18.0,
                properties = listOf(TwoHanded, Reach, Heavy),
            )

            data object Rapier : Melee(
                cost = Coins(25, GOLD),
                damage = Damage(dice = D8, type = PIERCING),
                weight = 2.0,
                properties = listOf(Finesse),
            )

            data object Greataxe : Melee(
                cost = Coins(30, GOLD),
                damage = Damage(dice = D12, type = SLASHING),
                weight = 7.0,
                properties = listOf(TwoHanded, Heavy),
            )

            data object Scimitar : Melee(
                cost = Coins(25, GOLD),
                damage = Damage(dice = D6, type = SLASHING),
                weight = 3.0,
                properties = listOf(Light, Finesse),
            )

            data object Trident : Melee(
                cost = Coins(5, GOLD),
                damage = Damage(dice = D6, type = PIERCING),
                weight = 4.0,
                properties = listOf(Thrown(shortRange = 20, longRange = 60), Versatile(twoHandedDice = D8)),
            )

            data object Flail : Melee(
                cost = Coins(10, GOLD),
                damage = Damage(dice = D8, type = BLUDGEONING),
                weight = 2.0,
            )
        }

        sealed class Ranged(
            cost: Coins,
            damage: Damage,
            weight: Double,
            properties: List<Property> = emptyList(),
        ) : Martial(cost, damage, weight, properties) {

            data object HandCrossbow : Ranged(
                cost = Coins(75, GOLD),
                damage = Damage(dice = D6, type = PIERCING),
                weight = 3.0,
                properties = listOf(Ammunition(shortRange = 30, longRange = 120), Light, Loading),
            )

            data object HeavyCrossbow : Ranged(
                cost = Coins(50, GOLD),
                damage = Damage(dice = D10, type = PIERCING),
                weight = 18.0,
                properties = listOf(Ammunition(shortRange = 100, longRange = 400), TwoHanded, Loading, Heavy),
            )

            data object Longbow : Ranged(
                cost = Coins(50, GOLD),
                damage = Damage(dice = D8, type = PIERCING),
                weight = 2.0,
                properties = listOf(Ammunition(shortRange = 150, longRange = 600), TwoHanded, Heavy),
            )

            data object Blowgun : Ranged(
                cost = Coins(10, GOLD),
                damage = Damage(amount = 1, type = PIERCING),
                weight = 1.0,
                properties = listOf(Ammunition(shortRange = 25, longRange = 100), Loading),
            )

            data object Musket : Ranged(
                cost = Coins(500, GOLD),
                damage = Damage(dice = D12, type = PIERCING),
                weight = 10.0,
                properties = listOf(Ammunition(shortRange = 40, longRange = 120), TwoHanded, Loading),
            )

            data object AutomaticPistol : Ranged(
                cost = Coins(500, GOLD),
                damage = Damage(2, dice = D6, type = PIERCING),
                weight = 3.0,
                properties = listOf(Reload, Ammunition(shortRange = 50, longRange = 150)),
            )

            data object Pistol : Ranged(
                cost = Coins(250, GOLD),
                damage = Damage(dice = D10, type = PIERCING),
                weight = 3.0,
                properties = listOf(Ammunition(shortRange = 30, longRange = 90), Loading),
            )

            data object Net : Ranged(
                cost = Coins(1, GOLD),
                damage = Damage(amount = 0, type = PIERCING),
                weight = 3.0,
                properties = listOf(Thrown(shortRange = 5, longRange = 15), Special),
            )
        }
    }
}