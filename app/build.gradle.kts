plugins {
    id("com.android.application")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.playpal"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.playpal.playpal"
        minSdk = 27
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
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.firebase.auth)
    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    implementation(platform("com.google.firebase:firebase-bom:33.10.0"))
    implementation("com.google.firebase:firebase-analytics")

    implementation("com.google.android.material:material:1.12.0")

    // From Firebase documentation https://firebase.google.com/docs/database/android/start?_gl=1*l2mri2*_up*MQ..*_ga*NzI0MzE0MzY3LjE3NDI4MDYzMzQ.*_ga_CW55HF8NVT*MTc0MjgwNjMzNC4xLjAuMTc0MjgwNjMzNC4wLjAuMA..
    // Realtime Database Configuration
    // Import the BoM for the Firebase platform
    implementation(platform("com.google.firebase:firebase-bom:33.11.0"))
    // The dependency for the Realtime Database library
    // When using the BoM, you don't specify versions in Firebase library dependencies
    implementation("com.google.firebase:firebase-database")
    // MapLibre dependency
    implementation("org.maplibre.gl:android-sdk:11.8.0")
    implementation ("com.squareup.okhttp3:okhttp:4.10.0")
}