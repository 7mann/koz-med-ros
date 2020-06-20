package no.kommune.oslo.kozmedros.model

import no.kommune.oslo.kozmedros.model.enums.ThreatAgentType

data class ThreatAgent(
        val threatAgentType: ThreatAgentType,
        val threatAgent: String,
        val description: String,
        val motivation: String,
        val affiliation: String,
//        val threats: List<Threat>,
        val source: String
)