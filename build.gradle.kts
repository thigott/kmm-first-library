plugins {
    //trick: for the same plugin versions in all sub-modules
    id("com.android.library").version("8.1.0-alpha11").apply(false)
    kotlin("multiplatform").version("1.8.10").apply(false)
    id("maven-publish")
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

subprojects {
    apply(plugin = "maven-publish")

    publishing {
        publications {
            register<MavenPublication>("release") {
                groupId = project.group.toString()
                artifactId = project.name
                version = project.version.toString()

                afterEvaluate {
                    from(components["kotlin"])
                }
            }
        }
    }
}
