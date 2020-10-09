package no.kommune.oslo.kozmedros.model

import no.kommune.oslo.kozmedros.model.enums.*
import no.kommune.oslo.kozmedros.model.enums.AssetValueTypes.*
import no.kommune.oslo.kozmedros.model.enums.RiskTreatmentStatus.EXISTING
import no.kommune.oslo.kozmedros.model.enums.RiskTreatmentStatus.PLANNED
import no.kommune.oslo.kozmedros.model.enums.RiskTreatmentTypes.PROBABILITY_RISK_TREATMENT
import no.kommune.oslo.kozmedros.model.enums.SeverityLevel.*
import no.kommune.oslo.kozmedros.model.enums.ThreatTypes.ACCIDENTAL
import no.kommune.oslo.kozmedros.model.enums.VulnerabilityType.*

object RiskTestFactory {
    fun createRiskApetite() = RiskAppetite(
            arrayOf(
                    arrayOf(LOW, LOW, LOW, LOW, MODERATE),
                    arrayOf(LOW, LOW, LOW, MODERATE, MODERATE),
                    arrayOf(MODERATE, MODERATE, MODERATE, MODERATE, HIGH),
                    arrayOf(MODERATE, MODERATE, HIGH, HIGH, HIGH),
                    arrayOf(MODERATE, HIGH, HIGH, HIGH, HIGH)
            )
    )

    fun createModerateAssetList(): List<Asset> = listOf(
            Asset("Test medium asset 1", listOf(
                    AssetValue(CONFIDENCIALITYVALUE, MODERATE),
                    AssetValue(INTEGRITYVALUE, HIGH),
                    AssetValue(AVAILABILITYVALUE, INSIGNIFICANT))
            ),
            Asset("Test medium asset 2", listOf(
                    AssetValue(CONFIDENCIALITYVALUE, LOW),
                    AssetValue(INTEGRITYVALUE, LOW),
                    AssetValue(AVAILABILITYVALUE, INSIGNIFICANT))
            ),
            Asset("Test medium asset 3", listOf(
                    AssetValue(CONFIDENCIALITYVALUE, INSIGNIFICANT),
                    AssetValue(INTEGRITYVALUE, MODERATE),
                    AssetValue(AVAILABILITYVALUE, MODERATE))
            ),
            Asset("Test medium asset 4", listOf(
                    AssetValue(CONFIDENCIALITYVALUE, INSIGNIFICANT),
                    AssetValue(INTEGRITYVALUE, MODERATE),
                    AssetValue(AVAILABILITYVALUE, MODERATE))
            ),
            Asset("Test medium asset 5", listOf(
                    AssetValue(CONFIDENCIALITYVALUE, INSIGNIFICANT),
                    AssetValue(INTEGRITYVALUE, MODERATE),
                    AssetValue(AVAILABILITYVALUE, MODERATE))
            )
    )

    fun createLowAssetList() = listOf(
            Asset("Test medium asset 1", listOf(
                    AssetValue(CONFIDENCIALITYVALUE, LOW),
                    AssetValue(INTEGRITYVALUE, LOW),
                    AssetValue(AVAILABILITYVALUE, INSIGNIFICANT))
            ),
            Asset("Test medium asset 2", listOf(
                    AssetValue(CONFIDENCIALITYVALUE, LOW),
                    AssetValue(INTEGRITYVALUE, LOW),
                    AssetValue(AVAILABILITYVALUE, INSIGNIFICANT))
            ),
            Asset("Test medium asset 3", listOf(
                    AssetValue(CONFIDENCIALITYVALUE, INSIGNIFICANT),
                    AssetValue(INTEGRITYVALUE, INSIGNIFICANT),
                    AssetValue(AVAILABILITYVALUE, INSIGNIFICANT))
            ),
            Asset("Test medium asset 4", listOf(
                    AssetValue(CONFIDENCIALITYVALUE, INSIGNIFICANT),
                    AssetValue(INTEGRITYVALUE, INSIGNIFICANT),
                    AssetValue(AVAILABILITYVALUE, INSIGNIFICANT))
            ),
            Asset("Test medium asset 5", listOf(
                    AssetValue(CONFIDENCIALITYVALUE, INSIGNIFICANT),
                    AssetValue(INTEGRITYVALUE, INSIGNIFICANT),
                    AssetValue(AVAILABILITYVALUE, INSIGNIFICANT))
            )
    )

