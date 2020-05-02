package no.kommune.oslo.model

interface RiskScenarioLibraryRepository {
    fun readRiskScenarios(): List<RiskScenario>
    fun writeRiskScenarios(riskScenarios: List<RiskScenario>)
}