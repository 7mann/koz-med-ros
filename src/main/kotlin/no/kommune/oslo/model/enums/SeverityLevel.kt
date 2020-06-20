package no.kommune.oslo.model.enums

enum class SeverityLevel(val severityLevelValue: Int) {
    // Severity levels is in hundreds to have the possibility add some granularity
    NONE(severityLevelValue = 0),
    INSIGNIFICANT(severityLevelValue = 100),
    LOW(severityLevelValue = 200),
    MODERATE(severityLevelValue = 300),
    HIGH(severityLevelValue = 400),
    EXTREME(severityLevelValue = 500),
    INVALID(severityLevelValue = -1);

    companion object {
        private val severityValues: Array<SeverityLevel> = values()
        fun getByValue(numberValue: Int): SeverityLevel {
            return severityValues.firstOrNull { it.severityLevelValue == numberValue } ?: return INVALID
        }

        fun roundSeverityLevel(severityLevelToRound: Int): SeverityLevel {
            var roundedSeverityLevel = severityLevelToRound
            roundedSeverityLevel = (roundedSeverityLevel + (roundedSeverityLevel % 100)) - (roundedSeverityLevel + roundedSeverityLevel % 100) % 100 // Not very elegant but modulus number theory is rusty
            if (roundedSeverityLevel > EXTREME.severityLevelValue) { // No legal value above EXTREME
                roundedSeverityLevel = EXTREME.severityLevelValue
            }
            return getByValue(roundedSeverityLevel)
        }
    }
}
