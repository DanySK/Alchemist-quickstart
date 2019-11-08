plugins {
    java
}

repositories { mavenCentral() }

dependencies {
    implementation("it.unibo.alchemist:alchemist:${project.property("alchemistVersion").toString()}")
}

val simulation = project.property("simulation").toString()
tasks.register<JavaExec>("runAlchemist") {
    classpath = project.sourceSets.getByName("main").runtimeClasspath
    main = "it.unibo.alchemist.Alchemist"
    args = listOf("-y", "src/main/yaml/$simulation.yml")
}

defaultTasks("runAlchemist")
