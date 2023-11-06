@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.com.android.library)
    alias(libs.plugins.org.jetbrains.kotlin.android)
    alias(libs.plugins.kotlinx.serialization)
    alias(libs.plugins.dagger.hilt.android)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.example.network"
    compileSdk = 34

    defaultConfig {
        minSdk = 26

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField("String", "SERVER_URL", "\"http://backend.shahnegar.com:8080/api/\"")
        }
        debug {
            buildConfigField("String", "SERVER_URL", "\"http://backend.shahnegar.com:8080/api/\"")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    api(project(":base-android"))
    api(libs.dagger.hilt.android)
    api(libs.dagger.hilt.navigation)
    api(libs.core.ktx)
    api(libs.appcompat)
    api(libs.material)
    api(libs.retrofit)
    api(libs.logging.interceptor)
    api(libs.retrofit.rxjava)
    ksp(libs.dagger.hilt.compiler)
    api(libs.kotlinx.serialization.converter)
    api(libs.kotlinx.serialization.json)
    testApi(libs.junit)
    androidTestApi(libs.androidx.test.ext.junit)
    androidTestApi(libs.espresso.core)
}