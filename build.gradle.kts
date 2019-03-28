import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.21"
    id("io.quarkus.gradle.plugin") version "0.12.0"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.3.21"
}

repositories {
    jcenter()
    maven("http://repository.jboss.org/nexus/content/groups/public")
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.jetbrains.intellij.deps:trove4j:1.0.20181211")
    implementation("org.jetbrains.kotlin:kotlin-script-runtime:1.3.21")

    compileOnly("io.quarkus:quarkus-kotlin:0.12.0")
    compileOnly("io.quarkus:quarkus-resteasy:0.12.0")
    compileOnly("io.quarkus:quarkus-resteasy-jsonb:0.12.0")

    compileOnly("com.oracle.substratevm:svm:1.0.0-rc12") {
        exclude("*", "*")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.withType<Wrapper> {
    gradleVersion = "5.3.1"
}

allOpen {
    annotation("javax.ws.rs.Path")
}

quarkus {
    setSourceDir("src/main/kotlin")
    setOutputDirectory("build/classes/kotlin/main")
}
