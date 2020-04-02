package no.kommune.oslo.model

import no.kommune.oslo.model.SeverityLevels.*
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.test.assertFailsWith

internal class RiskAppetiteTest {

    @Test
    fun `Throws exception when RiskMatrix is not valid `() {
        assertFailsWith<IllegalArgumentException> {
            RiskApetite(arrayOf(arrayOf(LOW, LOW, LOW, LOW, MODERATE)))
        }
    }

    @Test
    fun `Expect RiskMatrix of size 5x5 and populated with SevertyLevels`() {
        val riskApetite = createRiskApetite()
        assertThat(riskApetite.riskMatrix.size).isEqualTo(5)
        for (i in 0..4){
            assertThat(riskApetite.riskMatrix[i].size).isEqualTo(5)
        }
    }

    @Test
//    fun `Throws exception when getSeverityLevel is called with illegal arguments￿￿`() {
     fun Throws_exception_when_getSeverityLevel_is_called_with_illegal_arguments() {
        val riskApetite = createRiskApetite()
        assertFailsWith<ArrayIndexOutOfBoundsException> {
            riskApetite.getSeverityLevel(0,1)
        }
    }

    private fun createRiskApetite(): RiskApetite {
        val riskApetite = RiskApetite(
                arrayOf(
                        arrayOf(LOW, LOW, LOW, LOW, MODERATE),
                        arrayOf(LOW, LOW, LOW, MODERATE, MODERATE),
                        arrayOf(MODERATE, MODERATE, MODERATE, MODERATE, HIGH),
                        arrayOf(MODERATE, MODERATE, HIGH, HIGH, HIGH),
                        arrayOf(MODERATE, HIGH, HIGH, HIGH, HIGH)
                )
        )
        return riskApetite
    }


}