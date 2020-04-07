package no.kommune.oslo.methodology

import no.kommune.oslo.model.Asset
import no.kommune.oslo.model.SeverityLevels.EXTREME
import no.kommune.oslo.model.Threat
import org.apache.logging.log4j.LogManager


object MaxRiskCalcStrategy : RiskCalculationStrategy {
    private val logger = LogManager.getLogger(javaClass)
    val maxScore = EXTREME

    /**
     * Calculates the damage potential based on the asset value. This algorithm implementation is fairly simple since
     * it more or less finds the asset that has max value, and use that as a base for damage potential.
     * If more that one asset in list, and additional weight is added to the maxAsset value based on number
     * of assets and weightFactorPercentage
     *
     * @param assets list of assets to calculate damage potential
     * @param weightFactorPercentage percentage of asset value to add based on number of assets. Note! Defaults from interface method signature
     */
    override fun calculateDamagePotential(assets: List<Asset>, weightFactorPercentage: Int): Int {
        if (assets == null || assets.size == 0) {
            logger.error("calculateDamagePotential is called with illegal asset list parameter. Can not be null or of size 0!")
            throw IllegalArgumentException("Asset list can not be null or of size 0!")
        }
        var maxAsset = assets[0]
        for (asset in assets) {
            if (asset.getAssetValue().severityLevel > maxAsset.getAssetValue().severityLevel) {
                maxAsset = asset
            }
        }
        val additionalWeight = (assets.size - 1) * weightFactorPercentage * maxAsset.getAssetValue().severityLevel.severityLevelValue / 100 //Add asset weight: add a weight factor that reflects number of  assets
        logger.debug("Calculated additional weight: $additionalWeight")
        var maxAssetValueWithWeight = maxAsset.getAssetValue().severityLevel.severityLevelValue + additionalWeight //Round to nearest 100
        logger.debug("maxAssetValueWithWeight with additional weight: $maxAssetValueWithWeight")
        maxAssetValueWithWeight = (maxAssetValueWithWeight + (maxAssetValueWithWeight % 100)) - (maxAssetValueWithWeight + maxAssetValueWithWeight % 100) % 100 // Not very elegant but modulus number theory is rusty
        logger.debug("maxAssetValueWithWeight rounder to closest 100: $maxAssetValueWithWeight")
        if (maxAssetValueWithWeight > EXTREME.severityLevelValue) { // No legal value above EXTREME
            logger.debug("maxAssetValueWithWeight: $maxAssetValueWithWeight is illegal greater than $EXTREME, setting to EXTREME=${EXTREME.severityLevelValue}")
            maxAssetValueWithWeight = EXTREME.severityLevelValue
        }
        return maxAssetValueWithWeight
    }

    override fun calculateThreatPresence(threats: List<Threat>): Int {
        throw NoSuchMethodException("Method not implemented yet...")
//        var maxThreat = threats[0]
//        for (threat in threats) {
//            if (threat.threatPresence.threatPresenceValue > maxThreat.threatPresence.threatPresenceValue) {
//                maxThreat = threat
//            }
//        }
//
//        return 42
    }
}