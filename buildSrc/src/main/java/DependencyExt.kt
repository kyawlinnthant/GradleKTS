import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.dependent(dependencies : List<String>){
    dependencies.forEach {
        add("classpath",it)
    }
}

fun DependencyHandler.kapt(list: List<String>) {
    list.forEach { dependency ->
        add("kapt", dependency)
    }
}

fun DependencyHandler.annotate(list: List<String>) {
    list.forEach { dependency ->
        add("annotationProcessor", dependency)
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