import io.gitlab.arturbosch.detekt.Detekt

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.arturbosch.detekt)
    alias(libs.plugins.google.ksp)
    alias(libs.plugins.hilt.android)
}

android {
    namespace = "com.materna.storyviewer"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.materna.storyviewer"
        minSdk = 29
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }

    lint {
        lintConfig = file("$rootDir/config/lint.xml")
        htmlReport = true
        htmlOutput = layout.buildDirectory.file("reports/lint/lint.html").get().asFile

        ignoreTestSources = true
        abortOnError = false
    }
}

detekt {
    toolVersion = "1.23.8"
    config.setFrom(file("$rootDir/config/detekt.yml"))
    buildUponDefaultConfig = false
    autoCorrect = false
}

tasks.withType<Detekt>().configureEach {
    reports {
        html.required.set(true)
    }
}

tasks.named("lint") {
    outputs.upToDateWhen { false }
}

tasks.named("detekt") {
    dependsOn("lint")
    finalizedBy("printReports")
}

tasks.register("printReports") {
    doLast {
        val lintReport = layout.buildDirectory.file("reports/lint/lint.html").get().asFile
        val detektReport = layout.buildDirectory.file("reports/detekt/detekt.html").get().asFile

        println("Lint Report: file://${lintReport.absolutePath}")
        println("Detekt Report: file://${detektReport.absolutePath}")
    }
}

dependencies {
    detektPlugins(libs.detekt.formatting)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.navigation.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    debugImplementation(libs.androidx.ui.tooling)
    implementation(libs.androidx.material3)

    implementation(libs.androidx.core.splashscreen)

    implementation(libs.kotlinx.serialization.core)
    implementation(libs.kotlinx.serialization.json)

    implementation(libs.hilt.android)
    implementation(libs.androidx.hilt.navigation.compose)
    ksp(libs.hilt.compiler)
}