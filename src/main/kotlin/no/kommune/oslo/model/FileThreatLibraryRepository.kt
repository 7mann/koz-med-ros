package no.kommune.oslo.model

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import org.apache.logging.log4j.LogManager
import java.io.BufferedReader
import java.io.File

class FileThreatLibraryRepository(val path: String, val fileName: String) : ThreatLibraryRepository {
    private val logger = LogManager.getLogger(javaClass)
    private val fileNameAndPath: String

    init {
        if (path.isBlank()) {
            throw IllegalArgumentException("Path must be present!")
        }
        if (fileName.isBlank()) {
            throw IllegalArgumentException("File name must be present!")
        }
        this.fileNameAndPath = "$path/$fileName"
    }

    override fun readThreatAgents(): List<ThreatAgent> {
        if (!File(this.fileNameAndPath).exists()) {
            val errorMessage = "File $fileNameAndPath does not exist!"
            logger.error(errorMessage)
            throw IllegalArgumentException(errorMessage)
        }

        val gson = GsonBuilder().setPrettyPrinting().create()
        val bufferedReader: BufferedReader = File(fileNameAndPath).bufferedReader()
        val inputString = bufferedReader.use { it.readText() }
        val arrayThreatAgentType = object : TypeToken<List<ThreatAgent>>() {}.type
        val threatAgentList: List<ThreatAgent> = gson.fromJson(inputString, arrayThreatAgentType)
        logger.debug(" ${threatAgentList.size} ThreatAgents read from file $fileNameAndPath")
        return threatAgentList
    }

    override fun writeThreatAgents(threatAgents: List<ThreatAgent>) {
        if (threatAgents.isNullOrEmpty()) {
            throw IllegalArgumentException("ThreatAgent list can not be null or empty!")
        }
        val gson: Gson = GsonBuilder().setPrettyPrinting().create()
        val jsonString: String = gson.toJson(threatAgents)
        val file = File(fileNameAndPath)
        file.writeText(jsonString)
    }
}