package no.kommune.oslo.model

import no.kommune.oslo.methodology.DiscreetThreatPresenceCalculation
import no.kommune.oslo.model.AssetValueTypes.*
import no.kommune.oslo.model.RiskTreatmentStatus.EXISTING
import no.kommune.oslo.model.RiskTreatmentStatus.PLANNED
import no.kommune.oslo.model.RiskTreatmentTypes.PROBABILITY_RISK_TREATMENT
import no.kommune.oslo.model.SeverityLevels.*
import no.kommune.oslo.model.ThreatTypes.*

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

    fun createHighThreatList() = listOf(
            Threat(
                    DELIBERATE,
                    DiscreetThreatPresenceCalculation(isPresent = true,
                            hasCapacity = false,
                            hasIntention = false,
                            hasHistory = true,
                            isTarget = false),
                    "LOW threat 1"
            ),
            Threat(
                    ACCIDENTAL,
                    DiscreetThreatPresenceCalculation(isPresent = true,
                            hasCapacity = false,
                            hasIntention = true,
                            hasHistory = true,
                            isTarget = false),
                    "MODERATE threat 2"
            ),
            Threat(
                    ENVIRONMENTAL,
                    DiscreetThreatPresenceCalculation(isPresent = true,
                            hasCapacity = true,
                            hasIntention = true,
                            hasHistory = true,
                            isTarget = false),
                    "HIGH threat 3"
            ),
            Threat(
                    DELIBERATE,
                    DiscreetThreatPresenceCalculation(isPresent = true,
                            hasCapacity = false,
                            hasIntention = true,
                            hasHistory = true,
                            isTarget = true),
                    "HIGH threat 4"
            )

    )

    fun createModerateThreatList() = listOf(
            Threat(
                    DELIBERATE,
                    DiscreetThreatPresenceCalculation(isPresent = true,
                            hasCapacity = false,
                            hasIntention = false,
                            hasHistory = true,
                            isTarget = false),
                    "LOW threat 1"
            ),
            Threat(
                    ACCIDENTAL,
                    DiscreetThreatPresenceCalculation(isPresent = true,
                            hasCapacity = false,
                            hasIntention = true,
                            hasHistory = true,
                            isTarget = false),
                    "MODERATE threat 2"
            ),
            Threat(
                    ENVIRONMENTAL,
                    DiscreetThreatPresenceCalculation(isPresent = true,
                            hasCapacity = false,
                            hasIntention = false,
                            hasHistory = true,
                            isTarget = false),
                    "LOW threat 3"
            ),
            Threat(
                    DELIBERATE,
                    DiscreetThreatPresenceCalculation(isPresent = true,
                            hasCapacity = false,
                            hasIntention = true,
                            hasHistory = true,
                            isTarget = false),
                    "MODERATE threat 4"
            ),
            Threat(
                    ACCIDENTAL,
                    DiscreetThreatPresenceCalculation(isPresent = true,
                            hasCapacity = false,
                            hasIntention = true,
                            hasHistory = true,
                            isTarget = false),
                    "MODERATE threat 5"
            )


    )

    fun createMixedRiskTreatmentList() = listOf(
            RiskTreatment(
                    description = "Test RiskTreamnent 1",
                    riskTreatmentType = PROBABILITY_RISK_TREATMENT,
                    riskTreatmentStatus = PLANNED,
                    riskTreatmentImpact = LOW
            ),
            RiskTreatment(
                    description = "Test RiskTreamnent 2",
                    riskTreatmentType = PROBABILITY_RISK_TREATMENT,
                    riskTreatmentStatus = EXISTING,
                    riskTreatmentImpact = LOW
            ),
            RiskTreatment(
                    description = "Test RiskTreamnent 3",
                    riskTreatmentType = PROBABILITY_RISK_TREATMENT,
                    riskTreatmentStatus = PLANNED,
                    riskTreatmentImpact = MODERATE
            )

    )
}