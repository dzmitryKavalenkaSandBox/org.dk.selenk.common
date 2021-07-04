plugins {
    kotlin("jvm")
    id("io.qameta.allure") version "2.8.1"
}

group = "org.dk.selenk.common"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()
}

allure {
    aspectjweaver = true
    autoconfigure = true
    useJUnit5 {
        version = "2.14.0"
    }

}

dependencies {
    implementation(kotlin("stdlib", version = "${project.properties["kotlinVersion"]}"))
    testImplementation("io.mockk:mockk:1.11.0")
    testImplementation("org.hamcrest:hamcrest-all:1.3")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.1.0")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.1.0")
//    testImplementation("oio.qameta.allure:allure-junit5:2.14.0")
}

tasks {
    test {
        useJUnitPlatform { }
        finalizedBy("copyAllureHistoryBefore", "generateAllureReport", "copyAllureHistoryAfter")
    }

    register<Exec>("generateAllureReport") {
        commandLine = listOf("allure", "generate", "-c", "build/allure-results")
    }

    register<Copy>("copyAllureHistoryBefore") {
        from("allure-report/history")
        into("tmp/allure-report/history")
    }

    register<Copy>("copyAllureHistoryAfter") {
        from("tmp/allure-report/history")
        into("allure-report/history")
    }
}
