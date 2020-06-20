package no.kommune.oslo.kozmedros.model.repository

import no.kommune.oslo.kozmedros.model.Threat
import no.kommune.oslo.kozmedros.model.ThreatAgent

interface ThreatLibraryRepository {
    fun readThreatAgents(): List<ThreatAgent>
    fun writeThreatAgents(threatAgents: List<ThreatAgent>)
    fun readThreat(): List<Threat>
    fun writeThreat(threats: List<Threat>)
}