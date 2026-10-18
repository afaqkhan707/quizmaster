# Codebase guide

Kotlin Android app, single module `app`, package root `com.peregrine.quizmaster`.

## Project layout

```text
QuizMaster/
├── app/
│   ├── build.gradle.kts          # Dependencies (Compose, Firebase, AdMob)
│   ├── google-services.json      # Firebase config (do not commit secrets in public repos if restricted)
│   └── src/main/
│       ├── AndroidManifest.xml   # AdMob APPLICATION_ID meta-data
│       ├── java/com/peregrine/quizmaster/
│       └── res/                  # Themes, launcher, strings
├── docs/                         # This documentation
├── gradle/                       # Version catalog (libs.versions.toml)
└── README.md                     # Project overview + links to docs
```

## Source packages

### `data/model`

| File | Description |
|------|-------------|
| `Category.kt` | Firestore category: id, name, description, isActive, order |
| `Question.kt` | Question: categoryId, text, options, correctAnswerIndex, explanation, isActive, order |
| `User.kt` | Profile + aggregates: quizzesPlayed, questionsAnswered, correctAnswers, bestCategory |

Document IDs for categories/questions are set when mapping from Firestore (`copy(id = doc.id)`).

### `data/repository`

| File | Description |
|------|-------------|
| `QuizRepository.kt` | Interface: `getCategories()`, `getQuestions(categoryId)` |
| `FirestoreQuizRepository.kt` | Firestore queries with `isActive` and `order` |
| `AuthRepository.kt` | Auth + user doc + stats |
| `FirebaseAuthRepository.kt` | Google credential sign-in, user CRUD, stats transaction |

### `core`

| File | Description |
|------|-------------|
| `UiState.kt` | Sealed class for async UI states |

### `navigation`

| File | Description |
|------|-------------|
| `QuizNavigation.kt` | `NavHost`, `Routes`, wires ViewModels to screens |

### `ui/`

| Package | Files | Role |
|---------|-------|------|
| `auth` | `LoginScreen`, `LoginViewModel` | Google Sign-In (Credential Manager), guest continue |
| `splash` | `SplashScreen` | Branding; routes to Login or Home if session exists |
| `home` | `HomeScreen`, `HomeViewModel` | Categories from Firestore, settings entry |
| `quiz` | `QuizScreen`, `QuizViewModel` | Questions, scoring, feedback |
| `result` | `ResultScreen` | Score UI, interstitial ad (see AdMob doc) |
| `settings` | `SettingsScreen`, `SettingsViewModel` | Profile, stats, sign out |
| `ads` | `BannerAdView` | AdMob banner composable (used on Home today) |
| `layout` | `ScreenLayout.kt` | Insets helpers, banner height constant |
| `theme` | `Color`, `Theme`, `Type` | Material 3 theme |

### Root

| File | Description |
|------|-------------|
| `MainActivity.kt` | Edge-to-edge, `MobileAds.initialize`, `QuizMasterTheme` |

## Tech stack (from `app/build.gradle.kts`)

| Area | Libraries |
|------|-----------|
| UI | Jetpack Compose, Material 3, Navigation Compose |
| Lifecycle | ViewModel, `collectAsStateWithLifecycle`, runtime-compose |
| Firebase | BOM, Analytics, Auth, Firestore |
| Sign-in | Play Services Auth, Credential Manager, Google ID |
| Ads | Play Services Ads |
| Images | Coil (profile photo in Settings) |
| Async | Kotlin Coroutines + `tasks.await()` |

## Tests

| Path | Status |
|------|--------|
| `app/src/test/.../ExampleUnitTest.kt` | Placeholder |
| `app/src/androidTest/.../ExampleInstrumentedTest.kt` | Placeholder |

Repository and ViewModel unit tests are a good next step (fake repositories).

## Conventions

- Purple brand color `#7562E8` used inline in several screens (could centralize in `theme/Color.kt` later).
- Firestore field names match Kotlin property names for `toObject()`.
- Errors in repositories often return empty lists or null; ViewModels map that to user-facing messages.

## Related docs

- [Architecture](./architecture.md)
- [Firebase](./firebase.md)
- [Navigation & UI](./navigation-and-ui.md)
