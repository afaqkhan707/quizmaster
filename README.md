# QuizMaster

Android quiz app built with **Jetpack Compose**, **Firebase** (Auth + Firestore), and **AdMob**. Optional Google sign-in; guests can play without an account. Signed-in users get stats synced to Firestore.

## Features

- Browse quiz categories from Firestore
- Multiple-choice quizzes with instant feedback and explanations
- Results screen with score and retry
- Google Sign-In or continue as guest
- Settings with profile and quiz stats (when signed in)

## Documentation

Full documentation lives in **[`docs/`](./docs/README.md)**:

| Topic | File |
|-------|------|
| Index | [docs/README.md](./docs/README.md) |
| Architecture | [docs/architecture.md](./docs/architecture.md) |
| Codebase | [docs/codebase.md](./docs/codebase.md) |
| Firebase | [docs/firebase.md](./docs/firebase.md) |
| Authentication | [docs/authentication.md](./docs/authentication.md) |
| AdMob | [docs/admob.md](./docs/admob.md) |
| Navigation & UI | [docs/navigation-and-ui.md](./docs/navigation-and-ui.md) |
| Getting started | [docs/getting-started.md](./docs/getting-started.md) |
| Roadmap | [docs/roadmap.md](./docs/roadmap.md) |

## Quick start

```bash
git clone <repo-url>
cd QuizMaster
# Open in Android Studio → Run
```

```bash
./gradlew assembleDebug
```

**Requirements:** JDK 11+, Android Studio, `google-services.json` in `app/`. See [Getting started](./docs/getting-started.md).

## Project info

| Item | Value |
|------|--------|
| Package | `com.peregrine.quizmaster` |
| Firebase project | `quizmasterperegrine` |
| Min SDK | 28 |
| Target / compile SDK | 37 |

## Developer

Built by **Peregrine** as a portfolio project (MVVM, Firebase, AdMob, modern Android).
