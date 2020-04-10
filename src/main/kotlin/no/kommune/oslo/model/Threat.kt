package no.kommune.oslo.model

import no.kommune.oslo.methodology.ThreatPresenceCalculation

data class Threat(val threatType: ThreatTypes, val threatPresenceCalculation: ThreatPresenceCalculation, val description: String) : RiskItem {
    override fun getSeverityLevel(): SeverityLevels {
        return threatPresenceCalculation.threatPresenceValue
    }
}