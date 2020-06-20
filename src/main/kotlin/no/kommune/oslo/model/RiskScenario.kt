package no.kommune.oslo.model

import no.kommune.oslo.model.enums.RiskType

data class RiskScenario(val riskType: RiskType, val scenario: String) {
}