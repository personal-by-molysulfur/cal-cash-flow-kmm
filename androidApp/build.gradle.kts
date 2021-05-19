plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    kotlin("android.extensions")
}

dependencies {
    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.3.0")
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    implementation("com.google.dagger:hilt-android:2.35.1")
    kapt("com.google.dagger:hilt-compiler:2.35.1")
    // For instrumentation tests
    androidTestImplementation("com.google.dagger:hilt-android-testing:2.35.1")
    kaptAndroidTest("com.google.dagger:hilt-compiler:2.35.1")
    // For local unit tests
    testImplementation("com.google.dagger:hilt-android-testing:2.35.1")
    kaptTest("com.google.dagger:hilt-compiler:2.35.1")
}

android {
    compileSdkVersion(30)
    defaultConfig {
        applicationId = "com.molysulfur.app.calcashflow.android"
        minSdkVersion(21)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}

kapt {
    correctErrorTypes = true
}