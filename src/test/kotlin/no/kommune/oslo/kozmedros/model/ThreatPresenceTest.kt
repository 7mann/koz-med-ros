package no.kommune.oslo.kozmedros.model

import no.kommune.oslo.kozmedros.model.enums.*
import no.kommune.oslo.kozmedros.model.enums.SeverityLevel.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ThreatPresenceTest {

    @Test
    fun getThreatPresenceParameters() {
    }

    @Test
    fun `test that correct SeverityLevels returned from OWASPThreatPreseence`() {
        val threatPresence: OwaspThreatPresence = createHighOWASPthreatPresence()
        val severityLevel = threatPresence.getSeverityLevel()
        assertThat(severityLevel).isEqualTo(HIGH)
    }

    @Test
    fun `test that correct SeverityLevels returned from DiscreteThreatPresence`() {
        val threatPresence: DiscreteThreatPresence = createHighDiscretethreatPresence()
        val severityLevel = threatPresence.getSeverityLevel()
        assertThat(severityLevel).isEqualTo(HIGH)
    }

    @Test
    fun `test converting from Threatpresence to severitylevel`() {
        val tp: OwaspThreatPresence = createHighOWASPthreatPresence()
        for (i in 3..15) {
            val sevLevel = tp.owasp2sevlevel(i)
            if (i == 1) assertThat(sevLevel).isEqualTo(INSIGNIFICANT)
            if (i in 4..6) assertThat(sevLevel).isEqualTo(LOW)
            if (i in 7..8) assertThat(sevLevel).isEqualTo(MODERATE)
            if (i in 9..11) assertThat(sevLevel).isEqualTo(HIGH)
            if (i in 12..15) assertThat(sevLevel).isEqualTo(EXTREME)
        }
    }

    private fun createHighOWASPthreatPresence(): OwaspThreatPresence {
        return OwaspThreatPresence(
                exploitability = ThreatExploitability.AVERAGE,
                weaknessPrevalence = ThreatWeaknessPrevalence.WIDESPREAD,
                weaknessDetectability = ThreatWeaknessDetectability.MODERATE,
                technicalImpacts = ThreatTechnicalImpact.MODERATE,
                businessImpact = ThreatBusinessImpact.MODERATE)

    }

    private fun createHighDiscretethreatPresence(): DiscreteThreatPresence {
        return DiscreteThreatPresence(
                isPresent = true,
                hasCapacity = true,
                hasIntention = true,
                hasHistory = true,
                isTarget = false
        )
    }

}