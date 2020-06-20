package no.kommune.oslo.methodology

import no.kommune.oslo.model.RiskTreatment
import no.kommune.oslo.model.enums.SeverityLevel

interface RiskTreatmentCalculation {
    fun calculateRiskTreatment(riskTreatment: RiskTreatment): SeverityLevel
}