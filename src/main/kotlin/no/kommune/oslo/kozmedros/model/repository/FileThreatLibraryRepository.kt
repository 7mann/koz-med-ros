package no.kommune.oslo.kozmedros.model.repository

import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass
import no.kommune.oslo.kozmedros.model.*
import org.apache.logging.log4j.LogManager


class FileThreatLibraryRepository(
        val path: String,
        val threatAgentFileName: String,
        val threatFileName: String,
        val vulnerabilityFileName: String
) : FileLibraryRepository(), ThreatLibraryRepository {
    private val logger = LogManager.getLogger(this.javaClass)

    val threatFormat = Json {
        serializersModule = SerializersModule {
            polymorphic(ThreatPresence::class) {
                subclass(OwaspThreatPresence::class)
                subclass(EmptyThreatPresence::class)
                subclass(DiscreteThreatPresence::class)
            }
        };
        prettyPrint = true
    }


    init {
        if (threatAgentFileName.isBlank()) {
            logger.error("ThreatAgent file name must be present!")
            throw IllegalArgumentException("ThreatAgent file name must be present!")
        }
        if (threatFileName.isBlank()) {
            logger.error("Threat file name must be present!")
            throw IllegalArgumentException("Threat file name must be present!")
        }
        if (vulnerabilityFileName.isBlank()) {
            logger.error("Vulnerability filename must be present!")
            throw IllegalArgumentException("Vulnerability filename must be present!")
        }
    }

    override fun readThreatAgents(): List<ThreatAgent> {
        return this.readJsonFile<ThreatAgent>(fileNameAndPath = "$path/$threatAgentFileName")
    }

    override fun writeThreatAgents(threatAgents: List<ThreatAgent>) {
        if (threatAgents.isNullOrEmpty()) {
            throw IllegalArgumentException("ThreatAgent list can not be null or empty!")
        }
        writeJsonFile<ThreatAgent>(threatAgents, fileNameAndPath = "$path/$threatAgentFileName")
    }

    override fun readThreats(): List<Threat> {
        return readJsonFile<Threat>(fileNameAndPath = "$path/$threatFileName", threatFormat)
    }

    override fun writeThreats(threats: List<Threat>) {
        if (threats.isNullOrEmpty()) {
            throw IllegalArgumentException("Threat list can not be null or empty!")
        }
        writeJsonFile<Threat>(threats, "$path/$threatFileName", threatFormat)
    }

    override fun readVulnerabilites(): List<Vulnerability> {
        return this.readJsonFile<Vulnerability>(fileNameAndPath = "$path/$vulnerabilityFileName")
    }

    override fun writeVulnerabilites(vulnerabilities: List<Vulnerability>) {
        if (vulnerabilities.isNullOrEmpty()) {
            throw IllegalArgumentException("Vulnerability list can not be null or empty!")
        }
        writeJsonFile<Vulnerability>(vulnerabilities, fileNameAndPath = "$path/$threatFileName")
    }
}