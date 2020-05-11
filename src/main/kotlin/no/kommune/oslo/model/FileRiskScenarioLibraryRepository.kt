package no.kommune.oslo.model

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import org.apache.logging.log4j.LogManager
import java.io.BufferedReader
import java.io.File


class FileRiskScenarioLibraryRepository(val path: String, val fileName: String) : RiskScenarioLibraryRepository {
    private val logger = LogManager.getLogger(javaClass)
    private val fileNameAndPath: String

    init {
        if (path.isBlank()) {
            throw IllegalArgumentException("Path must be present!")
        }
        if (fileName.isBlank()) {
            throw IllegalArgumentException("File name must be present!")
        }
        fileNameAndPath = "$path/$fileName"
    }

    override fun readRiskScenarios(): List<RiskScenario> {
        if (!File(fileNameAndPath).exists()) {
            val errorMessage = "File ${fileNameAndPath} does not exist!"
            logger.error(errorMessage)
            throw IllegalArgumentException(errorMessage)
        }

        val gson = GsonBuilder().setPrettyPrinting().create()
        val bufferedReader: BufferedReader = File(fileNameAndPath).bufferedReader()
        val inputString = bufferedReader.use { it.readText() }
        val arrayRiskScenarioType = object : TypeToken<List<RiskScenario>>() {}.type
        val riskScenarioList: List<RiskScenario> = gson.fromJson(inputString, arrayRiskScenarioType)
        logger.debug(" ${riskScenarioList.size} RiskScenarios read from file ${fileNameAndPath}")
        return riskScenarioList
    }

    override fun writeRiskScenarios(riskScenarios: List<RiskScenario>) {
        if (riskScenarios.isNullOrEmpty()) {
            throw IllegalArgumentException("RiskScenarioList can not be null or empty!")
        }
        val gson: Gson = GsonBuilder().setPrettyPrinting().create()
        val jsonString: String = gson.toJson(riskScenarios)
        val file = File(fileNameAndPath)
        file.writeText(jsonString)
    }
}