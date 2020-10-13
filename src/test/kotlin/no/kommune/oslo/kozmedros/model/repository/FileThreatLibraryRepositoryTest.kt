@file:Suppress("UnusedImport")

package no.kommune.oslo.kozmedros.model.repository

import no.kommune.oslo.kozmedros.model.*
import no.kommune.oslo.kozmedros.model.enums.*
import org.apache.logging.log4j.LogManager
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.io.File
import kotlin.test.assertFailsWith

internal class FileThreatLibraryRepositoryTest {
    private val logger = LogManager.getLogger(javaClass)
    private val env: MutableMap<String, String> = System.getenv()
    private val testPath = "${env["PWD"]}"
    private val testThreatAgentFileName = "threatLibraryThreatAgentTestFile.json"
    private val testThreatFileName = "threatLibraryThreatTestFile.json"
    private val testVulnerabilityFileName = "threatLibraryVulnerabilityTestFile.json"
    private val owaspThreatFileName = "owasp_top10_threats.json"
    private val owaspVulnerabilitiesFileName = "owasp_top10_vulnerabilities.json"
    private val resourcesPath = "$testPath/src/main/resources"

    @Test
    fun `Expect exeption thrown with illegal parameter`() {
        assertFailsWith<IllegalArgumentException> {
            FileThreatLibraryRepository(path = "", threatAgentFileName = "somefile", threatFileName = "somefile", vulnerabilityFileName = "somefile")
        }
        assertFailsWith<IllegalArgumentException> {
            FileThreatLibraryRepository(path = ".", threatAgentFileName = "", threatFileName = "somefile", vulnerabilityFileName = "somefile")
        }
        assertFailsWith<IllegalArgumentException> {
            FileThreatLibraryRepository(path = ".", threatAgentFileName = "somefile", threatFileName = "", vulnerabilityFileName = "somefile")
        }
        assertFailsWith<IllegalArgumentException> {
            FileThreatLibraryRepository(path = ".", threatAgentFileName = "somefile", threatFileName = "", vulnerabilityFileName = "")
        }
    }

    @Test
    fun `Write, read ThreatAgents to ThreatLibrary and finally delete file`() {
        val threatLibrary = RiskTestFactory.createThreatAgentList()
        val testfile = "$testPath/$testThreatAgentFileName"
        val threatLibraryRepo = FileThreatLibraryRepository(
                path = testPath,
                threatAgentFileName = testThreatAgentFileName,
                threatFileName = testThreatFileName,
                vulnerabilityFileName = testVulnerabilityFileName
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

    @Test
    fun `Write, read Threats to ThreatLibrary and finally delete file`() {
        val threatList = createHighOWASPThreatList()
        val testThreatfile = "$testPath/$testThreatFileName"

        val threatLibraryRepo = FileThreatLibraryRepository(
                path = testPath,
                threatAgentFileName = testThreatAgentFileName,
                threatFileName = testThreatFileName,
                vulnerabilityFileName = testVulnerabilityFileName
        )
        threatLibraryRepo.writeThreats(threatList)
        assertThat(File(testThreatfile).exists()).isTrue()
        val readThreatsfromLibrary = threatLibraryRepo.readThreats()
        assertThat(threatList).containsExactlyElementsOf(readThreatsfromLibrary)
        assertThat(File(testThreatfile).exists()).isTrue()
    }

    @Test
    fun `Test reading OWASP threat from file`() {
        val owaspThreatfile = "$resourcesPath/$owaspThreatFileName"
        val threatLibraryRepo = FileThreatLibraryRepository(
                path = resourcesPath,
                threatAgentFileName = testThreatAgentFileName,
                threatFileName = owaspThreatFileName,
                vulnerabilityFileName = testVulnerabilityFileName
        )

        val readThreatsfromLibrary = threatLibraryRepo.readThreats()
        logger.debug("Number of threats read: ${readThreatsfromLibrary.size}")
        assertThat(readThreatsfromLibrary.size).isEqualTo(10)
    }

    @Test
    fun `Test reading OWASP vulnerabilities from file`() {
//        val owaspThreatfile = "$resourcesPath/$owaspVulnerabilitiesFileName"
        val threatLibraryRepo = FileThreatLibraryRepository(
                path = resourcesPath,
                threatAgentFileName = testThreatAgentFileName,
                threatFileName = owaspThreatFileName,
                vulnerabilityFileName = owaspVulnerabilitiesFileName
        )

//        val readVulnerabilitiesfromLibrary = threatLibraryRepo.readVulnerabilites()
//        logger.debug("Number of vulneerabilities read: ${readVulnerabilitiesfromLibrary.size}")
//        assertThat(readVulnerabilitiesfromLibrary.size).isEqualTo(55)
        val readThreatsfromLibrary = threatLibraryRepo.readThreats()
        val tl = createHighOWASPThreatList()
        logger.debug("Number of threats read: ${readThreatsfromLibrary.size}")
        val threatMap = readThreatsfromLibrary.associateBy({ it.threatName }, { it })
        var updatedVulnerabilities = mutableListOf<Vulnerability>()
//        for( vul in readVulnerabilitiesfromLibrary) {
//            val threat: Threat? = threatMap.get(vul.threatName)
//            val updVul = vul.copy(exploitedByThreat = threat!!)
//            logger.debug(threat)
//            logger.debug(updVul)
//            updatedVulnerabilities.add(updVul)
//        }
        logger.debug("Updated vul list size: ${updatedVulnerabilities.size}")

    }


    private fun createHighOWASPThreatList(): List<Threat> {
        return listOf(Threat(
                threatType = ThreatTypes.DELIBERATE,
                threatName = "Injection",
                description = "Injection flaws, such as SQL, NoSQL, OS, and LDAP injection, occur when untrusted data is sent to an interpreter as part of a command or query. The attacker’s hostile data can trick the interpreter into executing unintended commands or accessing data without proper authorization.",
                threatPresence = createHighOWASPthreatPresence(),
                target = "web",
                reference = "OWASP Top 10 2017"
        ), Threat(
                threatType = ThreatTypes.DELIBERATE,
                threatName = "OWASPThreat2",
                description = "OWASP Threat 2",
                threatPresence = createHighDiscretethreatPresence(),
                target = "Web",
                reference = "OWASP Top 10 2017"
        ))
    }

    private fun createHighOWASPthreatPresence(): OwaspThreatPresence {
        return OwaspThreatPresence(
                exploitability = ThreatExploitability.EASY,
                weaknessPrevalence = ThreatWeaknessPrevalence.COMMON,
                weaknessDetectability = ThreatWeaknessDetectability.EASY,
                technicalImpact = ThreatTechnicalImpact.SEVERE,
                businessImpact = ThreatBusinessImpact.NOT_EVALUATED)
    }

    private fun createHighDiscretethreatPresence(): DiscreteThreatPresence {
        return DiscreteThreatPresence(
                isPresent = true,
                hasCapacity = true,
                hasIntention = true,
                hasHistory = true,
                isTarget = false
        )
    }

}