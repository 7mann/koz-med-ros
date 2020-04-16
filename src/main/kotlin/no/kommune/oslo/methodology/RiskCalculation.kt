package no.kommune.oslo.methodology

import no.kommune.oslo.model.Asset
import no.kommune.oslo.model.SeverityLevels
import no.kommune.oslo.model.Threat
import no.kommune.oslo.model.Vulnerability

interface RiskCalculation {
    fun calculateDamagePotential(assets: List<Asset>, weightFactorPercentage: Int = 5): SeverityLevels
    fun calculateThreatPresence(threats: List<Threat>, weightFactorPercentage: Int = 5): SeverityLevels
    fun calculateExistingVulnerability(vulnerabilities: List<Vulnerability>, weightFactorPercentage: Int = 5): SeverityLevels
    fun calculateFutureVulnerability(vulnerabilities: List<Vulnerability>, weightFactorPercentage: Int = 5): SeverityLevels
}