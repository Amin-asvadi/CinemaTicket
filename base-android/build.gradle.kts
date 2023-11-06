@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.com.android.library)
    alias(libs.plugins.org.jetbrains.kotlin.android)
    alias(libs.plugins.dagger.hilt.android)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.example.base_android"
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
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3"
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    api(project(":common-ui-android"))
    libs.apply {
        api(retrofit)
        api(compose.coil)
        api(lifecycle.runtime.compose)
        api(ui)
        api(ui.graphics)
        api(ui.tooling.preview)
        api(platform(compose.bom))
        api(material3)
        api(core.ktx)
        api(appcompat)
        api(material)
        api(ui.system.controller)
        ksp(libs.dagger.hilt.compiler)
        api(dagger.hilt.android)
        api(dagger.hilt.navigation)
        debugApi(ui.tooling)
        testApi(junit)
        androidTestApi(androidx.test.ext.junit)
        androidTestApi(espresso.core)
    }
    implementation(libs.rxjava.compose)
    implementation(libs.compose.animation)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
}