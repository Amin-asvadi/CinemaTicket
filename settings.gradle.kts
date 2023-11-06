pluginManagement {
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

rootProject.name = "CinemaTicket"
include(":app")
include(":ui-main-screen")
include(":base-android")
include(":domain")
include(":data")
include(":data-android")
include(":network")
include(":designsystem")
include(":common-ui-android")
