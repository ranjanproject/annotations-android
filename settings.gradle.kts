pluginManagement {
    plugins {
        id("com.google.devtools.ksp")
        kotlin("jvm") version "1.6.20"
    }
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "AnnotationPracticeApp"
include(":app")
include(":annotation-processors")
include(":annotations")
