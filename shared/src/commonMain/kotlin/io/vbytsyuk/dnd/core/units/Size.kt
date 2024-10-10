package io.vbytsyuk.dnd.core.units

enum class Size(
    val height: Distance.Range,
    val weight: Weight.Range,
    val space: Distance,
) {
    FINE(
        height = 0.inches..6.inches,
        weight = 0.lb..0.125.lb,
        space = 0.5.feet,
    ),
    DIMINUTIVE(
        height = 6.inches..1.feet,
        weight = 0.125.lb..1.lb,
        space = 1.feet,
    ),
    TINY(
        height = 1.feet..2.feet,
        weight = 1.lb..8.lb,
        space = 2.5.feet,
    ),
    SMALL(
        height = 2.feet..4.feet,
        weight = 8.lb..60.lb,
        space = 5.feet,
    ),
    MEDIUM(
        height = 4.feet..8.feet,
        weight = 60.lb..500.lb,
        space = 5.feet,
    ),
    LARGE(
        height = 8.feet..16.feet,
        weight = 500.lb..4_000.lb,
        space = 10.feet,
    ),
    HUGE(
        height = 16.feet..32.feet,
        weight = 4_000.lb..32_000.lb,
        space = 15.feet,
    ),
    GARGANTUAN(
        height = 32.feet..64.feet,
        weight = 32_000.lb..250_000.lb,
        space = 20.feet,
    ),
    COLOSSAL(
        height = 64.feet..MAX_DISTANCE,
        weight = 250_000.lb..MAX_WEIGHT,
        space = 30.feet,
    );
}
