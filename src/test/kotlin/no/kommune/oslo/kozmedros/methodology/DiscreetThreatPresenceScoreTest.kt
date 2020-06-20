package no.kommune.oslo.kozmedros.methodology

import no.kommune.oslo.kozmedros.model.DiscreteThreatPresence
import no.kommune.oslo.kozmedros.model.enums.SeverityLevel.MODERATE
import org.apache.logging.log4j.LogManager
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DiscreetThreatPresenceScoreTest {
    private val logger = LogManager.getLogger(javaClass)

    @Test
    fun `Expect MODERATE threat presence when using DescreteThreatPresence strategy`() {
        val discreetThreatPresenceCalculation = DiscreteThreatPresence(isPresent = true, hasCapacity = false, hasIntention = true, hasHistory = true, isTarget = false)
        logger.debug("Threat presence is: ${discreetThreatPresenceCalculation.getSeverityLevel()}, expected value is $MODERATE")
        assertThat(discreetThreatPresenceCalculation.getSeverityLevel()).isEqualTo(MODERATE)
    }
}