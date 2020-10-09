package no.kommune.oslo.kozmedros.model.enums

enum class ThreatBusinessImpact(val businessImpact: Int) {
    SEVERE(businessImpact = 3),
    MODERATE(businessImpact = 2),
    MINOR(businessImpact = 1),
    NONE(businessImpact = 0),
    NOT_EVALUATED(businessImpact = -2)
}
