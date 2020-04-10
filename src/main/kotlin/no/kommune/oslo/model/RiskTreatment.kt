package no.kommune.oslo.model

data class RiskTreatment(
        val description: String,
        val riskTreatmentType: RiskTreatmentTypes,
        val riskTreatmentStatus: RiskTreatmentStatus
) {
    enum class RiskTreatmentType { EXISTING_RISK_TREATMENT, FUTURE_RISK_TREATMENT }
}
