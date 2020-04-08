package no.kommune.oslo.model

import no.kommune.oslo.model.AssetValueTypes.*
import no.kommune.oslo.model.SeverityLevels.*
import no.kommune.oslo.model.ThreatTypes.*

object RiskTestFactory {
    fun createRiskApetite() = RiskApetite(
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
                    DiscreetThreatPresence(isPresent = true,
                            hasCapacity = false,
                            hasIntention = false,
                            hasHistory = true,
                            isTarget = false),
                    "LOW threat 1"
            ),
            Threat(
                    ACCIDENTAL,
                    DiscreetThreatPresence(isPresent = true,
                            hasCapacity = false,
                            hasIntention = true,
                            hasHistory = true,
                            isTarget = false),
                    "MODERATE threat 2"
            ),
            Threat(
                    ENVIRONMENTAL,
                    DiscreetThreatPresence(isPresent = true,
                            hasCapacity = true,
                            hasIntention = true,
                            hasHistory = true,
                            isTarget = false),
                    "HIGH threat 3"
            ),
            Threat(
                    DELIBERATE,
                    DiscreetThreatPresence(isPresent = true,
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
                    DiscreetThreatPresence(isPresent = true,
                            hasCapacity = false,
                            hasIntention = false,
                            hasHistory = true,
                            isTarget = false),
                    "LOW threat 1"
            ),
            Threat(
                    ACCIDENTAL,
                    DiscreetThreatPresence(isPresent = true,
                            hasCapacity = false,
                            hasIntention = true,
                            hasHistory = true,
                            isTarget = false),
                    "MODERATE threat 2"
            ),
            Threat(
                    ENVIRONMENTAL,
                    DiscreetThreatPresence(isPresent = true,
                            hasCapacity = false,
                            hasIntention = false,
                            hasHistory = true,
                            isTarget = false),
                    "LOW threat 3"
            ),
            Threat(
                    DELIBERATE,
                    DiscreetThreatPresence(isPresent = true,
                            hasCapacity = false,
                            hasIntention = true,
                            hasHistory = true,
                            isTarget = false),
                    "MODERATE threat 4"
            ),
            Threat(
                    ACCIDENTAL,
                    DiscreetThreatPresence(isPresent = true,
                            hasCapacity = false,
                            hasIntention = true,
                            hasHistory = true,
                            isTarget = false),
                    "MODERATE threat 5"
            )


    )
}