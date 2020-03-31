package no.kommune.oslo.model

import no.kommune.oslo.model.AssetValueTypes.*
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

internal class InformationAssetTest {

    @Test
    fun returnValue() {
        val iat1 = InformationAsset(4,7,6)
        println("Asset value is ${iat1.returnAssetValue().assetValue} of type ${iat1.returnAssetValue().assetValueType}")
        assertThat(iat1.returnAssetValue().assetValue).isEqualTo(7)
//        assertThat(iat1.returnAssetValue().assetValueType).isEqualTo(AVAILABILITYVALUE)
        assertThat(iat1.returnAssetValue().assetValueType).isEqualTo(INTEGRITYVALUE)
    }
}