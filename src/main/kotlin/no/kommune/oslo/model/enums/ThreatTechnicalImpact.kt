package no.kommune.oslo.model.enums

enum class ThreatTechnicalImpact(val threatTechnicalImpact: Int) {
    SEVERE(threatTechnicalImpact = 3),
    MODERATE(threatTechnicalImpact = 2),
    MINOR(threatTechnicalImpact = 1)
}