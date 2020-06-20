package no.kommune.oslo.kozmedros.methodology

import no.kommune.oslo.kozmedros.model.RiskTreatment
import no.kommune.oslo.kozmedros.model.enums.SeverityLevel

class SimpleRiskTreatmentCalculation : RiskTreatmentCalculation {
    override fun calculateRiskTreatment(riskTreatment: RiskTreatment): SeverityLevel {
        return riskTreatment.getSeverityLevel()
    }
}