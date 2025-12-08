plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.seguro.full.peso.efectivo.myapplication"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.seguro.full.peso.efectivo.myapplication"
        minSdk = 25
        targetSdk = 36
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
            // 关键：Release 版本完全关闭 Lint 检测（AGP 8.x 兼容语法）
            lint {
                checkReleaseBuilds = false // 核心开关：关闭 Release 版本的 Lint 检查
                abortOnError = false // 即使有配置错误也不终止打包
                checkDependencies = false // 不检查依赖的 Lint 问题
            }
        }
    }

    // 全局禁用 Lint 相关问题检测器
    lint {
        abortOnError = false
        checkDependencies = false
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}