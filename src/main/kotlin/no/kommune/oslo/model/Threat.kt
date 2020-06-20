package no.kommune.oslo.model

import no.kommune.oslo.model.enums.ThreatTypes

data class Threat(val threatType: ThreatTypes,
                  val threatName: String,
                  val description: String,
                  val threatPresence: ThreatPresence,
                  val target: String,
                  val reference: String,
                  val exploitedVulnerabilities: List<Vulnerability> = emptyList()
)