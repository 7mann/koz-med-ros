package no.kommune.oslo.model

import no.kommune.oslo.model.enums.SeverityLevel

data class Asset(val description: String, val assetValues: List<AssetValue>) : RiskItem {
    private val higherBoundary = 3

    init {
        if (assetValues.size != higherBoundary) throw IllegalArgumentException("AssetValues size has to be ${higherBoundary}!")
    }

    override fun getSeverityLevel(): SeverityLevel {
        return getAssetValue().severityLevel
    }

    fun getAssetValue(): AssetValue {
        var maxAssetValue: AssetValue = assetValues[0]
        for (assetValue: AssetValue in assetValues) {
            if (assetValue.severityLevel > maxAssetValue.severityLevel) {
                maxAssetValue = assetValue
            }
        }
        return maxAssetValue
    }
}
