package no.kommune.oslo.model

data class Risk(
    val id: Int,
    val description: String,
    val assets: List<Asset>,
    val threats: List<Threat>,
    val vulnerabilities: List<Vulnerability>,
    val existingMitigations: List<Mitigation>,
    val probabilityWithExistingMitigations: Int,
    val consequenceWithExistingMitigations: Int,
    val plannedMitigations: List<Mitigation>,
    val probabilityWithPlannedMitigations: Int,
    val consequenceWithPlannedMitigations: Int
)