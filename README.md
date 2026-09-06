# ClockApp

ClockApp is an Android application built with Kotlin and Jetpack Compose.

## Included screens

- Alarms and alarm editing
- Timer and stopwatch
- Bedtime
- World clock
- Settings
- Screen saver settings
- Help, feedback, and privacy policy

## Project structure

- app/ — Android application module
- app/src/main/java/com/clockapp/ — Kotlin source and Compose screens
- app/src/main/res/ — Android resources

## Build locally

Open the project in Android Studio and let Gradle sync the dependencies. The project targets Android SDK 34 and uses Java 17 compatibility.

To build a debug APK from a machine with Gradle installed:

    gradle assembleDebug

The generated APK is placed under app/build/outputs/apk/debug/.

## Download an APK from GitHub Actions

The ready-to-use workflow is stored at docs/android-build.yml. Once it is moved to .github/workflows/android-build.yml, every push to main and every pull request will build the debug APK.

Open a completed workflow run in GitHub and download the artifact named ClockApp-debug-apk.

## License

ClockApp is licensed under the GNU Affero General Public License, version 3. See LICENSE for the full text.
