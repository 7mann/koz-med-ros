package no.kommune.oslo.kozmedros.model.repository

import no.kommune.oslo.kozmedros.model.RiskScenario
import org.apache.logging.log4j.LogManager


class FileRiskScenarioLibraryRepository(val path: String, val fileName: String) :
        FileLibraryRepository(), RiskScenarioLibraryRepository {
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
        val riskScenarioList: List<RiskScenario> = readJsonFile<RiskScenario>(fileNameAndPath)
        logger.debug(" ${riskScenarioList.size} RiskScenarios read from file ${fileNameAndPath}")
        return riskScenarioList
    }

    override fun writeRiskScenarios(riskScenarios: List<RiskScenario>) {
        writeJsonFile(riskScenarios, fileNameAndPath)
    }
}