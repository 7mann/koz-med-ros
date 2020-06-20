package no.kommune.oslo.model

import no.kommune.oslo.model.enums.AssetValueTypes
import no.kommune.oslo.model.enums.SeverityLevel

data class AssetValue(val assetValueType: AssetValueTypes, val severityLevel: SeverityLevel)