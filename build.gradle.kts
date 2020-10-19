import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
val compileKotlin: KotlinCompile by tasks

plugins {
    kotlin("jvm") version "1.4.10"
    id("org.jetbrains.kotlin.plugin.serialization") version "1.4.10"
}

group = "no.kommune.oslo"
version = "1.0-SNAPSHOT"
description = "koz-med-ros"


tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

repositories {
    mavenCentral()
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}

val kotlinVersion ="1.4.10"
dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.0.0")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")
    implementation("org.apache.logging.log4j:log4j-api:2.13.2")
    implementation("org.apache.logging.log4j:log4j-core:2.13.2")
    implementation("com.natpryce:konfig:1.6.10.0")
    testImplementation(platform("org.junit:junit-bom:5.7.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.assertj:assertj-core:3.15.0")
    testImplementation(kotlin("test"))
}
