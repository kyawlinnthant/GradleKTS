plugins {
    id("com.android.application")
    id("com.google.dagger.hilt.android")
    kotlin("android")
    kotlin("kapt")
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
        kotlinCompilerExtensionVersion = Versions.composeCompiler
    }
    packagingOptions {
        resources.excludes.add("/META-INF/{AL2.0,LGPL2.1}")
    }
}

dependencies {
    //App
    this need AppDependencies.app
    //compose
    this need AppDependencies.compose
    //network
    this need AppDependencies.network
    //db
    this need AppDependencies.db
    this kapt AppDependencies.dbKapt
    this annotate AppDependencies.dbAnnotation
    //di
    this need AppDependencies.di
    this kapt AppDependencies.diKapt
    //android test
    this androidTest AppDependencies.androidTest
    //unit test
    this unitTest AppDependencies.unitTest
    //debug test
    this debugTest AppDependencies.debugTest
}