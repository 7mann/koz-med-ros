package no.kommune.oslo.kozmedros.model.repository

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import no.kommune.oslo.kozmedros.model.OwaspThreatPresence
import no.kommune.oslo.kozmedros.model.ThreatInterfaceAdapter
import no.kommune.oslo.kozmedros.model.Threat
import no.kommune.oslo.kozmedros.model.ThreatPresence
import org.apache.logging.log4j.LogManager
import java.io.BufferedReader
import java.io.File
import java.lang.reflect.Type

open class FileLibraryRepository {
    private val logger = LogManager.getLogger(javaClass)

    protected inline fun <reified T> readJsonFile(fileNameAndPath: String, classType: Type): List<T> {
        if (!File(fileNameAndPath).exists()) {
            val errorMessage = "File $fileNameAndPath does not exist!"
//            logger.error(errorMessage)
            throw IllegalArgumentException(errorMessage)
        }

        val gson = GsonBuilder().setPrettyPrinting().create()
        val bufferedReader: BufferedReader = File(fileNameAndPath).bufferedReader()
        val inputString = bufferedReader.use { it.readText() }
        val arrayLibraryType = object : TypeToken<List<Threat>>() {}.type
        val libraryList: List<T> = gson.fromJson(inputString, arrayLibraryType)
//        val libraryList: List<T> = gson.fromJson<List<T>>(inputString, classType)
//        this.logger.debug(" ${libraryList.size} Library list read from file ${fileNameAndPath}")
        return libraryList
    }

    protected fun <T> writeJsonFile(libraryList: List<T>, fileNameAndPath: String) {
        if (libraryList.isNullOrEmpty()) {
            val errorMessage = "Library list can not be null or empty!"
            logger.error(errorMessage)
            throw IllegalArgumentException(errorMessage)
        }
        if (fileNameAndPath.isNullOrBlank()) {
            val errorMessage = "Filename argument can not be empty or null!!"
            logger.error(errorMessage)
            throw IllegalArgumentException(errorMessage)
        }

        val gson: Gson = GsonBuilder().registerTypeAdapter(ThreatPresence::class.java, ThreatInterfaceAdapter(OwaspThreatPresence::class.java.name)).setPrettyPrinting().create()
        val jsonString: String = gson.toJson(libraryList)
        logger.debug("Writing ${libraryList.size} records to library ${fileNameAndPath}")
        val file = File(fileNameAndPath)
        file.writeText(jsonString)
    }

}