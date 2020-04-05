package no.kommune.oslo.methodology

//import mu.KLogging
import no.kommune.oslo.model.RiskTestFactory
import org.junit.jupiter.api.Test

internal class MaxRiskCalcStrategyTest {

    @Test
    fun calculateDamagePotential() {
        val assetList = RiskTestFactory.createModerateAssetList()
        var damagePotential = MaxRiskCalcStrategy.calculateDamagePotential(assetList)
        println("damagePotential: $damagePotential")
    }
}