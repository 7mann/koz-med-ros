package no.kommune.oslo.kozmedros.model

import no.kommune.oslo.kozmedros.methodology.RiskCalculation

data class Risk(
        val id: Int,
        val description: String,
        val assets: List<Asset>,
        val threatPresenceList: List<RiskItem>,
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