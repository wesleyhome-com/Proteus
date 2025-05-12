plugins {
    // Apply the Kotlin JVM plugin
    alias(libs.plugins.kotlin.jvm)
    id("com.google.devtools.ksp") version "2.1.20-1.0.31"
    // Apply the java-library plugin for API and implementation separation
    `java-library`
}

repositories {
    mavenCentral()
}

dependencies {
    // KSP API for symbol processing
    implementation(libs.ksp.api)

    // This dependency is used internally, and not exposed to consumers on their own compile classpath
    implementation(libs.kotlinpoet)
    implementation(libs.kotlinpoet.ksp)
}

// Configure KSP
kotlin {
    sourceSets.main {
        kotlin.srcDir("build/generated/ksp/main/kotlin")
    }
    jvmToolchain(17)
}

tasks.test {
    useJUnitPlatform()
}

// Configure JAR task to include processor metadata
tasks.withType<Jar> {
    manifest {
        attributes(
            mapOf(
                "Implementation-Title" to project.name,
                "Implementation-Version" to project.version
            )
        )
    }
}
