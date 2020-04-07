package no.kommune.oslo.model

import no.kommune.oslo.model.SeverityLevels.*
import no.kommune.oslo.model.ThreatTypes.*
import org.apache.logging.log4j.LogManager
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import kotlin.math.log

internal class DiscreetThreatPresenceTest {
    private val logger = LogManager.getLogger(javaClass)

    @Test
    fun `Expect MODERATE threat presence when using DescreteThreatPresence strategy`() {
        val threat = Threat(
                DELIBERATE,
                DiscreetThreatPresence(isPresent = true, hasCapacity = false, hasIntention = true, hasHistory = true, isTarget = false),
                "Test threat"
        )
        logger.debug("Threat presence is: ${threat.threatPresence.threatPresenceValue}, expected value is $MODERATE")
        assertThat(threat.threatPresence.threatPresenceValue).isEqualTo(MODERATE)
    }
}