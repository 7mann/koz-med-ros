package no.kommune.oslo.model.enums

enum class ThreatBusinessImpact(val threatBusinessImpact: Int) {
    SEVERE(threatBusinessImpact = 3),
    MODERATE(threatBusinessImpact = 2),
    MINOR(threatBusinessImpact = 1)
}
