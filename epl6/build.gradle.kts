plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services")
    id("maven-publish")
}

android {
    namespace = "com.example.epl6"
    compileSdk = 33

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")

        buildConfigField("String", "BASE_URL", "\"http://ext.enkod.ru/\"")
        buildConfigField ("String", "DEV_BASE_URL", "\"http://dev.ext.enkod.ru/\"")
        buildConfigField ("String", "PROD_BASE_URL", "\"http://ext.enkod.ru/\"")
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    android {
        buildFeatures {
            buildConfig = true
        }
    }
}

dependencies {


    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation ("org.jetbrains.kotlin:kotlin-stdlib:1.7.0")
    implementation ("androidx.appcompat:appcompat:1.3.1")
    implementation ("com.google.android.material:material:1.5.0-alpha02")
    implementation ("androidx.constraintlayout:constraintlayout:2.0.4")
    implementation ("com.google.firebase:firebase-messaging-ktx:23.2.1")
    testImplementation ("junit:junit:4.+")
    androidTestImplementation ("androidx.test.ext:junit:1.1.2")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.3.0")

    //firebase implementation

    implementation("com.google.firebase:firebase-messaging-ktx:23.2.1")

    //picasso implementation
    implementation ("com.squareup.picasso:picasso:2.71828")

    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.squareup.okhttp3:okhttp:4.9.0")
    implementation ("com.squareup.okhttp3:logging-interceptor:4.8.0")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.1")
    implementation ("com.google.code.gson:gson:2.8.9")
}

publishing {
    publications {
        register<MavenPublication>("release") {
            groupId = "com.github.AndreyWeather"
            artifactId = "epl6"
            version = "0.0.1"

            afterEvaluate {
                from(components["release"])
            }
        }
    }
}