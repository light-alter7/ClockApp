# ClockApp Build Instructions

## Overview
This document provides instructions for building the ClockApp Android application into APK files.

## Requirements
- **JDK 17** or higher
- **Android SDK** (API level 34)
- **Gradle** (wrapper included)
- Minimum 2GB free disk space

## Project Details
- **Minimum SDK**: API 26 (Android 8.0)
- **Target SDK**: API 34 (Android 14)
- **Language**: Kotlin 1.9.24
- **Build System**: Gradle with Kotlin DSL

## Local Build

### Step 1: Clone Repository
```bash
git clone https://github.com/light-alter7/ClockApp.git
cd ClockApp
```

### Step 2: Build Debug APK
```bash
./gradlew assembleDebug
```

Output: `app/build/outputs/apk/debug/app-debug.apk`

### Step 3: Build Release APK
```bash
./gradlew assembleRelease
```

Output: `app/build/outputs/apk/release/app-release.apk`

## Installing APK

### On Connected Device/Emulator
```bash
adb install -r app/build/outputs/apk/debug/app-debug.apk
```

### View Logs
```bash
adb logcat
```

## Automated CI/CD Build
GitHub Actions workflow automatically builds APK on:
- Push to `main` or `develop` branches
- Pull requests to `main` or `develop`
- Manual trigger via `workflow_dispatch`

Built APKs are available as artifacts in workflow runs.

## Troubleshooting

### Build Fails: "ANDROID_SDK_ROOT not set"
Set environment variable:
```bash
export ANDROID_SDK_ROOT=~/Android/Sdk
```

### Gradle Wrapper Permission Denied
```bash
chmod +x gradlew
```

### Out of Memory During Build
Add to `gradle.properties`:
```properties
org.gradle.jvmargs=-Xmx4096m
```

## Dependencies
- AndroidX Core, Lifecycle, Activity
- Jetpack Compose (UI Framework)
- Room Database
- WorkManager (Alarm Scheduling)
- Material Design 3

## Permissions Required
- SCHEDULE_EXACT_ALARM
- USE_EXACT_ALARM
- POST_NOTIFICATIONS
- VIBRATE
- WAKE_LOCK
- RECEIVE_BOOT_COMPLETED
- REQUEST_IGNORE_BATTERY_OPTIMIZATIONS
- CAMERA
