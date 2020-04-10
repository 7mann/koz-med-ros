package no.kommune.oslo.model

enum class SeverityLevels(val severityLevelValue: Int) {
    // Severity levels is in hundreds to have the possibility add some granularity
    NONE(severityLevelValue = 0),
    INSIGNIFICANT(severityLevelValue = 100),
    LOW(severityLevelValue = 200),
    MODERATE(severityLevelValue = 300),
    HIGH(severityLevelValue = 400),
    EXTREME(severityLevelValue = 500),
    INVALID(severityLevelValue = -1);

    companion object {
        private val severityValues: Array<SeverityLevels> = values()
        fun getByValue(numberValue: Int): SeverityLevels {
            return severityValues.firstOrNull { it.severityLevelValue == numberValue } ?: return INVALID
        }
    }
}
