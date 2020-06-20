package no.kommune.oslo.model

import no.kommune.oslo.model.enums.*

data class OwaspThreatPresence(
        val exploitability: ThreatExploitability,
        val weaknessPrevalence: ThreatWeaknessPrevalence,
        val weaknessDetectability: ThreatWeaknessDetectability,
        val technicalImpacts: ThreatTechnicalImpact,
        val businessImpact: ThreatBusinessImpact
) : ThreatPresence {

    override fun getThreatPresenceParameters(): Map<String, String> {
        return mapOf(
                "exploitability" to exploitability.toString(),
                "weaknessPrevalence" to weaknessPrevalence.toString(),
                "weaknessDetectability" to weaknessDetectability.toString(),
                "technicalImpacts" to technicalImpacts.toString(),
                "businessImpact" to businessImpact.toString()
        )
    }

    override fun getSeverityLevel(): SeverityLevel {
        val threatLevel: Int = exploitability.exploitability +
                weaknessPrevalence.threatExploitability +
                weaknessDetectability.threatWeaknessDetectability +
                technicalImpacts.threatTechnicalImpact +
                businessImpact.threatBusinessImpact
        return owasp2sevlevel(threatLevel)
    }

    fun owasp2sevlevel(owaspThreatPresence: Int): SeverityLevel {
        var sevlevel = (200 * owaspThreatPresence) / 5 - 1
        return SeverityLevel.roundSeverityLevel(sevlevel)
    }
}