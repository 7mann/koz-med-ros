package no.kommune.oslo.model

import no.kommune.oslo.model.AssetValueTypes.*
import no.kommune.oslo.model.SeverityLevels.*
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

internal class InformationAssetTest {

    @Test
    fun returnValue() {
        val iat1 = InformationAsset(HIGH, LOW, MODERATE)
        println("Asset value is ${iat1.returnAssetValue().severityLevel} of type ${iat1.returnAssetValue().assetValueType}")
        assertThat(iat1.returnAssetValue().severityLevel).isEqualTo(HIGH)
        assertThat(iat1.returnAssetValue().assetValueType).isEqualTo(CONFIDENCIALITYVALUE)
    }
}