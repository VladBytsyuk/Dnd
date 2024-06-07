package io.vbytsyuk.dnd.core.units

enum class Language(val script: Script) {
    COMMON(script = Script.COMMON),
    DWARVISH(script = Script.DWARVISH),
    ELVISH(script = Script.ELVISH),
    GIANT(script = Script.DWARVISH),
    GNOMISH(script = Script.DWARVISH),
    GOBLIN(script = Script.DWARVISH),
    HALFLING(script = Script.COMMON),
    ORC(script = Script.DWARVISH),
    ABYSSAL(script = Script.INFERNAL),
    CELESTIAL(script = Script.CELESTIAL),
    DRACONIC(script = Script.DRACONIC),
    DEEP_SPEECH(script = Script.NONE),
    INFERNAL(script = Script.INFERNAL),
    PRIMORDIAL(script = Script.DWARVISH),
    SYLVAN(script = Script.ELVISH),
    UNDERCOMMON(script = Script.ELVISH);

    enum class Script { COMMON, DWARVISH, ELVISH, INFERNAL, CELESTIAL, DRACONIC, NONE }
}