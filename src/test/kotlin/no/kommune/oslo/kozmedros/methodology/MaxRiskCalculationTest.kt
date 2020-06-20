package no.kommune.oslo.kozmedros.methodology

import no.kommune.oslo.kozmedros.model.Asset
import no.kommune.oslo.kozmedros.model.Risk
import no.kommune.oslo.kozmedros.model.RiskItem
import no.kommune.oslo.kozmedros.model.RiskTestFactory
import no.kommune.oslo.kozmedros.model.enums.SeverityLevel.EXTREME
import no.kommune.oslo.kozmedros.model.enums.SeverityLevel.HIGH
import org.apache.logging.log4j.LogManager
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import kotlin.test.assertFailsWith


internal class MaxRiskCalculationTest {
    private val logger = LogManager.getLogger(javaClass)

    @Test
    fun `Expect exception thrown when damage calculation method is called with illegal arguments`() {
        assertFailsWith<IllegalArgumentException> {
            val assetList: List<Asset> = emptyList()
            MaxRiskCalculation.calculateDamagePotential(assetList)
        }
        assertFailsWith<IllegalArgumentException> {
            val assetList = RiskTestFactory.createModerateAssetList()
            MaxRiskCalculation.calculateDamagePotential(assetList, -1)
        }
    }

    @Test
    fun `Expect damage potential calculated with additional asset weight`() {
        val assetList = RiskTestFactory.createModerateAssetList()
        val damagePotential = MaxRiskCalculation.calculateDamagePotential(assetList)
        assertThat(damagePotential.severityLevelValue).isEqualTo(EXTREME.severityLevelValue)
    }

    @Test
    fun `Expect damage potential calculated not exceeding EXTREME`() {
        val assetList = RiskTestFactory.createHighAssetList()
        val damagePotential = MaxRiskCalculation.calculateDamagePotential(assetList)
        assertThat(damagePotential.severityLevelValue).isLessThanOrEqualTo(EXTREME.severityLevelValue)
    }

    @Test
    fun `Expect exception thrown when threat calculation method is called with illegal arguments`() {
        assertFailsWith<IllegalArgumentException> {
            val threatPresenceList: List<RiskItem> = emptyList()
            val risk = Risk(
                    id = 1,
                    description = "Test risk",
                    assets = emptyList(),
                    threatPresenceList = threatPresenceList,
                    vulnerabilities = emptyList(),
                    existingRiskTreatments = emptyList(),
                    probabilityWithExistingMitigations = 3,
                    consequenceWithExistingMitigations = 3,
                    plannedRiskTreatments = emptyList(),
                    probabilityWithPlannedMitigations = 3,
                    consequenceWithPlannedMitigations = 3,
                    riskCalculation = MaxRiskCalculation,
                    riskAppetite = RiskTestFactory.createRiskApetite()
            )
            MaxRiskCalculation.calculateThreatPresence(risk)
        }
        assertFailsWith<IllegalArgumentException> {
            val threatPresenceList: List<RiskItem> = RiskTestFactory.createHighDiscreteThreatPresenceList()
            val risk = Risk(
                    id = 1,
                    description = "Test risk",
                    assets = emptyList(),
                    threatPresenceList = threatPresenceList,
                    vulnerabilities = emptyList(),
                    existingRiskTreatments = emptyList(),
                    probabilityWithExistingMitigations = 3,
                    consequenceWithExistingMitigations = 3,
                    plannedRiskTreatments = emptyList(),
                    probabilityWithPlannedMitigations = 3,
                    consequenceWithPlannedMitigations = 3,
                    riskCalculation = MaxRiskCalculation,
                    riskAppetite = RiskTestFactory.createRiskApetite()
            )
            MaxRiskCalculation.calculateThreatPresence(risk, -1)
        }
    }

    @Test
    fun `Expect threat presence calculated with additional asset weight`() {
        val threatPresenceList: List<RiskItem> = RiskTestFactory.createModerateDiscreteThreatPresenceList()
        val risk = Risk(
                id = 1,
                description = "Test risk",
                assets = emptyList(),
                threatPresenceList = threatPresenceList,
                vulnerabilities = emptyList(),
                existingRiskTreatments = emptyList(),
                probabilityWithExistingMitigations = 3,
                consequenceWithExistingMitigations = 3,
                plannedRiskTreatments = emptyList(),
                probabilityWithPlannedMitigations = 3,
                consequenceWithPlannedMitigations = 3,
                riskCalculation = MaxRiskCalculation,
                riskAppetite = RiskTestFactory.createRiskApetite()
        )
        val threatPresence = MaxRiskCalculation.calculateThreatPresence(risk)
        assertThat(threatPresence.severityLevelValue).isEqualTo(HIGH.severityLevelValue)
    }

    @Test
    fun `Expect threat presence calculated not exceeding EXTREME`() {
        val threatPresenceList: List<RiskItem> = RiskTestFactory.createHighDiscreteThreatPresenceList()
        val risk = Risk(
                id = 1,
                description = "Test risk",
                assets = emptyList(),
                threatPresenceList = threatPresenceList,
                vulnerabilities = emptyList(),
                existingRiskTreatments = emptyList(),
                probabilityWithExistingMitigations = 3,
                consequenceWithExistingMitigations = 3,
                plannedRiskTreatments = emptyList(),
                probabilityWithPlannedMitigations = 3,
                consequenceWithPlannedMitigations = 3,
                riskCalculation = MaxRiskCalculation,
                riskAppetite = RiskTestFactory.createRiskApetite()
        )
        val threatPresence = MaxRiskCalculation.calculateThreatPresence(risk, weightFactorPercentage = 20)
        assertThat(threatPresence.severityLevelValue).isLessThanOrEqualTo(EXTREME.severityLevelValue)
    }

    @Test
    fun calculateExistingVulnerability() {
        val vulnerabilities = RiskTestFactory.createVulnerabilityList()
        val vulnerabilityLevel = MaxRiskCalculation.calculateExistingVulnerability(vulnerabilities)
        logger.debug("vulnerabilityLevel: $vulnerabilityLevel")
    }

    @Test
    fun calculateFutureVulnerability() {
//        throw
    }

}