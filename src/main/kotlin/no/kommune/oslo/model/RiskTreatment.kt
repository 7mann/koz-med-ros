package no.kommune.oslo.model

import no.kommune.oslo.model.enums.RiskTreatmentStatus
import no.kommune.oslo.model.enums.RiskTreatmentTypes
import no.kommune.oslo.model.enums.SeverityLevel

data class RiskTreatment(
        val description: String,
        val riskTreatmentType: RiskTreatmentTypes,
        val riskTreatmentStatus: RiskTreatmentStatus,
        val riskTreatmentImpact: SeverityLevel
) : RiskItem {
    override fun getSeverityLevel(): SeverityLevel {
        return this.riskTreatmentImpact
    }
}
