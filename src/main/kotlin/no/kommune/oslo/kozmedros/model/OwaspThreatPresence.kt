package no.kommune.oslo.kozmedros.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import no.kommune.oslo.kozmedros.model.enums.*

@Serializable
@SerialName("owasp")
data class OwaspThreatPresence(
        val exploitability: ThreatExploitability,
        val weaknessPrevalence: ThreatWeaknessPrevalence,
        val weaknessDetectability: ThreatWeaknessDetectability,
        val technicalImpact: ThreatTechnicalImpact,
        val businessImpact: ThreatBusinessImpact
) : ThreatPresence {

    override fun getThreatPresenceParameters(): Map<String, String> {
        return mapOf(
                "exploitability" to exploitability.toString(),
                "weaknessPrevalence" to weaknessPrevalence.toString(),
                "weaknessDetectability" to weaknessDetectability.toString(),
                "technicalImpact" to technicalImpact.toString(),
                "businessImpact" to businessImpact.toString()
        )
    }

    override fun getSeverityLevel(): SeverityLevel {
        val threatLevel: Int = exploitability.exploitability +
                weaknessPrevalence.weaknessPrevalence +
                weaknessDetectability.weaknessDetectability +
                technicalImpact.technicalImpact +
                businessImpact.businessImpact
        return owasp2sevlevel(threatLevel)
    }

    fun owasp2sevlevel(owaspThreatPresence: Int): SeverityLevel {
        var sevlevel = (200 * owaspThreatPresence) / 5 - 1
        return SeverityLevel.roundSeverityLevel(sevlevel)
    }
}