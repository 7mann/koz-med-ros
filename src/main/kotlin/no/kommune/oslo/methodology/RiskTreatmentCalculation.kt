package no.kommune.oslo.methodology

import no.kommune.oslo.model.RiskTreatment
import no.kommune.oslo.model.SeverityLevels

interface RiskTreatmentCalculation {
    fun calculateRiskTreatment(riskTreatment: RiskTreatment): SeverityLevels
}