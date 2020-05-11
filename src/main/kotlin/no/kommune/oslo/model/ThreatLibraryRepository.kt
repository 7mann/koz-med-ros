package no.kommune.oslo.model

interface ThreatLibraryRepository {
    fun readThreatAgents(): List<ThreatAgent>
    fun writeThreatAgents(riskScenarios: List<ThreatAgent>)
}