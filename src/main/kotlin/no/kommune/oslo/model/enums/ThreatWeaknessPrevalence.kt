package no.kommune.oslo.model.enums

enum class ThreatWeaknessPrevalence(val threatExploitability: Int) {
    WIDESPREAD(threatExploitability = 3),
    COMMON(threatExploitability = 2),
    UNCOMMON(threatExploitability = 1)
}
