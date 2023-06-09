import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.8.21"
    application
    id("com.bennyhuo.kotlin.trimindent") version "1.8.0"
}

val jvmTarget = JavaVersion.VERSION_17
println("JVM target = ${jvmTarget} (majorVersion = ${jvmTarget.majorVersion})")

java {
    sourceCompatibility = JavaVersion.VERSION_20
    targetCompatibility = jvmTarget
}

group = "org.steshaw"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = jvmTarget.toString()
}

application {
    mainClass.set("Multiline_stringKt")
}
