package no.kommune.oslo.kozmedros.model.enums

enum class ThreatTechnicalImpact(val technicalImpact: Int) {
    SEVERE(technicalImpact = 3),
    MODERATE(technicalImpact = 2),
    MINOR(technicalImpact = 1)
}