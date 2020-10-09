package no.kommune.oslo.kozmedros.model.enums

enum class ThreatWeaknessDetectability(val weaknessDetectability: Int) {
    EASY(weaknessDetectability = 3),
    AVERAGE(weaknessDetectability = 2),
    DIFFICULT(weaknessDetectability = 1)
}
