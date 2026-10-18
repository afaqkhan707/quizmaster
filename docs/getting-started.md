# Getting started

## Prerequisites

- Android Studio (recent stable; project targets **compileSdk 37**)
- **JDK 11+**
- Android device or emulator (**minSdk 28**, Android 9+)
- Firebase project with Android app registered
- AdMob account (for production ads; test IDs work for dev)

## Clone and run

```bash
git clone <repo-url>
cd QuizMaster
```

Open the project in Android Studio → **Run** on a device/emulator.

Or from terminal:

```bash
./gradlew assembleDebug
```

Install the APK from `app/build/outputs/apk/debug/`.

## Firebase setup

1. [Firebase Console](https://console.firebase.google.com/) → project **quizmasterperegrine** (or your own).
2. Add Android app with package **`com.peregrine.quizmaster`**.
3. Download **`google-services.json`** → place in **`app/`**.
4. Enable **Authentication → Sign-in method → Google**.
5. Copy **Web client ID** into `LoginViewModel.WEB_CLIENT_ID` in `LoginViewModel.kt`.
6. Create **Firestore** database and add documents per [Firebase](./firebase.md).
7. Deploy [security rules](./firebase.md#security-rules-recommended).

Gradle already applies:

- `com.google.gms.google-services`
- Firebase BOM (Analytics, Auth, Firestore)

## AdMob setup

1. [AdMob](https://admob.google.com/) → link Firebase app if prompted.
2. Note **App ID** — must match `AndroidManifest.xml` `APPLICATION_ID` meta-data.
3. Create ad units (banner, interstitial; rewarded later).
4. Replace test unit IDs in:
   - `ui/ads/BannerAdView.kt`
   - `ui/result/ResultScreen.kt`

See [AdMob](./admob.md) for placement policy.

## SHA-1 for Google Sign-In (debug/release)

Firebase Console → Project settings → Your apps → Add fingerprint:

```bash
# Debug keystore (default Android Studio path)
keytool -list -v -keystore ~/.android/debug.keystore -alias androiddebugkey -storepass android -keypass android
```

Add release SHA-1 when shipping to Play Store.

## Common issues

| Problem | Check |
|---------|--------|
| Empty categories/questions | Firestore data, `isActive`, indexes, internet |
| Google Sign-In fails | WEB_CLIENT_ID, SHA-1, Google provider enabled |
| Questions loading forever | Logcat for Firestore errors; ViewModel now sets error on failure |
| Banner under nav bar | `screenNavigationBars()` on banner container (Home) |
| AdMob no fill | Test IDs, test device, new ad units need time |

## Documentation index

[docs/README.md](./README.md)
