package no.kommune.oslo.methodology

//import mu.KotlinLogging
import no.kommune.oslo.model.Asset
import no.kommune.oslo.model.SeverityLevels.*
import no.kommune.oslo.model.Threat

object MaxRiskCalcStrategy : RiskCalculationStrategy {
//    private val logger = KotlinLogging.logger {}

    val maxScore = EXTREME
    val weightFactorPercentage = 5

    /**
     * Calculates the damage potential based on the asset value
     */
    override fun calculateDamagePotential(assets: List<Asset>): Int {
        var maxAsset = assets[0]
        for (asset in assets) {
            if (asset.getAssetValue().severityLevel > maxAsset.getAssetValue().severityLevel) {
                maxAsset = asset
            }
            //Add asset weight: add a weight factor that reflects number of  assets
        }
        val additionalWeight = (assets.size - 1) * weightFactorPercentage * maxAsset.getAssetValue().severityLevel.severityLevelValue / 100
//        logger.debug { "Calculated additional weight: $additionalWeight" }

        print("additionalWeight: $additionalWeight")
        //Round to nearest 100
        var maxAssetValueWithWeight = maxAsset.getAssetValue().severityLevel.severityLevelValue + additionalWeight
        maxAssetValueWithWeight = (maxAssetValueWithWeight + (maxAssetValueWithWeight%100)) - (maxAssetValueWithWeight + maxAssetValueWithWeight%100)%100
        println("maxAssetValue: $maxAssetValueWithWeight")


        return maxAssetValueWithWeight

    }

    override fun calculateThreatPresence(threats: List<Threat>): Int {
//        var maxThreat = threats[0]
//        for (threat in threats){
//            if (threat.threatLevel > maxThreat.threatLevel) {
//                maxThreat = threat
//            }
//        }


        TODO("Not yet implemented")
    }
}