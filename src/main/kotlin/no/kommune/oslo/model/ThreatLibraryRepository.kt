package no.kommune.oslo.model

interface ThreatLibraryRepository {
    fun readThreatAgents(): List<ThreatAgent>
    fun writeThreatAgents(threatAgents: List<ThreatAgent>)
}