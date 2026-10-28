---
name: mobile-android-design
description: Guidelines for building awesome Jetpack Compose UI, Material 3 design systems, and robust test/state management in Android apps like QuizMaster.
metadata:
  type: reference
---

# Mobile Android Design & State/Test Guidelines (`mobile-android-design`)

This skill provides design, state, and testing guidelines tailored for Jetpack Compose Android applications.

## 1. Awesome Design & Material 3 UI

- **Color Palette & Branding**:
  - Primary Brand Color: `#7562E8` (Purple)
  - Ensure high contrast in both light and dark themes using Material 3 color roles (`primary`, `secondary`, `surface`, `background`, `onPrimary`, etc.).
- **Edge-to-Edge Layout**:
  - Always support edge-to-edge rendering by respecting `WindowInsets` (`systemBars`, `ime`, `navigationBars`).
  - Use centralized layout wrappers (e.g., `ScreenLayout`) to apply consistent padding for top status bars and bottom navigation/banner ad heights.
- **Component Consistency**:
  - Use standard Material 3 components (`Card`, `Button`, `TopAppBar`, `NavigationBar`) with rounded corners (`CornerRadius` matching design system).
  - Provide smooth transitions and instant visual feedback on user interaction.

## 2. State Management

- **Asynchronous Data (`UiState`)**:
  - For lists, profile loading, and authentication flows, use a sealed class `UiState<T>` with states:
    - `Idle`
    - `Loading`
    - `Success(data: T)`
    - `Error(message: String)`
- **ViewModel & Flow**:
  - Expose states via `StateFlow<UiState<T>>` using `MutableStateFlow`.
  - In Composables, collect states efficiently using `collectAsStateWithLifecycle()`.
- **Scoped UI State**:
  - For complex flows like active quizzes (`QuizViewModel`), maintain a cohesive UI state data class that tracks question index, score, selected answers, and timer state, shared across screens within the navigation graph.

## 3. Testing Strategy (`tasteskill`)

- **Repository Abstraction**:
  - Keep data operations behind repository interfaces (`QuizRepository`, `AuthRepository`) to enable dependency injection and fake implementations for testing.
- **Unit Testing ViewModels**:
  - Test ViewModels using JUnit, Coroutines Test Dispatchers (`StandardTestDispatcher`), and fake repositories.
  - Verify state transitions from `Loading` to `Success` or `Error`.
- **Instrumented UI Tests**:
  - Use Jetpack Compose UI Test (`createComposeRule()`) for testing screen components and user interactions.
