package no.kommune.oslo.kozmedros.model.repository

import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import no.kommune.oslo.kozmedros.model.*
import org.apache.logging.log4j.LogManager
import java.io.BufferedReader
import java.io.File


class FileThreatLibraryRepository(
        val path: String,
        val threatAgentFileName: String,
        val threatFileName: String,
        val vulnerabilityFileName: String
) : FileLibraryRepository(), ThreatLibraryRepository {
    private val logger = LogManager.getLogger(this.javaClass)

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
        if (vulnerabilityFileName.isBlank()) {
            logger.error("Vulnerability filename must be present!")
            throw IllegalArgumentException("Vulnerability filename must be present!")
        }
    }

    override fun readThreatAgents(): List<ThreatAgent> {
        val type = object : TypeToken<List<ThreatAgent>>() {}.type
        return this.readJsonFile<ThreatAgent>(fileNameAndPath = "$path/$threatAgentFileName", classType = type)
    }

    override fun writeThreatAgents(threatAgents: List<ThreatAgent>) {
        if (threatAgents.isNullOrEmpty()) {
            throw IllegalArgumentException("ThreatAgent list can not be null or empty!")
        }
        this.writeJsonFile<ThreatAgent>(threatAgents, fileNameAndPath = "$path/$threatAgentFileName")
    }

    override fun readThreats(): List<Threat> {
//        val type =  object : TypeToken<Threat>() {}.type
        val threatList = readThreatsfromFile(fileNameAndPath = "$path/$threatFileName")
        return threatList
//        return this.readJsonFile<Threat>(fileNameAndPath = "$path/$threatFileName", classType = type)
    }

    override fun writeThreats(threats: List<Threat>) {
        if (threats.isNullOrEmpty()) {
            throw IllegalArgumentException("Threat list can not be null or empty!")
        }
        this.writeJsonFile<Threat>(threats, "$path/$threatFileName")
    }

    override fun readVulnerabilites(): List<Vulnerability> {
        val type = object : TypeToken<List<Vulnerability>>() {}.type
        return this.readJsonFile<Vulnerability>(fileNameAndPath = "$path/$vulnerabilityFileName", classType = type)
    }

    override fun writeulnerabilites(vulnerabilities: List<Vulnerability>) {
        if (vulnerabilities.isNullOrEmpty()) {
            throw IllegalArgumentException("Vulnerability list can not be null or empty!")
        }
        this.writeJsonFile<Vulnerability>(vulnerabilities, fileNameAndPath = "$path/$threatFileName")
    }

    private fun readThreatsfromFileRune(fileNameAndPath: String): List<Threat> {
        if (!File(fileNameAndPath).exists()) {
            val errorMessage = "File $fileNameAndPath does not exist!"
            logger.error(errorMessage)
            throw IllegalArgumentException(errorMessage)
        }

//        val gsonBuilder = GsonBuilder().setPrettyPrinting().registerTypeAdapter(
//                ThreatPresence::class.java,
//                RiskItemInterfaceAdapter
//        ).create()

//        var gson : Gson? = null
        var gBuilder = GsonBuilder()
//        gBuilder.registerTypeAdapter(OwaspThreatPresence::class.java, RiskItemInterfaceAdapter())
//        gBuilder.registerTypeAdapter(ThreatPresence::class.java, RiskItemInterfaceAdapter())
        gBuilder.registerTypeAdapter(Threat::class.java, ThreatInterfaceAdapter(OwaspThreatPresence::class.java.name))
        var gson = gBuilder.create()

//        gsonBuilder.registerTypeAdapter
        val bufferedReader: BufferedReader = File(fileNameAndPath).bufferedReader()
        val inputString = bufferedReader.use { it.readText() }
        val arrayLibraryType = object : TypeToken<List<Threat>>() {}.type
//        val libraryList: List<Threat> = gsonBuilder.fromJson(inputString, arrayLibraryType)
        val libraryList: List<Threat> = gson.fromJson(inputString, arrayLibraryType)
        this.logger.debug(" ${libraryList.size} Library list read from file ${fileNameAndPath}")
        return libraryList

    }


    private fun readThreatsfromFile(fileNameAndPath: String): List<Threat> {
        if (!File(fileNameAndPath).exists()) {
            val errorMessage = "File $fileNameAndPath does not exist!"
            logger.error(errorMessage)
            throw IllegalArgumentException(errorMessage)
        }
        val bufferedReader: BufferedReader = File(fileNameAndPath).bufferedReader()
        val inputString = bufferedReader.use { it.readText() }

        var gson = GsonBuilder().registerTypeAdapter(ThreatPresence::class.java, ThreatInterfaceAdapter(OwaspThreatPresence::class.java.name)).create()

        val arrayLibraryType = object : TypeToken<List<Threat>>() {}.type
        val libraryList: List<Threat> = gson.fromJson(inputString, arrayLibraryType)
        this.logger.debug(" ${libraryList.size} Library list read from file ${fileNameAndPath}")
        return libraryList
    }
}