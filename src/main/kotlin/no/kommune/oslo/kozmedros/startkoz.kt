package no.kommune.oslo.kozmedros

import com.natpryce.konfig.*
import com.natpryce.konfig.ConfigurationProperties.Companion.systemProperties

// Hello World Program

fun main(args: Array<String>) {
    println("Hello, World!")

    val env: MutableMap<String, String> = System.getenv()
    val resourcePath = "${env["PWD"]}" + "/resources"
    println("resourcePath: $resourcePath")

    val config: Configuration = loadConfig()

    val risklibrary_threatsfile = Key("risklibrary.threatsfile", stringType)

    val threatsfile = config[risklibrary_threatsfile]

    println("threatsfile: $threatsfile")

}

private fun loadConfig(): Configuration {
    val config = systemProperties() overriding
            EnvironmentVariables() overriding
//            ConfigurationProperties.fromFile(File("$resourcexPath/myservice.properties")) overriding
            ConfigurationProperties.fromResource("defaults.properties")
    return config
}

