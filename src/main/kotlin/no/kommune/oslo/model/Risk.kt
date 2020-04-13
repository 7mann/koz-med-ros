package no.kommune.oslo.model

import no.kommune.oslo.methodology.RiskCalculation

data class Risk(
        val id: Int,
        val description: String,
        val assets: List<Asset>,
        val threats: List<Threat>,
        val vulnerabilities: List<Vulnerability>,
        val existingRiskTreatments: List<RiskTreatment>,
        val probabilityWithExistingMitigations: Int,
        val consequenceWithExistingMitigations: Int,
        val plannedRiskTreatments: List<RiskTreatment>,
        val probabilityWithPlannedMitigations: Int,
        val consequenceWithPlannedMitigations: Int,
        val riskCalculation: RiskCalculation,
        val riskAppetite: RiskAppetite
)