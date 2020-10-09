package no.kommune.oslo.kozmedros.model

import no.kommune.oslo.kozmedros.model.enums.SeverityLevel

class EmptyThreatPresence() : ThreatPresence {
    override fun getThreatPresenceParameters(): Map<String, String> {
        return mapOf("EmptyThreatPresence" to SeverityLevel.NOT_EVALUATED.severityLevelValue.toString())
    }

    override fun getSeverityLevel(): SeverityLevel {
        return SeverityLevel.NOT_EVALUATED
    }
}