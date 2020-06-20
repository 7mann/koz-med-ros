@file:Suppress("UnusedImport")

package no.kommune.oslo.kozmedros.model.repository

import no.kommune.oslo.kozmedros.model.RiskTestFactory

import org.apache.logging.log4j.LogManager
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.io.File
import kotlin.test.assertFailsWith

internal class FileThreatLibraryRepositoryTest {
    private val logger = LogManager.getLogger(javaClass)
    private val env: MutableMap<String, String> = System.getenv()
    private val testPath = "${env["PWD"]}"
    private val testThreatAgentFileName = "threatLibraryTestFile.json"
    private val testThreatFileName = "NO_FILE" //ToDo: Implement tests for threats

    @Test
    fun `Expect exeption thrown with illegal parameter`() {
        assertFailsWith<IllegalArgumentException> {
            FileThreatLibraryRepository(path = "", threatAgentFileName = "somefile", threatFileName = "somefile")
        }
        assertFailsWith<IllegalArgumentException> {
            FileThreatLibraryRepository(path = ".", threatAgentFileName = "", threatFileName = "somefile")
        }
        assertFailsWith<IllegalArgumentException> {
            FileThreatLibraryRepository(path = ".", threatAgentFileName = "somefile", threatFileName = "")
        }
    }

    @Test
    fun `Write, read ThreatLibrary and finally delete file`() {
        val threatLibrary = RiskTestFactory.createThreatAgentList()
        val testfile = "$testPath/$testThreatAgentFileName"
        val threatLibraryRepo = FileThreatLibraryRepository(
                path = testPath,
                threatAgentFileName = testThreatAgentFileName,
                threatFileName = testThreatFileName
        )
        threatLibraryRepo.writeThreatAgents(threatLibrary)
        assertThat(File(testfile).exists()).isTrue()
        val readThreatLibrary = threatLibraryRepo.readThreatAgents()
        assertThat(threatLibrary.size).isEqualTo(readThreatLibrary.size)

        assertThat(File(testfile).exists()).isTrue()

        if (!File(testfile).exists()) return
        logger.debug("Removing $testfile")
        File(testfile).delete()
    }

}