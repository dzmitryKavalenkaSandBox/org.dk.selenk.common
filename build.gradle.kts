group = "org.dk.selenk"
version = "1.0-SNAPSHOT"

plugins {
    kotlin("jvm")
    id("io.qameta.allure") version "2.9.6"
    `maven-publish`
}

repositories {
    mavenLocal()
    mavenCentral()
}

allure {
    aspectjweaver = true
    autoconfigure = true
    useJUnit5 {
        version = "2.14.0"
    }

}

val sourcesJar by tasks.creating(Jar::class) {
    classifier = "sources"
    from(sourceSets["main"].allSource)
}

publishing {
    publications {
        register("mavenKotlin", MavenPublication::class) {
            groupId = group.toString()
            artifactId = rootProject.name
            from(components["kotlin"])
            artifact(sourcesJar)
        }
    }
}

dependencies {
    implementation(kotlin("stdlib", version = "${project.properties["kotlinVersion"]}"))
    testImplementation("io.mockk:mockk:1.12.3")
    testImplementation("org.hamcrest:hamcrest-all:1.3")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.8.2")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.8.2")
//    testImplementation("oio.qameta.allure:allure-junit5:2.14.0")
}

tasks {
    test {
        useJUnitPlatform { }
//        finalizedBy("copyAllureHistoryBefore", "generateAllureReport", "copyAllureHistoryAfter")
    }

//    register<Exec>("generateAllureReport") {
//        commandLine = listOf("allure", "generate", "-c", "build/allure-results")
//    }
//
//    register<Copy>("copyAllureHistoryBefore") {
//        from("allure-report/history")
//        into("tmp/allure-report/history")
//    }
//
//    register<Copy>("copyAllureHistoryAfter") {
//        from("tmp/allure-report/history")
//        into("allure-report/history")
//    }
}
