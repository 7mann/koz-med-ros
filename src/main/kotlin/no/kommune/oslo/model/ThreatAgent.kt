package no.kommune.oslo.model

data class ThreatAgent(
        val threatAgentType: ThreatAgentType,
        val threatAgent: String,
        val description: String,
        val motivation: String,
        val affiliation: String,
        val threats: List<Threat>,
        val source: String
)