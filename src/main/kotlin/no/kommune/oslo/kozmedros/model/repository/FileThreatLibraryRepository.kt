package no.kommune.oslo.kozmedros.model.repository

import no.kommune.oslo.kozmedros.model.Threat
import no.kommune.oslo.kozmedros.model.ThreatAgent
import org.apache.logging.log4j.LogManager

class FileThreatLibraryRepository(val path: String, val threatAgentFileName: String, val threatFileName: String) : FileLibraryRepository(), ThreatLibraryRepository {
    private val logger = LogManager.getLogger(this.javaClass)
    private val threatAgentFileNameAndPath: String
    private val threatFileNameAndPath: String

    init {
        if (path.isBlank()) {
            logger.error("Path must be present!")
            throw IllegalArgumentException("Path must be present!")
        }
        if (threatAgentFileName.isBlank()) {
            logger.error("ThreatAgent file name must be present!")
            throw IllegalArgumentException("ThreatAgent file name must be present!")
        }
        if (threatFileName.isBlank()) {
            logger.error("Threat file name must be present!")
            throw IllegalArgumentException("Threat file name must be present!")
        }
        this.threatAgentFileNameAndPath = "$path/$threatAgentFileName"
        this.threatFileNameAndPath = "$path/$threatFileName"
    }

    override fun readThreatAgents(): List<ThreatAgent> {
        return this.readJsonFile<ThreatAgent>(this.threatAgentFileNameAndPath)
    }

    override fun writeThreatAgents(threatAgents: List<ThreatAgent>) {
        if (threatAgents.isNullOrEmpty()) {
            throw IllegalArgumentException("ThreatAgent list can not be null or empty!")
        }
        this.writeJsonFile<ThreatAgent>(threatAgents, threatAgentFileNameAndPath)
    }

    override fun readThreat(): List<Threat> {
        TODO("Not yet implemented")
    }

    override fun writeThreat(threats: List<Threat>) {
        TODO("Not yet implemented")
    }
}