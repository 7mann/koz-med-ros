package no.kommune.oslo.model

data class Threat(val threatType: ThreatTypes, val threatPresence: ThreatPresence, val description: String) : RiskItem {
    override fun getSeverityLevel(): SeverityLevels {
        return threatPresence.threatPresenceValue
    }
}