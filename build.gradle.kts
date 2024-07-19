
plugins {
    id("org.springframework.boot") version "2.7.15"
    id("io.spring.dependency-management") version "1.0.15.RELEASE"
    id("com.google.devtools.ksp") version "1.9.23-1.0.20"
    kotlin("jvm") version "1.9.23"
    kotlin("plugin.spring") version "1.9.23"
}

group = "org.ktorm"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
    mavenLocal()
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(kotlin("reflect"))
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-jdbc")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("mysql:mysql-connector-java:8.0.13")
    implementation("org.ktorm:ktorm-core:4.1.0")
    implementation("org.ktorm:ktorm-jackson:4.1.0")
    implementation("org.ktorm:ktorm-support-mysql:4.1.0")
    implementation("org.ktorm:ktorm-ksp-annotations:4.1.0")
    ksp("org.ktorm:ktorm-ksp-compiler:4.1.0")
}

tasks {
    compileKotlin {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "1.8"
        }
    }
}
