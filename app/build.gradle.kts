plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
}

@Suppress("UnstableApiUsage") android {
    namespace = "com.example.gradlekts"
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        applicationId = "com.example.gradlekts"
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = AppConfig.androidTestInstrumentation
        vectorDrawables {
            useSupportLibrary = true
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.compose
    }
    packagingOptions {
        resources {
            exclude("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
}

dependencies {
    implement(AppDependencies.app)
    implement(AppDependencies.compose)
    androidTest(AppDependencies.androidTest)
    unitTest(AppDependencies.unitTest)
    debugTest(AppDependencies.debugTest)
}