import org.gradle.api.artifacts.dsl.DependencyHandler

object AppDependencies {
    //android ui
    private val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    private val lifecycleKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleKtx}"
    private val material3 = "androidx.compose.material3:material3:${Versions.material3}"
    //compose
    private val composeActivity = "androidx.activity:activity-compose:${Versions.activityCompose}"
    private val composeUi = "androidx.compose.ui:ui:${Versions.compose}"
    private val composeTooling = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
    //test libs
    private val junit = "junit:junit:${Versions.junit}"
    private val extJUnit = "androidx.test.ext:junit:${Versions.extJunit}"
    private val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    private val composeJunit = "androidx.compose.ui:ui-test-junit4:${Versions.compose}"
    private val composeUiTest = "androidx.compose.ui:ui-tooling:${Versions.compose}"
    private val composeManifestTest = "androidx.compose.ui:ui-test-manifest:${Versions.compose}"

    val app = arrayListOf<String>().apply {
        add(coreKtx)
        add(lifecycleKtx)
        add(material3)
    }

    val compose = arrayListOf<String>().apply {
        add(composeActivity)
        add(composeUi)
        add(composeTooling)
    }

    val androidTest = arrayListOf<String>().apply {
        add(extJUnit)
        add(espressoCore)
        add(composeJunit)
    }

    val unitTest = arrayListOf<String>().apply {
        add(junit)
    }

    val debugTest = arrayListOf<String>().apply {
        add(composeUiTest)
        add(composeManifestTest)
    }

}

fun DependencyHandler.kapt(list: List<String>) {
    list.forEach { dependency ->
        add("kapt", dependency)
    }
}

fun DependencyHandler.implement(list: List<String>) {
    list.forEach { dependency ->
        add("implementation", dependency)
    }
}

fun DependencyHandler.androidTest(list: List<String>) {
    list.forEach { dependency ->
        add("androidTestImplementation", dependency)
    }
}

fun DependencyHandler.unitTest(list: List<String>) {
    list.forEach { dependency ->
        add("testImplementation", dependency)
    }
}

fun DependencyHandler.debugTest(list: List<String>) {
    list.forEach { dependency ->
        add("debugImplementation", dependency)
    }
}