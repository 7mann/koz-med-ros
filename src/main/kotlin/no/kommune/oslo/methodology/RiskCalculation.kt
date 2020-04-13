package no.kommune.oslo.methodology

import no.kommune.oslo.model.Asset
import no.kommune.oslo.model.SeverityLevels
import no.kommune.oslo.model.Threat

interface RiskCalculation {
    fun calculateDamagePotential(assets: List<Asset>, weightFactorPercentage: Int = 5): SeverityLevels
    fun calculateThreatPresence(threats: List<Threat>, weightFactorPercentage: Int = 5): SeverityLevels
}