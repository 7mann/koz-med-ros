/*
 * This file was generated by the Gradle 'init' task.
 */

plugins {
    java
    `maven-publish`
}

repositories {
    mavenLocal()
    maven {
        url = uri("https://maven.java.net/content/repositories/public/")
    }

    maven {
        url = uri("https://repo1.maven.org/maven2/")
    }

    maven {
        url = uri("https://kotlin.bintray.com/kotlinx")
    }

    maven {
        url = uri("https://repo.maven.apache.org/maven2/")
    }
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.0.0")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.4.10")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.4.10")
    implementation("org.apache.logging.log4j:log4j-api:2.13.1")
    implementation("org.apache.logging.log4j:log4j-core:2.13.1")
    implementation("com.natpryce:konfig:1.6.10.0")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.5.2")
    testImplementation("org.assertj:assertj-core:3.15.0")
    testImplementation("org.jetbrains.kotlin:kotlin-test:1.4.10")
}

group = "no.kommune.oslo"
version = "1.0-SNAPSHOT"
description = "koz-med-ros"
java.sourceCompatibility = JavaVersion.VERSION_1_8

publishing {
    publications.create<MavenPublication>("maven") {
        from(components["java"])
    }
}
