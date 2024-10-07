import io.vbytsyuk.dnd.core.Modifier
import io.vbytsyuk.dnd.core.proficiencies.calculateCanonicalProficiencyBonus
import io.vbytsyuk.dnd.core.proficiencies.calculateProficiencyBonus
import io.vbytsyuk.dnd.core.units.Level
import org.junit.jupiter.api.Test

class CalculateProfiiciiencyBonusTest : T<Level, Modifier> {

    @Test
    fun `test calculateMaximumHp function`() = check()

    override val dataSet: Collection<T.Data<Level, Modifier>> = buildList {
        (1..20).forEach { value ->
            val level = Level(value)
            this += T.Data(name = level.toString(), input = level, output = calculateCanonicalProficiencyBonus(level))
        }
    }

    override fun act(input: Level): Modifier = calculateProficiencyBonus(input)
}