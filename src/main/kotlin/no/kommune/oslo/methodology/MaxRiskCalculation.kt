package no.kommune.oslo.methodology

import no.kommune.oslo.model.*
import org.apache.logging.log4j.LogManager


object MaxRiskCalculation : RiskCalculation {
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
    override fun calculateDamagePotential(assets: List<Asset>, weightFactorPercentage: Int): SeverityLevels {
        if (assets.isEmpty() || weightFactorPercentage < 0) {
            logger.error("calculateDamagePotential is called with illegal parameters! Asset list parameter can not be of size 0 or weightFactorPercentage < 0.")
            throw IllegalArgumentException("calculateDamagePotential is called with illegal parameters! Asset list parameter can not be of size 0 or weightFactorPercentage < 0!")
        }
        return calculateRiskItemsValue(assets, weightFactorPercentage)
    }

    /**
     * Calculates the threat presence based on the threat items presence value. This algorithm implementation is fairly simple since
     * it more or less finds the threat that has max value, and use that as a base for threat presence.
     * If more that one threat in list, and additional weight is added to the value based on number
     * of threats and weightFactorPercentage
     *
     * @param threats list of threats to calculate damage potential
     * @param weightFactorPercentage percentage of asset value to add based on number of assets. Note! Defaults from interface method signature
     */
    override fun calculateThreatPresence(threats: List<Threat>, weightFactorPercentage: Int): SeverityLevels {
        if (threats.isEmpty() || weightFactorPercentage < 0) {
            logger.error("calculateThreatPresence is called with illegal parameters! Threat list parameter can not be of size 0 or weightFactorPercentage < 0.")
            throw IllegalArgumentException("Threat list can not be null or of size 0!")
        }
        return calculateRiskItemsValue(threats, weightFactorPercentage)
    }

    /**
     * Existing vulnerability is vulnerability potential minus if any existing threat treatments
     */
    override fun calculateExistingVulnerability(vulnerabilities: List<Vulnerability>, weightFactorPercentage: Int): SeverityLevels {
        if (vulnerabilities.isEmpty() || weightFactorPercentage < 0) {
            logger.error("calculateExistingVulnerability is called with illegal parameters! Vulnerability list parameter can not be of size 0 or weightFactorPercentage < 0!")
            throw IllegalArgumentException("calculateExistingVulnerability is called with illegal parameters! Vulnerability list parameter can not be of size 0 or weightFactorPercentage < 0!")
        }

        // Find vulnerabilities that has existing risk treatments
        val vulnerabilitiesWithRiskTreatments = vulnerabilities.filter { it.riskTreatments.isNotEmpty() }
        var existingRiskTreatments: MutableList<RiskTreatment> = mutableListOf()

        for (vulnerability in vulnerabilitiesWithRiskTreatments) {
            existingRiskTreatments.addAll(vulnerability.riskTreatments.filter { it.riskTreatmentStatus == RiskTreatmentStatus.EXISTING })
        }

        // Calculate vulnerability score for the list of existing risk treatments
        val existingRiskTreatmentValue = calculateRiskItemsValue(existingRiskTreatments, weightFactorPercentage)
        logger.debug("existingRiskTreatmentValue: $existingRiskTreatmentValue")

        // Find vulnerabilities without or with future risk treatments
        // Calculate vulnerability score for them
        // Calculate total score. Implement weighting of different group size when adding up
//        vulnerabilities
//        for (vulnerability: Vulnerability in vulnerabilities) {
//
//        }
        return calculateRiskItemsValue(vulnerabilities, weightFactorPercentage)
    }

    /**
     * Future vulnerability is vulnerability potential minus if any future threat treatments
     */
    override fun calculateFutureVulnerability(vulnerabilities: List<Vulnerability>, weightFactorPercentage: Int): SeverityLevels {
        if (vulnerabilities.isEmpty() || weightFactorPercentage < 0) {
            logger.error("calculateFutureVulnerability is called with illegal parameters! Vulnerability list parameter can not be of size 0 or weightFactorPercentage < 0!")
            throw IllegalArgumentException("calculateFutureVulnerability is called with illegal parameters! Vulnerability list parameter can not be of size 0 or weightFactorPercentage < 0!")
        }
        return calculateRiskItemsValue(vulnerabilities, weightFactorPercentage)
    }


    private fun calculateRiskItemsValue(riskItems: List<RiskItem>, weightFactorPercentage: Int): SeverityLevels {
        var maxRiskItem: RiskItem = riskItems[0]
        for (riskItem: RiskItem in riskItems) {
            if (riskItem.getSeverityLevel() > maxRiskItem.getSeverityLevel()) {
                maxRiskItem = riskItem
            }
        }
        val additionalWeight: Int = (riskItems.size - 1) * weightFactorPercentage * maxRiskItem.getSeverityLevel().severityLevelValue / 100 //Add asset weight: add a weight factor that reflects number of  assets
        logger.debug("Calculated additional weight: $additionalWeight")
        var maxRiskItemValueWithWeight = maxRiskItem.getSeverityLevel().severityLevelValue + additionalWeight //Round to nearest 100
        logger.debug("maxRiskItemValueWithWeight with additional weight: $maxRiskItemValueWithWeight")
        maxRiskItemValueWithWeight = SeverityLevels.roundSeverityLevel(maxRiskItemValueWithWeight).severityLevelValue
        logger.debug("maxRiskItemValueWithWeight rounded to closest 100: $maxRiskItemValueWithWeight")
        return SeverityLevels.getByValue(maxRiskItemValueWithWeight)
    }

}