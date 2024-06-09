package io.vbytsyuk.dnd.core.tools

import io.vbytsyuk.dnd.core.units.Coins
import io.vbytsyuk.dnd.core.units.Weight
import io.vbytsyuk.dnd.core.units.gold
import io.vbytsyuk.dnd.core.units.lb

sealed class ArtisansTools(cost: Coins, weight: Weight) : Tools(
    cost = cost,
    weight = weight,
    description = """
        These special tools include the items needed to pursue a craft or trade. Proficiency with a set of artisan's 
        tools lets you add your proficiency bonus to any ability checks you make using the tools in your craft. 
        Each type of artisan's tools requires a separate proficiency.
    """.trimIndent(),
)

data object AlchemistSupplies : ArtisansTools(cost = 50.gold, weight = 8.lb)
data object BrewersSupplies : ArtisansTools(cost = 20.gold, weight = 9.lb)
data object CalligraphersSupplies : ArtisansTools(cost = 10.gold, weight = 5.lb)
data object CarpentersTools : ArtisansTools(cost = 8.gold, weight = 6.lb)
data object CartographersTools : ArtisansTools(cost = 15.gold, weight = 6.lb)
data object CobblersTools : ArtisansTools(cost = 5.gold, weight = 5.lb)
data object CooksUtensils : ArtisansTools(cost = 1.gold, weight = 8.lb)
data object GlassblowersTools : ArtisansTools(cost = 30.gold, weight = 5.lb)
data object JewelersTools : ArtisansTools(cost = 25.gold, weight = 2.lb)
data object LeatherworkersTools : ArtisansTools(cost = 5.gold, weight = 5.lb)
data object MasonsTools : ArtisansTools(cost = 10.gold, weight = 8.lb)
data object PaintersSupplies : ArtisansTools(cost = 10.gold, weight = 5.lb)
data object PottersTools : ArtisansTools(cost = 10.gold, weight = 3.lb)
data object SmithsTools : ArtisansTools(cost = 20.gold, weight = 8.lb)
data object TinkersTools : ArtisansTools(cost = 50.gold, weight = 10.lb)
data object WeaversTools : ArtisansTools(cost = 1.gold, weight = 5.lb)
data object WoodcarversTools : ArtisansTools(cost = 1.gold, weight = 5.lb)
