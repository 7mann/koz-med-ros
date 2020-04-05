package no.kommune.oslo.model

data class Asset (val description: String, val assetValues: List<AssetValue>) {
    private val higherBoundary = 3

    init {
        if (assetValues.size != higherBoundary) throw IllegalArgumentException("AssetValues size has to be ${higherBoundary}!")
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
