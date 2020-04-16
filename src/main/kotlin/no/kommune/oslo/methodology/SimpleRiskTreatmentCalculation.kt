package no.kommune.oslo.methodology

import no.kommune.oslo.model.RiskTreatment
import no.kommune.oslo.model.SeverityLevels

class SimpleRiskTreatmentCalculation : RiskTreatmentCalculation {
    override fun calculateRiskTreatment(riskTreatment: RiskTreatment): SeverityLevels {
        return riskTreatment.getSeverityLevel()
    }
}