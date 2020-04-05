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
        val riskApetite = RiskTestFactory.createRiskApetite()
        assertThat(riskApetite.riskMatrix.size).isEqualTo(5)
        for (i in 0..4){
            assertThat(riskApetite.riskMatrix[i].size).isEqualTo(5)
        }
    }

    @Test
     fun `Throws exception when getSeverityLevel is called with illegal arguments`() {
        val riskApetite = RiskTestFactory.createRiskApetite()
        assertFailsWith<ArrayIndexOutOfBoundsException> {
            riskApetite.getSeverityLevel(0,1)
        }
    }



}