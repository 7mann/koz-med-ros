package no.kommune.oslo.kozmedros.model

import no.kommune.oslo.kozmedros.model.enums.RiskTreatmentStatus
import no.kommune.oslo.kozmedros.model.enums.RiskTreatmentTypes
import no.kommune.oslo.kozmedros.model.enums.SeverityLevel

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
