package no.kommune.oslo.methodology

import no.kommune.oslo.model.Asset
import no.kommune.oslo.model.RiskTestFactory
import no.kommune.oslo.model.SeverityLevels.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import kotlin.test.assertFailsWith


internal class MaxRiskCalcStrategyTest {

    @Test
    fun `Expect exception thrown when method called with illegal arguments`() {
        assertFailsWith<IllegalArgumentException> {
            val assetList: List<Asset> = emptyList()
            val calculateDamagePotential = MaxRiskCalcStrategy.calculateDamagePotential(assetList)
        }
    }

    @Test
    fun `Expect damage potential calculated with addtional asset weight`() {
        val assetList = RiskTestFactory.createModerateAssetList()
        var damagePotential = MaxRiskCalcStrategy.calculateDamagePotential(assetList)
        assertThat(damagePotential).isEqualTo(EXTREME.severityLevelValue)
    }

    @Test
    fun `Expect damage potential calculated not exceeding EXTREME`() {
        val assetList = RiskTestFactory.createHighAssetList()
        var damagePotential = MaxRiskCalcStrategy.calculateDamagePotential(assetList)
        assertThat(damagePotential).isLessThanOrEqualTo(EXTREME.severityLevelValue)
    }
}