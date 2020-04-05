package no.kommune.oslo.model

import no.kommune.oslo.model.AssetValueTypes.*

data class InformationAsset(val confidencialityValue: SeverityLevels, val integrityValue: SeverityLevels, val availabilityValue: SeverityLevels) {

    fun returnAssetValue(): AssetValue {
        var assetValue = AssetValue(CONFIDENCIALITYVALUE, confidencialityValue)

        if (integrityValue > confidencialityValue) {
            assetValue = AssetValue(INTEGRITYVALUE, integrityValue)
        }
        if (availabilityValue > assetValue.severityLevel){
            assetValue = AssetValue(AVAILABILITYVALUE, availabilityValue)
        }
        return assetValue
    }
}