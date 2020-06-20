package no.kommune.oslo.kozmedros.model

import no.kommune.oslo.kozmedros.model.enums.AssetValueTypes
import no.kommune.oslo.kozmedros.model.enums.SeverityLevel

data class AssetValue(val assetValueType: AssetValueTypes, val severityLevel: SeverityLevel)