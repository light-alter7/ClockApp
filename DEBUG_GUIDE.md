# ClockApp Debug & Build Guide

## Quick Start

### Prerequisites
- JDK 17+
- Android SDK (API 34)
- 2GB+ free disk space

### Build Steps

#### 1. Debug APK
```bash
./gradlew assembleDebug
```
**Output:** `app/build/outputs/apk/debug/app-debug.apk`

#### 2. Release APK
```bash
./gradlew assembleRelease
```
**Output:** `app/build/outputs/apk/release/app-release.apk`

#### 3. Run on Device
```bash
adb install -r app/build/outputs/apk/debug/app-debug.apk
```

## Debugging

### View Logs
```bash
adb logcat
```

### Debug in Android Studio
1. Open project in Android Studio
2. Connect device/emulator
3. Go to Run > Debug 'app'

## Project Info

| Property | Value |
|----------|-------|
| Min SDK | 26 (Android 8.0) |
| Target SDK | 34 (Android 14) |
| Language | Kotlin 1.9.24 |
| Build System | Gradle with Kotlin DSL |
| UI Framework | Jetpack Compose |

## Key Features
- ⏰ Alarm Management
- 🌍 World Clock
- ⏱️ Timer & Stopwatch
- 🔔 Notifications
- 📱 Material Design 3

## Troubleshooting

| Issue | Solution |
|-------|----------|
| ANDROID_SDK_ROOT not set | `export ANDROID_SDK_ROOT=~/Android/Sdk` |
| Permission denied | `chmod +x gradlew` |
| Build memory error | Add `org.gradle.jvmargs=-Xmx4096m` to gradle.properties |
| Gradle sync fails | Run `./gradlew clean && ./gradlew build` |

## CI/CD Build
APKs are automatically built on:
- Push to `main` or `develop`
- Pull requests
- Manual workflow trigger

Check GitHub Actions for build artifacts.
