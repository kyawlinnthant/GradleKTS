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
        resources {
            exclude("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
}

dependencies {
    //App
    implement(AppDependencies.app)
    //compose
    implement(AppDependencies.compose)
    //network
    implement(AppDependencies.network)
    //db
    implement(AppDependencies.db)
    kapt(AppDependencies.dbKapt)
    annotate(AppDependencies.dbAnnotation)
    //di
    implement(AppDependencies.di)
    kapt(AppDependencies.diKapt)
    //android test
    androidTest(AppDependencies.androidTest)
    //unit test
    unitTest(AppDependencies.unitTest)
    //debug test
    debugTest(AppDependencies.debugTest)
}