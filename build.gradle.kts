plugins {
    kotlin("jvm") version "1.8.0"
    id("java")
    application
}

//tasks.withType<JavaCompile> {
//    javaCompiler.set(javaToolchains.compilerFor {
//        languageVersion.set(JavaLanguageVersion.of(17))
//    })
//}
//
//tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
//    kotlinOptions {
//        jvmTarget = "17"
//    }
//}

group = "com.sunziwen"
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

kotlin {
    jvmToolchain(8)
}

application {
    mainClass.set("MainKt")
}