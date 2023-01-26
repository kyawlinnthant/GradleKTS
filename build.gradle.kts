buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        dependent(AppDependencies.dependency)
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}