package no.kommune.oslo.kozmedros.model.enums

enum class ThreatBusinessImpact(val threatBusinessImpact: Int) {
    SEVERE(threatBusinessImpact = 3),
    MODERATE(threatBusinessImpact = 2),
    MINOR(threatBusinessImpact = 1)
}
