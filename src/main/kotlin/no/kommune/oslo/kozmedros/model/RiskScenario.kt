package no.kommune.oslo.kozmedros.model

import no.kommune.oslo.kozmedros.model.enums.RiskType

data class RiskScenario(val riskType: RiskType, val scenario: String) {
}