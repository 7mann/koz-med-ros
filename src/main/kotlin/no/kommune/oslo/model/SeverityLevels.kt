package no.kommune.oslo.model

enum class SeverityLevels(val severityLevelValue: Int) {
    INSIGNIFICANT(100), LOW(200), MODERATE(300), HIGH(400), EXTREME(500)
    // Severity levels is in hundreds to have the possibility add some granularity
}