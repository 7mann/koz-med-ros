package no.kommune.oslo.methodology

import no.kommune.oslo.model.Asset
import no.kommune.oslo.model.RiskItem
import no.kommune.oslo.model.SeverityLevels.EXTREME
import no.kommune.oslo.model.Threat
import org.apache.logging.log4j.LogManager


object MaxRiskCalcStrategy : RiskCalculationStrategy {
    private val logger = LogManager.getLogger(javaClass)

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
        if (assets.isEmpty()) {
            logger.error("calculateDamagePotential is called with illegal asset list parameter. Can not be of size 0!")
            throw IllegalArgumentException("Asset list can not be null or of size 0!")
        }
        return calculateRiskItemsValue(assets, weightFactorPercentage)
    }

    override fun calculateThreatPresence(threats: List<Threat>, weightFactorPercentage: Int): Int {
        if (threats.isEmpty()) {
            logger.error("calculateThreatPresence is called with illegal threat list parameter. Can not be of size 0!")
            throw IllegalArgumentException("Asset list can not be null or of size 0!")
        }
        return calculateRiskItemsValue(threats, weightFactorPercentage)
    }

    private fun calculateRiskItemsValue(riskItems: List<RiskItem>, weightFactorPercentage: Int): Int {
        var maxRiskItem: RiskItem = riskItems[0]
        for (riskItem: RiskItem in riskItems) {
            if (riskItem.getSeverityLevel() > maxRiskItem.getSeverityLevel()) {
                maxRiskItem = riskItem
            }
        }
        val additionalWeight = (riskItems.size - 1) * weightFactorPercentage * maxRiskItem.getSeverityLevel().severityLevelValue / 100 //Add asset weight: add a weight factor that reflects number of  assets
        logger.debug("Calculated additional weight: $additionalWeight")
        var maxRiskItemValueWithWeight = maxRiskItem.getSeverityLevel().severityLevelValue + additionalWeight //Round to nearest 100
        logger.debug("maxRiskItemValueWithWeight with additional weight: $maxRiskItemValueWithWeight")
        maxRiskItemValueWithWeight = (maxRiskItemValueWithWeight + (maxRiskItemValueWithWeight % 100)) - (maxRiskItemValueWithWeight + maxRiskItemValueWithWeight % 100) % 100 // Not very elegant but modulus number theory is rusty
        logger.debug("maxRiskItemValueWithWeight rounder to closest 100: $maxRiskItemValueWithWeight")
        if (maxRiskItemValueWithWeight > EXTREME.severityLevelValue) { // No legal value above EXTREME
            logger.debug("maxRiskItemValueWithWeight: $maxRiskItemValueWithWeight is illegal greater than $EXTREME, setting to EXTREME=${EXTREME.severityLevelValue}")
            maxRiskItemValueWithWeight = EXTREME.severityLevelValue
        }
        return maxRiskItemValueWithWeight
    }
}