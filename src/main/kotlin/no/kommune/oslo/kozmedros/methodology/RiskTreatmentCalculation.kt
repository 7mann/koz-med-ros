package no.kommune.oslo.kozmedros.methodology

import no.kommune.oslo.kozmedros.model.RiskTreatment
import no.kommune.oslo.kozmedros.model.enums.SeverityLevel

interface RiskTreatmentCalculation {
    fun calculateRiskTreatment(riskTreatment: RiskTreatment): SeverityLevel
}