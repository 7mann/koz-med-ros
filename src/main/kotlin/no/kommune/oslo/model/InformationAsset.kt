package no.kommune.oslo.model

import no.kommune.oslo.model.AssetValueTypes.*

data class InformationAsset(val confidencialityValue: Int, val integrityValue: Int, val availabilityValue: Int) {

    fun returnAssetValue(): AssetValue {
        var assetValue = AssetValue(CONFIDENCIALITYVALUE, confidencialityValue)

        if (integrityValue > confidencialityValue) {
            assetValue = AssetValue(INTEGRITYVALUE, integrityValue)
        }
        if (availabilityValue > assetValue.assetNumberValue){
            assetValue = AssetValue(AVAILABILITYVALUE, availabilityValue)
        }
        return assetValue
    }
}