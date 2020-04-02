package no.kommune.oslo.model

data class Asset (val description: String, val assetValues: List<AssetValue>) {
    private val higherBoundary = 3

    init {
        if (assetValues == null) throw IllegalArgumentException("AssetValues can not be null!")
        if (assetValues.size != higherBoundary) throw IllegalArgumentException("AssetValues size has to be ${higherBoundary}!")
    }

    fun getAssestValue(): AssetValue {
        throw NoSuchMethodException("Method not implemented yet!")
    }
}
