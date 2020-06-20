package no.kommune.oslo.model.repository

import no.kommune.oslo.model.RiskScenario

interface RiskScenarioLibraryRepository {
    fun readRiskScenarios(): List<RiskScenario>
    fun writeRiskScenarios(riskScenarios: List<RiskScenario>)
}