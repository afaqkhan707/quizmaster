# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Commands



## Architecture & Code Structure

QuizMaster is an Android app built with Kotlin, Jetpack Compose, Firebase (Auth + Firestore), and AdMob, structured around the **MVVM** and **Repository** patterns within a single module (`app`), package root `com.peregrine.quizmaster`.

### Key Packages & Layers

- **`ui/`**: Jetpack Compose screens, ViewModels, and UI components.
  - Features broken into packages: `auth`, `home`, `quiz`, `result`, `settings`, `splash`, `ads`, `layout`, `theme`.
  - State management utilizes `StateFlow<UiState<T>>` (sealed class with Idle, Loading, Success, Error) for data lists/login, and custom state objects for active quizzes.
- **`navigation/`**: `QuizNavigation.kt` manages single-activity single-navhost navigation (`MainActivity` -> `QuizNavigation`).
- **`data/repository/`**: Repository interfaces (`QuizRepository`, `AuthRepository`) and concrete implementations using Firebase (`FirestoreQuizRepository`, `FirebaseAuthRepository`).
- **`data/model/`**: Kotlin data classes mirroring Firestore documents (`Category`, `Question`, `User`).
- **`core/`**: Shared utilities like `UiState.kt` and `MotivationalQuotes.kt`.

## Testing & State Guidelines

- **State Handling:** 
  - Use `UiState<T>` sealed class (`Idle`, `Loading`, `Success`, `Error`) in ViewModels exposed via `StateFlow` for asynchronous data loading.
  - Collect states in Composables using `collectAsStateWithLifecycle()`.
- **Testing Strategy:**
  - Create fake implementations of `QuizRepository` and `AuthRepository` for unit testing ViewModels without requiring live Firebase connections.
  - Place unit tests under `app/src/test/java/com/peregrine/quizmaster/`.

## Awesome Design & UI Standards

- **Material 3 Theme:**
  - Use the project's centralized theme (`QuizMasterTheme` in `ui/theme/Theme.kt`).
  - Brand primary color: Purple (`#7562E8`). Maintain consistent color hierarchy across dark and light palettes.
- **Edge-to-Edge Layout:**
  - Always utilize `ScreenLayout` or handle window insets correctly (`WindowInsets.systemBars`) to prevent content overlap with system status and navigation bars.
- **Ads & Components:**
  - AdMob banner views should use safe container heights via `BannerAdView` and `ScreenLayout` constants to prevent layout shifts.

