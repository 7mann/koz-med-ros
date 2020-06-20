package no.kommune.oslo.model.enums

enum class ThreatWeaknessDetectability(val threatWeaknessDetectability: Int) {
    SEVERE(threatWeaknessDetectability = 3),
    MODERATE(threatWeaknessDetectability = 2),
    MINOR(1)
}
