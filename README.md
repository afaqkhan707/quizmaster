# 🧠 QuizMaster

> A clean, modern Android quiz app built with Jetpack Compose and Firebase — designed as a portfolio project to demonstrate real-world Android skills.

---

## 📱 App Overview

**QuizMaster** is an Android quiz application where users can:
- Browse quiz categories (Science, General Knowledge, Technology, etc.)
- Take timed/sequential quizzes with multiple-choice questions
- See instant feedback after each answer (correct/wrong + explanation)
- View their final score and percentage on a results screen
- Retry a quiz or return to the home screen

The app is being actively developed toward a **production-ready, Firebase-powered** version with:
- Questions and categories fetched from **Cloud Firestore**
- **AdMob ads** integration (banner + interstitial) for monetization
- Full **MVVM architecture** with Repository layer

---

## 🏗️ Architecture

The project follows **MVVM (Model-View-ViewModel)** architecture using Jetpack Compose as the UI layer.

```
QuizMaster/
├── app/
│   └── src/main/java/com/peregrine/quizmaster/
│       ├── data/                        # Data layer
│       │   ├── Question.kt              # Question data model
│       │   └── DummyQuestions.kt        # Local dummy data (temporary)
│       ├── navigation/
│       │   └── QuizNavigation.kt        # NavHost + route definitions
│       ├── ui/
│       │   ├── home/
│       │   │   └── HomeScreen.kt        # Category selection screen
│       │   ├── quiz/
│       │   │   ├── QuizScreen.kt        # Quiz question screen
│       │   │   └── QuizViewModel.kt     # Quiz state & logic
│       │   ├── result/
│       │   │   └── ResultScreen.kt      # Score/result screen
│       │   └── theme/
│       │       ├── Color.kt             # Material color tokens
│       │       ├── Theme.kt             # App-wide Material3 theme
│       │       └── Type.kt              # Typography
│       └── MainActivity.kt             # Single activity entry point
```

### Planned MVVM Expansion (Firebase Integration)

```
data/
├── model/
│   ├── Category.kt                     # Firestore category model
│   └── Question.kt                     # Firestore question model
├── repository/
│   ├── QuizRepository.kt               # Interface
│   └── FirestoreQuizRepository.kt      # Firestore implementation
ui/
├── home/
│   ├── HomeScreen.kt
│   └── HomeViewModel.kt                # Fetches categories from Firestore
└── quiz/
    ├── QuizScreen.kt
    └── QuizViewModel.kt                # Fetches questions from Firestore
```

---

## 🔥 Firebase Setup

| Service         | Status         | Purpose                           |
|-----------------|----------------|-----------------------------------|
| Firebase Core   | ✅ Connected    | `google-services.json` in place   |
| Firebase Analytics | ✅ Connected | Auto-tracking                     |
| Cloud Firestore | 🔄 Planned     | Store categories & questions      |
| AdMob           | 🔄 Planned     | Banner & interstitial ads         |

**Firebase Project ID:** `quizmasterperegrine`  
**Package Name:** `com.peregrine.quizmaster`

### Firestore Data Schema

#### `categories` collection
| Field       | Type    | Description                  |
|-------------|---------|------------------------------|
| name        | String  | Display name of category     |
| description | String  | Short description            |
| isActive    | Boolean | Whether to show to users     |
| order       | Int64   | Display order on home screen |

**Document IDs:** `general_knowledge`, `science`, `history`, `mathematics`, `geography`

#### `questions` collection
| Field              | Type    | Description                        |
|--------------------|---------|------------------------------------|
| categoryId         | String  | Links to a category document ID    |
| question           | String  | The quiz question text             |
| options            | Array   | List of 4 answer strings           |
| correctAnswerIndex | Int64   | 0-based index of correct answer    |
| explanation        | String  | Brief explanation shown after answer |
| isActive           | Boolean | Whether to include in quizzes      |
| order              | Int64   | Order within category              |

---

## 📺 Ad Integration Plan

This app will show ads to generate revenue:

| Ad Type       | Placement                             |
|---------------|---------------------------------------|
| Banner Ad     | Bottom of Home screen                 |
| Interstitial  | After completing a quiz (Result page) |

**Network:** Google AdMob  
**Dependency:** `com.google.android.gms:play-services-ads`

---

## 🛠️ Tech Stack

| Layer        | Technology                            |
|--------------|---------------------------------------|
| Language     | Kotlin                                |
| UI           | Jetpack Compose + Material 3          |
| Architecture | MVVM + Repository pattern             |
| Navigation   | Navigation Compose                    |
| Backend      | Firebase (Firestore + Analytics)      |
| Ads          | Google AdMob (planned)                |
| Min SDK      | 28 (Android 9+)                       |
| Target SDK   | 37                                    |

---

## 🚦 Screens & Navigation

```
HOME ──► QUIZ ──► RESULT
          ▲           │
          └───────────┘ (Retry)
HOME ◄───────────────┘ (Back to Home)
```

1. **HomeScreen** — Shows a "Daily Challenge" banner + category cards. Tapping a card starts a quiz for that category.
2. **QuizScreen** — Shows one question at a time with 4 options. Highlights correct/wrong answers with color feedback and explanations. Progress bar shows question count.
3. **ResultScreen** — Shows final score (`X / Total`) and percentage. Options to retry or go home.

---

## 🔐 Firestore Security Rules (Planned)

```js
rules_version = '2';
service cloud.firestore {
  match /databases/{database}/documents {

    // Public read for categories and questions
    match /categories/{categoryId} {
      allow read: if true;
      allow write: if false;
    }

    match /questions/{questionId} {
      allow read: if true;
      allow write: if false;
    }
  }
}
```

---

## 🚀 Getting Started

### Prerequisites
- Android Studio Hedgehog or newer
- JDK 11+
- A Firebase project (already configured via `google-services.json`)

### Run Locally
```bash
git clone <repo-url>
cd QuizMaster
# Open in Android Studio and Run on emulator/device
```

### Build
```bash
./gradlew assembleDebug
```

---

## 📋 Roadmap

- [x] Basic UI with Jetpack Compose
- [x] Navigation (Home → Quiz → Result)
- [x] QuizViewModel with MVVM pattern
- [x] Local dummy questions
- [x] Firebase Analytics integration
- [ ] Add Firestore dependency
- [ ] Create Repository layer
- [ ] Fetch categories from Firestore
- [ ] Fetch questions from Firestore per category
- [ ] HomeViewModel for Firestore categories
- [ ] AdMob banner ad on Home screen
- [ ] AdMob interstitial ad after quiz result
- [ ] Firestore Security Rules
- [ ] Loading states & error handling UI

---

## 👨‍💻 Developer

Built by **Peregrine** as a portfolio project demonstrating:
- Clean MVVM architecture in Jetpack Compose
- Firebase Firestore integration
- AdMob monetization
- Modern Android development practices
