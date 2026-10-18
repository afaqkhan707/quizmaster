# Navigation & UI

Single-activity Compose app with Material 3 theming and edge-to-edge layout.

## Navigation graph

```text
                    ┌─────────┐
                    │ SPLASH  │
                    └────┬────┘
           logged in     │      not logged in
              ┌──────────┴──────────┐
              ▼                     ▼
         ┌────────┐            ┌────────┐
         │  HOME  │            │ LOGIN  │──guest/google──┐
         └───┬────┘            └────────┘                │
             │                                          │
             │ settings                                  │
             ▼                                          │
        ┌──────────┐                                    │
        │ SETTINGS │                                    │
        └──────────┘                                    │
             │                                          │
             └──────────────────┬───────────────────────┘
                                ▼
                           ┌────────┐
                           │  QUIZ  │
                           └────┬───┘
                                │ finish
                                ▼
                           ┌────────┐
                           │ RESULT │── retry ──► QUIZ
                           └────┬───┘
                                │ home
                                ▼
                              HOME
```

Routes are defined in `navigation/QuizNavigation.kt` (`Routes` object).

## Screens

| Route | Composable | ViewModel |
|-------|------------|-----------|
| `splash` | `SplashScreen` | — (checks `Firebase.auth`) |
| `login` | `LoginScreen` | `LoginViewModel` |
| `home` | `HomeScreen` | `HomeViewModel` |
| `quiz` | `QuizScreen` | Shared `QuizViewModel` |
| `result` | `ResultScreen` | Shared `QuizViewModel` |
| `settings` | `SettingsScreen` | `SettingsViewModel` |

## Shared quiz state

`QuizViewModel` is created at NavHost level so:

- Quiz and Result share score, question list, `currentCategoryId`.
- Retry calls `startQuiz(categoryId)` again from Result.
- “Back to home” calls `resetQuiz()`.

## Theme

| File | Role |
|------|------|
| `ui/theme/Color.kt` | Color tokens |
| `ui/theme/Type.kt` | Typography |
| `ui/theme/Theme.kt` | `QuizMasterTheme` wrapper |

Many screens still use inline hex colors (e.g. purple `#7562E8`) for brand consistency during iteration.

## Edge-to-edge & scrolling

`MainActivity` calls `enableEdgeToEdge()`. Content must pad for system bars.

| Helper | File | Usage |
|--------|------|--------|
| `screenStatusBars()` | `ScreenLayout.kt` | Top inset |
| `screenNavigationBars()` | `ScreenLayout.kt` | Bottom inset (gesture / 3-button nav) |
| `screenSystemBars()` | `ScreenLayout.kt` | Login, splash, full-screen flows |

### Layout patterns

| Screen | Pattern |
|--------|---------|
| **Home** | Scrollable column + fixed bottom banner area (see AdMob doc) |
| **Quiz** | Scrollable questions; primary button pinned in bottom surface |
| **Result** | Vertically scrollable content with system bar padding |
| **Settings** | Top bar + `weight(1f)` scroll column |

This avoids content hidden behind the navigation bar and the quiz “stuck” issue on small screens.

## Key UI behaviors

| Screen | Behavior |
|--------|----------|
| Quiz | One answer per question; options lock after selection; explanation shown |
| Quiz | Progress bar and “X of Y” header |
| Home | Loading / error / retry for categories |
| Login | Loading on Google button; error text; guest link |

## Assets & manifest

- Launcher: `res/mipmap-*`, vector drawables
- App name: `res/values/strings.xml`
- Theme: `res/values/themes.xml`

## Related docs

- [Architecture](./architecture.md)
- [AdMob](./admob.md)
