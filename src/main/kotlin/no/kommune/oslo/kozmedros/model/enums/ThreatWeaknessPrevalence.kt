package no.kommune.oslo.kozmedros.model.enums

enum class ThreatWeaknessPrevalence(val weaknessPrevalence: Int) {
    WIDESPREAD(weaknessPrevalence = 3),
    COMMON(weaknessPrevalence = 2),
    UNCOMMON(weaknessPrevalence = 1)
}
