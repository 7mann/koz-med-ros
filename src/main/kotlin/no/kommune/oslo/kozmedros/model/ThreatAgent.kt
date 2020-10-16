package no.kommune.oslo.kozmedros.model

import kotlinx.serialization.Serializable
import no.kommune.oslo.kozmedros.model.enums.ThreatAgentType

@Serializable
data class ThreatAgent(
        val threatAgentType: ThreatAgentType,
        val threatAgent: String,
        val description: String,
        val motivation: String,
        val affiliation: String,
//        val threats: List<Threat>,
        val source: String
)