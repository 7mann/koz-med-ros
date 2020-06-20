package no.kommune.oslo.methodology

import no.kommune.oslo.model.Asset
import no.kommune.oslo.model.Risk
import no.kommune.oslo.model.Vulnerability
import no.kommune.oslo.model.enums.SeverityLevel

interface RiskCalculation {
    fun calculateDamagePotential(assets: List<Asset>, weightFactorPercentage: Int = 5): SeverityLevel
    fun calculateThreatPresence(risk: Risk, weightFactorPercentage: Int = 5): SeverityLevel
    fun calculateExistingVulnerability(vulnerabilities: List<Vulnerability>, weightFactorPercentage: Int = 5): SeverityLevel
    fun calculateFutureVulnerability(vulnerabilities: List<Vulnerability>, weightFactorPercentage: Int = 5): SeverityLevel
}