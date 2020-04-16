package no.kommune.oslo.model

data class RiskTreatment(
        val description: String,
        val riskTreatmentType: RiskTreatmentTypes,
        val riskTreatmentStatus: RiskTreatmentStatus,
        val riskTreatmentImpact: SeverityLevels
) : RiskItem {
    override fun getSeverityLevel(): SeverityLevels {
        return this.riskTreatmentImpact
    }
}
