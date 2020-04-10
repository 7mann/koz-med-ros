package no.kommune.oslo.methodology

import no.kommune.oslo.model.SeverityLevels.MODERATE
import no.kommune.oslo.model.Threat
import no.kommune.oslo.model.ThreatTypes.DELIBERATE
import org.apache.logging.log4j.LogManager
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DiscreetThreatPresenceCalculationTest {
    private val logger = LogManager.getLogger(javaClass)

    @Test
    fun `Expect MODERATE threat presence when using DescreteThreatPresence strategy`() {
        val threat = Threat(
                DELIBERATE,
                DiscreetThreatPresenceCalculation(isPresent = true, hasCapacity = false, hasIntention = true, hasHistory = true, isTarget = false),
                "Test threat"
        )
        logger.debug("Threat presence is: ${threat.threatPresenceCalculation.threatPresenceValue}, expected value is $MODERATE")
        assertThat(threat.threatPresenceCalculation.threatPresenceValue).isEqualTo(MODERATE)
    }
}