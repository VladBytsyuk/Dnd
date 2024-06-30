package io.vbytsyuk.dnd.core.tools

import io.vbytsyuk.dnd.core.units.gold
import io.vbytsyuk.dnd.core.units.lb

interface ArtisansTools : Tools {

    override val description get() = """
        These special tools include the items needed to pursue a craft or trade. Proficiency with a set of artisan's 
        tools lets you add your proficiency bonus to any ability checks you make using the tools in your craft. 
        Each type of artisan's tools requires a separate proficiency.
    """.trimIndent()
}

data object AlchemistSupplies : ArtisansTools {
    override val cost = 50.gold
    override val weight = 8.lb 
}

data object BrewersSupplies : ArtisansTools {
    override val cost = 20.gold
    override val weight = 9.lb 
}

data object CalligraphersSupplies : ArtisansTools {
    override val cost = 10.gold
    override val weight = 5.lb
}

data object CarpentersTools : ArtisansTools {
    override val cost = 8.gold
    override val weight = 6.lb
}

data object CartographersTools : ArtisansTools {
    override val cost = 15.gold
    override val weight = 6.lb
}

data object CobblersTools : ArtisansTools {
    override val cost = 5.gold
    override val weight = 5.lb
}

data object CooksUtensils : ArtisansTools {
    override val cost = 1.gold
    override val weight = 8.lb
}

data object GlassblowersTools : ArtisansTools {
    override val cost = 30.gold
    override val weight = 5.lb
}

data object JewelersTools : ArtisansTools {
    override val cost = 25.gold
    override val weight = 2.lb
}

data object LeatherworkersTools : ArtisansTools {
    override val cost = 5.gold
    override val weight = 5.lb
}

data object MasonsTools : ArtisansTools {
    override val cost = 10.gold
    override val weight = 8.lb
}

data object PaintersSupplies : ArtisansTools {
    override val cost = 10.gold
    override val weight = 5.lb
}

data object PottersTools : ArtisansTools {
    override val cost = 10.gold
    override val weight = 3.lb
}

data object SmithsTools : ArtisansTools {
    override val cost = 20.gold
    override val weight = 8.lb
}

data object TinkersTools : ArtisansTools {
    override val cost = 50.gold
    override val weight = 10.lb
}

data object WeaversTools : ArtisansTools {
    override val cost = 1.gold
    override val weight = 5.lb
}

data object WoodcarversTools : ArtisansTools {
    override val cost = 1.gold
    override val weight = 5.lb
}


data object DisguiseKit : ArtisansTools {
    override val cost = 25.gold
    override val weight = 3.lb
    override val description = """
        This pouch of cosmetics, hair dye, and small props lets you create disguises that change your physical 
        appearance. Proficiency with this kit lets you add your proficiency bonus to any Ability Checks you make to 
        create a visual disguise.
    """.trimIndent()
}
