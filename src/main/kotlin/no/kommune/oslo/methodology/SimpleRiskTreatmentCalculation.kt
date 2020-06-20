package no.kommune.oslo.methodology

import no.kommune.oslo.model.RiskTreatment
import no.kommune.oslo.model.enums.SeverityLevel

class SimpleRiskTreatmentCalculation : RiskTreatmentCalculation {
    override fun calculateRiskTreatment(riskTreatment: RiskTreatment): SeverityLevel {
        return riskTreatment.getSeverityLevel()
    }
}