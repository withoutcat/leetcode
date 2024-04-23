plugins {
    kotlin("jvm") version "1.8.0"
    id("java")
    application
}

// 设置 JVM 版本为 JDK 17
java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
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