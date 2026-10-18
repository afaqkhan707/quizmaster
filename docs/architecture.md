# Architecture

QuizMaster uses **MVVM** with Jetpack Compose for UI and a **Repository** pattern for Firebase data.

## Layer diagram

```text
┌─────────────────────────────────────────────────────────┐
│  UI (Compose)                                           │
│  HomeScreen, QuizScreen, ResultScreen, LoginScreen, …   │
└───────────────────────────┬─────────────────────────────┘
                            │ events ↑  state ↓
┌───────────────────────────▼─────────────────────────────┐
│  ViewModel                                              │
│  HomeViewModel, QuizViewModel, LoginViewModel, …        │
└───────────────────────────┬─────────────────────────────┘
                            │
┌───────────────────────────▼─────────────────────────────┐
│  Repository (interfaces)                                │
│  QuizRepository, AuthRepository                         │
└───────────────────────────┬─────────────────────────────┘
                            │
┌───────────────────────────▼─────────────────────────────┐
│  Implementations                                        │
│  FirestoreQuizRepository, FirebaseAuthRepository        │
└───────────────────────────┬─────────────────────────────┘
                            │
┌───────────────────────────▼─────────────────────────────┐
│  Firebase (Auth, Firestore, Analytics) + AdMob SDK      │
└─────────────────────────────────────────────────────────┘
```

## Responsibilities

| Layer | Role |
|-------|------|
| **UI** | Composables only: layout, user input, display `UiState` / `QuizUiState`. No Firestore calls. |
| **ViewModel** | Quiz logic, loading categories/questions, login flow, survives configuration changes. |
| **Repository** | Single place for Firebase reads/writes; maps documents to `Category`, `Question`, `User`. |
| **Model** | Kotlin `data class` types matching Firestore fields. |

## State management

Two patterns are used today:

| Screen / feature | State type | Notes |
|------------------|------------|--------|
| Home, Login, Settings | `StateFlow<UiState<T>>` | Sealed `UiState`: Idle, Loading, Success, Error |
| Quiz (+ shared with Result) | `QuizUiState` + `mutableStateOf` | One `QuizViewModel` scoped to navigation graph |

`QuizViewModel` is created once in `QuizNavigation` and passed to `QuizScreen` and `ResultScreen` so score and category survive until reset.

## Dependency injection

Repositories are **constructed inside ViewModels** (e.g. `FirestoreQuizRepository()`). There is no Hilt/Koin yet. For tests, introduce interfaces (already present) and inject fakes later.

## Navigation

Single-activity app: `MainActivity` → `QuizNavigation` → `NavHost` with routes in `Routes` object. See [Navigation & UI](./navigation-and-ui.md).

## Cross-cutting

| Piece | Location | Purpose |
|-------|----------|---------|
| `UiState` | `core/UiState.kt` | Generic loading/success/error for lists and login |
| Screen insets | `ui/layout/ScreenLayout.kt` | Status bar / navigation bar padding (edge-to-edge) |

## Data flow examples

### Start quiz

1. User taps category on `HomeScreen` → `onCategoryClick(categoryId)`.
2. `QuizNavigation` calls `quizViewModel.startQuiz(categoryId)` then navigates to `QUIZ`.
3. `QuizViewModel` sets loading, calls `quizRepository.getQuestions(categoryId)`.
4. `QuizScreen` reads `uiState` and shows loading, error, or questions.

### Save stats (signed-in only)

1. User finishes last question → `saveStatsIfLoggedIn()` then navigate to Result.
2. If `AuthRepository.getCurrentUser()` is non-null, `updateQuizStats` runs in a Firestore transaction on `users/{uid}`.

### Guest vs signed-in

Guests use the app without Firebase Auth. Stats are not persisted. See [Authentication](./authentication.md).

## Planned architecture improvements

- Dependency injection (Hilt)
- Unified state (`StateFlow` everywhere or Compose `State`)
- Use cases layer (optional) between ViewModel and Repository
- Offline/caching (Firestore persistence or local Room cache)
- Feature flags for ads (`showAds` from user/subscription doc)
