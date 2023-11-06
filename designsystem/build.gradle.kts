@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.com.android.library)
    alias(libs.plugins.org.jetbrains.kotlin.android)
    alias(libs.plugins.dagger.hilt.android)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.example.designsystem"
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3"
    }
}

dependencies {
    implementation(project(":data"))
    implementation(project(":common-ui-android"))
    api(project(":base-android"))
    libs.apply {
        api(lifecycle.runtime.compose)
        api(ui)
        api(ui.graphics)
        api(ui.tooling.preview)
        api(platform(compose.bom))
        api(material3)
        api(core.ktx)
        api(appcompat)
        api(material)
        ksp(libs.dagger.hilt.compiler)
        api(dagger.hilt.android)
        api(dagger.hilt.navigation)
        debugApi(ui.tooling)
        testApi(junit)
        androidTestApi(androidx.test.ext.junit)
        androidTestApi(espresso.core)
    }
}