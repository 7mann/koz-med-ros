package no.kommune.oslo.model

data class Asset (val description: String, val assetValues: List<AssetValue>) {
    private val higherBoundary = 3

    init {
        if (assetValues.size != higherBoundary) throw IllegalArgumentException("AssetValues size has to be ${higherBoundary}!")
    }

    fun getAssestValue(): AssetValue {
        var higestAssetValue = assetValues[0]
        for (assetValue in assetValues) {
            if (assetValue.assetNumberValue > higestAssetValue.assetNumberValue) {
                higestAssetValue = assetValue
            }
        }
        return higestAssetValue
    }
}