    fun createHighAssetList() = listOf(
            Asset("Test medium asset 1", listOf(
                    AssetValue(CONFIDENCIALITYVALUE, HIGH),
                    AssetValue(INTEGRITYVALUE, EXTREME),
                    AssetValue(AVAILABILITYVALUE, LOW))
            ),
            Asset("Test medium asset 2", listOf(
                    AssetValue(CONFIDENCIALITYVALUE, HIGH),
                    AssetValue(INTEGRITYVALUE, EXTREME),
                    AssetValue(AVAILABILITYVALUE, HIGH))
            ),
            Asset("Test medium asset 3", listOf(
                    AssetValue(CONFIDENCIALITYVALUE, EXTREME),
                    AssetValue(INTEGRITYVALUE, EXTREME),
                    AssetValue(AVAILABILITYVALUE, EXTREME))
            ),
            Asset("Test medium asset 3", listOf(
                    AssetValue(CONFIDENCIALITYVALUE, INSIGNIFICANT),
                    AssetValue(INTEGRITYVALUE, EXTREME),
                    AssetValue(AVAILABILITYVALUE, EXTREME))
            )
    )

    fun createHighDiscreteThreatPresenceList() = listOf(
            DiscreteThreatPresence(isPresent = true,
                    hasCapacity = false,
                    hasIntention = false,
                    hasHistory = true,
                    isTarget = false),
            DiscreteThreatPresence(isPresent = true,
                    hasCapacity = false,
                    hasIntention = true,
                    hasHistory = true,
                    isTarget = false),
            DiscreteThreatPresence(isPresent = true,
                    hasCapacity = true,
                    hasIntention = true,
                    hasHistory = true,
                    isTarget = false),
            DiscreteThreatPresence(isPresent = true,
                    hasCapacity = false,
                    hasIntention = true,
                    hasHistory = true,
                    isTarget = true)
    )

    fun createModerateDiscreteThreatPresenceList() = listOf(
            DiscreteThreatPresence(isPresent = true,
                    hasCapacity = false,
                    hasIntention = false,
                    hasHistory = true,
                    isTarget = false),
            DiscreteThreatPresence(isPresent = true,
                    hasCapacity = false,
                    hasIntention = true,
                    hasHistory = true,
                    isTarget = false),
            DiscreteThreatPresence(isPresent = true,
                    hasCapacity = false,
                    hasIntention = false,
                    hasHistory = true,
                    isTarget = false),
            DiscreteThreatPresence(isPresent = true,
                    hasCapacity = false,
                    hasIntention = true,
                    hasHistory = true,
                    isTarget = false),
            DiscreteThreatPresence(isPresent = true,
                    hasCapacity = false,
                    hasIntention = true,
                    hasHistory = true,
                    isTarget = false)
    )

    fun createMixedRiskTreatmentList() = listOf(
            RiskTreatment(
                    description = "Test RiskTreatment 1",
                    riskTreatmentType = PROBABILITY_RISK_TREATMENT,
                    riskTreatmentStatus = PLANNED,
                    riskTreatmentImpact = LOW
            ),
            RiskTreatment(
                    description = "Test RiskTreatment 2",
                    riskTreatmentType = PROBABILITY_RISK_TREATMENT,
                    riskTreatmentStatus = EXISTING,
                    riskTreatmentImpact = LOW
            ),
            RiskTreatment(
                    description = "Test RiskTreatment 3",
                    riskTreatmentType = PROBABILITY_RISK_TREATMENT,
                    riskTreatmentStatus = PLANNED,
                    riskTreatmentImpact = MODERATE
            )
    )

    fun createLowExistingRiskTreatmentList() = listOf(
            RiskTreatment(
                    description = "Test Existing RiskTreatment 1",
                    riskTreatmentType = PROBABILITY_RISK_TREATMENT,
                    riskTreatmentStatus = EXISTING,
                    riskTreatmentImpact = LOW
            ),
            RiskTreatment(
                    description = "Test Existing RiskTreatment 2",
                    riskTreatmentType = PROBABILITY_RISK_TREATMENT,
                    riskTreatmentStatus = EXISTING,
                    riskTreatmentImpact = LOW
            ),
            RiskTreatment(
                    description = "Test Existing RiskTreatment 3",
                    riskTreatmentType = PROBABILITY_RISK_TREATMENT,
                    riskTreatmentStatus = EXISTING,
                    riskTreatmentImpact = MODERATE
            )
    )

