package no.kommune.oslo.kozmedros.model

import kotlinx.serialization.Serializable
import no.kommune.oslo.kozmedros.model.enums.ThreatTypes

@Serializable
data class Threat(val threatType: ThreatTypes,
                  val threatName: String,
                  val description: String,
                  val threatPresence: ThreatPresence,
                  val target: String,
                  val reference: String,
                  val exploitedVulnerabilities: List<Vulnerability> = emptyList()
) {
    companion object Factory {
        fun emptyThreat(): Threat {
            val emptyThreatPresence = EmptyThreatPresence()
            return Threat(
                    threatType = ThreatTypes.EMPTY,
                    threatName = "EMPTY",
                    description = "Empty threasdsafe threat",
                    threatPresence = emptyThreatPresence,
                    target = "NONE",
                    reference = "NONE",
                    exploitedVulnerabilities = emptyList()
            )
        }
    }

    fun isEmpty(): Boolean {
        if (threatType == ThreatTypes.EMPTY) return true
        return false
    }
}