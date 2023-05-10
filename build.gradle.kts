plugins {
    //trick: for the same plugin versions in all sub-modules
    id("com.android.library").version("8.1.0-alpha11").apply(false)
    kotlin("multiplatform").version("1.8.10").apply(false)
    id("com.jfrog.artifactory").version ("4.29.1").apply(false)
    id("maven-publish")
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

subprojects {
    apply(plugin = "maven-publish")
    apply(plugin = "com.jfrog.artifactory")

    afterEvaluate {
        plugins.withId("com.android.library") {
            publishing {
                publications {
                    register<MavenPublication>("release") {
                        groupId = "com.github.thigott"
                        version = "4.0.0"

                        afterEvaluate {
                            from(components["release"])
                        }
                    }
                }
            }
        }
    }
}
