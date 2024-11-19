import com.vanniktech.maven.publish.SonatypeHost
import com.vanniktech.maven.publish.JavaLibrary
import com.vanniktech.maven.publish.JavadocJar
/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Java library project to get you started.
 * For more details on building Java & JVM projects, please refer to https://docs.gradle.org/8.10.2/userguide/building_java_projects.html in the Gradle documentation.
 */

version = "0.0.2"
group = "run.resonance"

plugins {
    // Apply the java-library plugin for API and implementation separation.
    `java-library`
    signing
    id("com.vanniktech.maven.publish") version "0.30.0"
    application
}

application {
    mainClass.set("run.resonance.ResonanceClient")
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    // Use JUnit test framework.
    testImplementation(libs.junit)
    testImplementation("com.squareup.okhttp3:mockwebserver:4.12.0")

    // This dependency is used internally, and not exposed to consumers on their own compile classpath.
    implementation(libs.guava)
    implementation("com.google.code.gson:gson:2.11.0")
    implementation("com.squareup.okhttp3:okhttp:4.12.0")
}

// Apply a specific Java toolchain to ease working on different environments.
java {
    withSourcesJar()
}

mavenPublishing {
    coordinates("run.resonance", "ResonanceClient", "0.0.2")

    pom {
        name.set("Resonance Amplifier Java SDK")
        description.set("Consume Resonance customizations in your Java apps")
        inceptionYear.set("2024")
        url.set("https://github.com/resonance-run/resonance-java-sdk")
        licenses {
            license {
                name.set("MIT")
            }
        }
        developers {
            developer {
                name.set("Steven Foote")
                email.set("steven@resonance.run")
            }
        }
        scm {
            connection.set("scm:git:git://github.com/resonance-run/resonance-java-sdk.git")
            developerConnection.set("scm:git:ssh://github.com/resonance-run/resonance-java-sdk.git")
            url.set("https://github.com/resonance-run/resonance-java-sdk")
        }
    }

}
