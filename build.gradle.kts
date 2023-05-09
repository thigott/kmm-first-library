plugins {
    //trick: for the same plugin versions in all sub-modules
    id("com.android.library").version("8.1.0-alpha11").apply(false)
    kotlin("multiplatform").version("1.8.10").apply(false)
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
