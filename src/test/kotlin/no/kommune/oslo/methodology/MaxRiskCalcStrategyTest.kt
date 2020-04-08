package no.kommune.oslo.methodology

import no.kommune.oslo.model.Asset
import no.kommune.oslo.model.RiskTestFactory
import no.kommune.oslo.model.SeverityLevels.EXTREME
import no.kommune.oslo.model.SeverityLevels.HIGH
import no.kommune.oslo.model.Threat
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import kotlin.test.assertFailsWith


internal class MaxRiskCalcStrategyTest {

    @Test
    fun `Expect exception thrown when damage calculation method is called with illegal arguments`() {
        assertFailsWith<IllegalArgumentException> {
            val assetList: List<Asset> = emptyList()
            MaxRiskCalcStrategy.calculateDamagePotential(assetList)
        }
        assertFailsWith<IllegalArgumentException> {
            val assetList = RiskTestFactory.createModerateAssetList()
            MaxRiskCalcStrategy.calculateDamagePotential(assetList, -1)
        }
    }

    @Test
    fun `Expect damage potential calculated with additional asset weight`() {
        val assetList = RiskTestFactory.createModerateAssetList()
        val damagePotential = MaxRiskCalcStrategy.calculateDamagePotential(assetList)
        assertThat(damagePotential).isEqualTo(EXTREME.severityLevelValue)
    }

    @Test
    fun `Expect damage potential calculated not exceeding EXTREME`() {
        val assetList = RiskTestFactory.createHighAssetList()
        val damagePotential = MaxRiskCalcStrategy.calculateDamagePotential(assetList)
        assertThat(damagePotential).isLessThanOrEqualTo(EXTREME.severityLevelValue)
    }

    @Test
    fun `Expect exception thrown when threat calculation method is called with illegal arguments`() {
        assertFailsWith<IllegalArgumentException> {
            val threatList: List<Threat> = emptyList()
            MaxRiskCalcStrategy.calculateThreatPresence(threatList)
        }
        assertFailsWith<IllegalArgumentException> {
            val threatList: List<Threat> = RiskTestFactory.createHighThreatList()
            MaxRiskCalcStrategy.calculateThreatPresence(threatList, -1)
        }
    }

    @Test
    fun `Expect threat presence calculated with additional asset weight`() {
        val threatList = RiskTestFactory.createModerateThreatList()
        val threatPresence = MaxRiskCalcStrategy.calculateThreatPresence(threatList)
        assertThat(threatPresence).isEqualTo(HIGH.severityLevelValue)
    }

    @Test
    fun `Expect threat presence calculated not exceeding EXTREME`() {
        val threatList = RiskTestFactory.createHighThreatList()
        val threatPresence = MaxRiskCalcStrategy.calculateThreatPresence(threatList, weightFactorPercentage = 20)
        assertThat(threatPresence).isLessThanOrEqualTo(EXTREME.severityLevelValue)
    }

}