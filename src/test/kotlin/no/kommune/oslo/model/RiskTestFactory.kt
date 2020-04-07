package no.kommune.oslo.model

import no.kommune.oslo.model.AssetValueTypes.*
import no.kommune.oslo.model.SeverityLevels.*
import no.kommune.oslo.model.ThreatTypes.*

object RiskTestFactory {
    //    fun create
    fun createRiskApetite(): RiskApetite {
        val riskApetite = RiskApetite(
                arrayOf(
                        arrayOf(LOW, LOW, LOW, LOW, MODERATE),
                        arrayOf(LOW, LOW, LOW, MODERATE, MODERATE),
                        arrayOf(MODERATE, MODERATE, MODERATE, MODERATE, HIGH),
                        arrayOf(MODERATE, MODERATE, HIGH, HIGH, HIGH),
                        arrayOf(MODERATE, HIGH, HIGH, HIGH, HIGH)
                )
        )
        return riskApetite
    }

    fun createModerateAssetList(): List<Asset> {
        val assetList = listOf<Asset>(
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
        return assetList
    }

    fun createLowAssetList(): List<Asset> {
        val assetList = listOf<Asset>(
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
        return assetList
    }

    fun createHighAssetList(): List<Asset> {
        val assetList = listOf<Asset>(
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
        return assetList
    }

    fun createHighThreatList(): List<Threat> {
        val threatList = listOf<Threat>(
                Threat(
                        DELIBERATE,
                        DiscreetThreatPresence(isPresent = true, hasCapacity = false, hasIntention = true, hasHistory = true, isTarget = false),
                        "Test threat"
                ),
                Threat(
                        ACCIDENTAL,
                        DiscreetThreatPresence(isPresent = true, hasCapacity = false, hasIntention = true, hasHistory = true, isTarget = false),
                        "Test threat"
                ),
                Threat(
                        ENVIRONMENTAL,
                        DiscreetThreatPresence(isPresent = true, hasCapacity = false, hasIntention = true, hasHistory = true, isTarget = false),
                        "Test threat"
                ),
                Threat(
                        DELIBERATE  ,
                        DiscreetThreatPresence(isPresent = true, hasCapacity = false, hasIntention = true, hasHistory = true, isTarget = false),
                        "Test threat"
                )

        )
        return threatList
    }
}