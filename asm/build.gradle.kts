plugins {
    kotlin("jvm")
    id("com.ldhdev.asm-ir-plugin") version "1.0.0"
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

group = "vg.h2o"
version = "0.1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.github.monun:kommand-core:3.1.2")
}

tasks {

    jar {

        dependsOn("shadowJar")
        enabled = false

        manifest.attributes(
            mapOf(
                "Premain-Class" to "vg.h2o.asm.PluginAgent"
            )
        )
    }

    shadowJar {
        archiveClassifier.set("")
    }
}