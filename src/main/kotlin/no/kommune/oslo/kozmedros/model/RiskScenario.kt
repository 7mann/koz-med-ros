package no.kommune.oslo.kozmedros.model

import kotlinx.serialization.Serializable
import no.kommune.oslo.kozmedros.model.enums.RiskType

@Serializable
data class RiskScenario(val riskType: RiskType, val scenario: String) {
}