package no.kommune.oslo.methodology

import no.kommune.oslo.model.RiskTestFactory
import org.junit.jupiter.api.Test

internal class MaxRiskCalcStrategyTest {
//    companion object {
//        private val logger = org.slf4j.LoggerFactory.getLogger(MaxRiskCalcStrategyTest::class.java)
//    }

    @Test
    fun calculateDamagePotential() {
        val assetList = RiskTestFactory.createModerateAssetList()
        var damagePotential = MaxRiskCalcStrategy.calculateDamagePotential(assetList)
        println("damagePotential: $damagePotential")
//        logger.debug("damagePotential: $damagePotential")
//        var rest = 15 % 5
//        println("rest: $rest")
//        MaxRiskCalcStrategy.calculateDamagePotential()
    }
}