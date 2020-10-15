package no.kommune.oslo.kozmedros.model

interface ThreatPresence : RiskItem {
    fun getThreatPresenceParameters(): Map<String, String>
}