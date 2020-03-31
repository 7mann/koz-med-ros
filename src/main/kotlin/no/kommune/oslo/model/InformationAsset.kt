package no.kommune.oslo.model

import no.kommune.oslo.model.AssetValueTypes.*

data class InformationAsset(val confidencialityValue: Int, val integrityValue: Int, val availabilityValue: Int) {

    fun returnAssetValue(): AssetValue {
        var assetValue: AssetValue = AssetValue(CONFIDENCIALITYVALUE, confidencialityValue)

        if (integrityValue > confidencialityValue) {
            assetValue = AssetValue(INTEGRITYVALUE, integrityValue)
        }
        if (availabilityValue > assetValue.assetValue){
            assetValue = AssetValue(AVAILABILITYVALUE, availabilityValue)
        }
        return assetValue
    }
}