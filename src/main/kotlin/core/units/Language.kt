package io.vbytsyuk.dnd.core.units

interface Language {

    val script: Script

    interface Script {
        data object Common : Script
        data object Dwarvish : Script
        data object Elvish : Script
        data object Infernal : Script
        data object Celestial : Script
        data object Draconic : Script
        data object None : Script
    }

    data object Common : Language {
        override val script = Script.Common
    }

    data object Dwarvish : Language {
        override val script = Script.Dwarvish
    }

    data object Elvish : Language {
        override val script = Script.Elvish
    }

    data object Giant : Language {
        override val script = Script.Dwarvish
    }

    data object Gnomish : Language {
        override val script = Script.Dwarvish
    }

    data object Goblin : Language {
        override val script = Script.Dwarvish
    }

    data object Halfling : Language {
        override val script = Script.Common
    }

    data object Orc : Language {
        override val script = Script.Dwarvish
    }

    data object Abyssal : Language {
        override val script = Script.Infernal
    }

    data object Celestial : Language {
        override val script = Script.Celestial
    }

    data object Draconic : Language {
        override val script = Script.Draconic
    }

    data object DeepSpeech : Language {
        override val script = Script.None
    }

    data object Infernal : Language {
        override val script = Script.Infernal
    }

    data object Primordial : Language {
        override val script = Script.Dwarvish
    }

    data object Sylvan : Language {
        override val script = Script.Elvish
    }

    data object Undercommon : Language {
        override val script = Script.Elvish
    }

    companion object {

        val all = setOf(
            Common, Dwarvish, Elvish, Giant, Gnomish, Goblin, Halfling, Orc, Abyssal, Celestial, Draconic, DeepSpeech,
            Infernal, Primordial, Sylvan, Undercommon,
        )
    }
}
