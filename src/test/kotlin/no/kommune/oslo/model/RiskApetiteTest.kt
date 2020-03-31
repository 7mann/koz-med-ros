package no.kommune.oslo.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RiskApetiteTest {

//    @Test
//    fun returnRisk() {
//        val riskMatrix = arrayOf(
//            arrayOf(LOW, LOW, LOW, LOW, MODERATE),
//            arrayOf(LOW, LOW, LOW, MODERATE, MODERATE),
//            arrayOf(MODERATE, MODERATE, MODERATE, MODERATE, HIGH),
//            arrayOf(MODERATE, MODERATE, HIGH, HIGH, HIGH),
//            arrayOf(MODERATE, HIGH, HIGH, HIGH, HIGH)
//        )
//
//        println(Arrays.deepToString(riskMatrix))
//
//
//    }

    @Test
    fun `Throws exception when RiskMatrix is not valid `() {
        org.junit.jupiter.api.assertThrows<IllegalArgumentException> {
            val riskApetite = RiskApetite(arrayOf(arrayOf(SeverityLevels.LOW, SeverityLevels.LOW, SeverityLevels.LOW, SeverityLevels.LOW, SeverityLevels.MODERATE)))
        }
    }

    @Test
    fun `Expect RiskMatrix of size 5x5 and populated with SevertyLevels`() {
        var riskApetite = createriskApetite()
        assertThat(riskApetite.riskMatrix.size).isEqualTo(5)
        for (i in 0..4){
            assertThat(riskApetite.riskMatrix[i].size).isEqualTo(5)
        }
    }

//    @Test
//    fun `Throws exception when getSeverityLevel is called with illegal arguments￿￿`() {
//        var riskApetite = createriskApetite()
//        assertThrows<ArrayIndexOutOfBoundsException> {
//            val severity = riskApetite.getSeverityLevel(0,1)
//        }
//
//    }

    private fun createriskApetite(): RiskApetite {
        val riskApetite = RiskApetite(
                arrayOf(
                        arrayOf(SeverityLevels.LOW, SeverityLevels.LOW, SeverityLevels.LOW, SeverityLevels.LOW, SeverityLevels.MODERATE),
                        arrayOf(SeverityLevels.LOW, SeverityLevels.LOW, SeverityLevels.LOW, SeverityLevels.MODERATE, SeverityLevels.MODERATE),
                        arrayOf(SeverityLevels.MODERATE, SeverityLevels.MODERATE, SeverityLevels.MODERATE, SeverityLevels.MODERATE, SeverityLevels.HIGH),
                        arrayOf(SeverityLevels.MODERATE, SeverityLevels.MODERATE, SeverityLevels.HIGH, SeverityLevels.HIGH, SeverityLevels.HIGH),
                        arrayOf(SeverityLevels.MODERATE, SeverityLevels.HIGH, SeverityLevels.HIGH, SeverityLevels.HIGH, SeverityLevels.HIGH)
                )
        )
        return riskApetite
    }


}