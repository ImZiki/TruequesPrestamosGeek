import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("jvm")
    id("org.jetbrains.compose")
    id("org.jetbrains.kotlin.plugin.compose")
    id("org.jetbrains.dokka") version "2.0.0"
}

group = "com.danirodriguez.truequesprestamosgeek"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    google()
}

dependencies {
    implementation("io.insert-koin:koin-core:3.5.0")
    implementation("com.h2database:h2:2.3.232")
    implementation("org.jetbrains.exposed:exposed-core:0.44.0")
    implementation ("org.slf4j:slf4j-api:2.0.0")
    implementation ("ch.qos.logback:logback-classic:1.4.12")
    implementation("org.mindrot:jbcrypt:0.4")
    implementation("org.jetbrains.exposed:exposed-dao:0.44.0")
    implementation("org.jetbrains.exposed:exposed-jdbc:0.44.0")
    implementation(compose.desktop.currentOs)
}

compose.desktop {
    application {
        mainClass = "MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "TruequesPrestamosGeek"
            packageVersion = "1.0.0"
        }
    }
}