    fun createVulnerabilityList() = listOf(
            Vulnerability(
                    vulnerabilityType = TECHNICAL,
                    vulnerabilityDescription = "Test vulnerability 1",
                    vulnerabilityPotential = LOW,
                    reference = "Test"),
            Vulnerability(
                    vulnerabilityType = HUMAN,
                    vulnerabilityDescription = "Test vulnerability 2",
                    vulnerabilityPotential = MODERATE,
                    reference = "Test"),
            Vulnerability(
                    vulnerabilityType = ORGANIZATIONAL,
                    vulnerabilityDescription = "Test vulnerability 3",
                    vulnerabilityPotential = HIGH,
                    reference = "Test"),
            Vulnerability(
                    vulnerabilityType = TECHNICAL,
                    vulnerabilityDescription = "Test vulnerability 4",
                    vulnerabilityPotential = EXTREME,
                    reference = "Test"),
            Vulnerability(
                    vulnerabilityType = TECHNICAL,
                    vulnerabilityDescription = "Test vulnerability 5",
                    vulnerabilityPotential = LOW,
                    reference = "Test")
    )

    fun createThreatAgentList(): List<ThreatAgent> {
        return listOf<ThreatAgent>(
                ThreatAgent(
                        threatAgentType = ThreatAgentType.HUMAN,
                        threatAgent = "Test agent 1",
                        description = "Test agent 1 description",
                        motivation = "Motivation 1",
                        affiliation = "Affiliation 1",
                        source = "Source 1"
                ),
                ThreatAgent(
                        threatAgentType = ThreatAgentType.HUMAN,
                        threatAgent = "Test agent 2",
                        description = "Test agent 2 description",
                        motivation = "Motivation 2",
                        affiliation = "Affiliation 2",
                        source = "Source 2"
                ),
                ThreatAgent(
                        threatAgentType = ThreatAgentType.HUMAN,
                        threatAgent = "Test agent 3",
                        description = "Test agent 3 description",
                        motivation = "Motivation 3",
                        affiliation = "Affiliation 3",
                        source = "Source 3"
                ),
                ThreatAgent(
                        threatAgentType = ThreatAgentType.ENVIRONMENTAL,
                        threatAgent = "Test agent 4",
                        description = "Test agent 4 description",
                        motivation = "Motivation 4",
                        affiliation = "Affiliation 4",
                        source = "Source 4"
                ),
                ThreatAgent(
                        threatAgentType = ThreatAgentType.HUMAN,
                        threatAgent = "Test agent 5",
                        description = "Test agent 5 description",
                        motivation = "Motivation 5",
                        affiliation = "Affiliation 5",
                        source = "Source 5"
                )
        )
    }

    fun createThreatList(threatNumber: Int): List<Threat> {
        return listOf(
                createInjectionThreat(threatNumber),
                createBrokenAuthThreat(threatNumber)
        )
    }

    private fun createBrokenAuthThreat(threatNumber: Int): Threat {
        return Threat(
                threatType = ACCIDENTAL,
                threatName = "Broken Authentication $threatNumber",
                description = "Broken Authentication test threat",
                threatPresence = OwaspThreatPresence(
                        exploitability = ThreatExploitability.AVERAGE,
                        weaknessPrevalence = ThreatWeaknessPrevalence.WIDESPREAD,
                        weaknessDetectability = ThreatWeaknessDetectability.AVERAGE,
                        technicalImpact = ThreatTechnicalImpact.MODERATE,
                        businessImpact = ThreatBusinessImpact.MODERATE
                ),
                target = "web",
                reference = "Test-reference"
        )
    }

    fun createInjectionThreat(threatNumber: Int): Threat {
        return Threat(
                threatType = ACCIDENTAL,
                threatName = "Injection $threatNumber",
                description = "Injection test threat",
                threatPresence = DiscreteThreatPresence(
                        isPresent = true,
                        hasCapacity = true,
                        hasIntention = true,
                        hasHistory = true,
                        isTarget = false
                ),
                target = "web",
                reference = "Test-reference"
        )
    }


}