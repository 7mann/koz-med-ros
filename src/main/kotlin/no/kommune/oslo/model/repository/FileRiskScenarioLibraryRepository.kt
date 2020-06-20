package no.kommune.oslo.model.repository

import no.kommune.oslo.model.RiskScenario
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
        val riskScenarioList: List<RiskScenario> = this.readJsonFile<RiskScenario>(fileNameAndPath)
        logger.debug(" ${riskScenarioList.size} RiskScenarios read from file ${fileNameAndPath}")
        return riskScenarioList
    }

    override fun writeRiskScenarios(riskScenarios: List<RiskScenario>) {
        this.writeJsonFile(riskScenarios, fileNameAndPath)
    }
}