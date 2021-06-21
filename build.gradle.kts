plugins {
    kotlin("jvm")
}

group = "org.dk.selenk.common"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib", version = "${project.properties["kotlinVersion"]}"))
    testImplementation("io.mockk:mockk:1.11.0")
    testImplementation("org.hamcrest:hamcrest-all:1.3")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.1.0")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.1.0")
}

tasks {
    test {
        useJUnitPlatform {  }
    }
}
