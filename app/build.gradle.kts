plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")

    //Plugins Id
    id("kotlin-kapt")
    //Plugins Id
}

android {
    namespace = "com.color.tools.database"
    compileSdk = 33


    defaultConfig {
        applicationId = "com.color.tools.database"
        minSdk = 16
        targetSdk = 33
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //Size LIB
    implementation("com.intuit.sdp:sdp-android:1.1.0")
    //Size LIB


    val room_version = "2.5.2"

    implementation("androidx.room:room-runtime:$room_version")
    annotationProcessor("androidx.room:room-compiler:$room_version")

    // To use Kotlin annotation processing tool (kapt)
    kapt("androidx.room:room-compiler:$room_version")
    implementation("androidx.room:room-ktx:$room_version")
//    implementation ("androidx.room:room-rxjava2:$room_version")
//    implementation ("androidx.room:room-rxjava3:$room_version")
//    implementation ("androidx.room:room-guava:$room_version")
    // To use Kotlin Symbol Processing (KSP)

// To use Kotlin Symbolic Processing (KSP)
//    ksp("androidx.room:room-compiler:$room_version")

}