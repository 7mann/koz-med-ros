package no.kommune.oslo.kozmedros.model.repository

import no.kommune.oslo.kozmedros.model.RiskScenario

interface RiskScenarioLibraryRepository {
    fun readRiskScenarios(): List<RiskScenario>
    fun writeRiskScenarios(riskScenarios: List<RiskScenario>)
}