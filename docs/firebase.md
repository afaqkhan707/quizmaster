# Firebase

QuizMaster uses **Firebase Auth**, **Cloud Firestore**, and **Firebase Analytics**. Configuration is via `app/google-services.json` and the Google Services Gradle plugin.

| Setting | Value |
|---------|--------|
| Firebase project ID | `quizmasterperegrine` |
| Android package | `com.peregrine.quizmaster` |

## Services in use

| Service | Purpose in app |
|---------|----------------|
| **Authentication** | Google Sign-In; optional — guest mode skips Auth |
| **Cloud Firestore** | Categories, questions, user profiles and quiz stats |
| **Analytics** | Automatic events via Firebase SDK (no custom events documented in code yet) |

## Firestore collections

### `categories`

| Field | Type | Description |
|-------|------|-------------|
| `name` | String | Display name |
| `description` | String | Subtitle on home card |
| `isActive` | Boolean | If false, hidden from queries |
| `order` | Number | Sort order on home screen |

**Suggested document IDs:** `general_knowledge`, `science`, `history`, `mathematics`, `geography`

**Query (app):**  
`categories` where `isActive == true` orderBy `order`

Requires a composite index if Firestore prompts in console.

### `questions`

| Field | Type | Description |
|-------|------|-------------|
| `categoryId` | String | Matches category document ID |
| `question` | String | Question text |
| `options` | Array of String | Typically 4 choices |
| `correctAnswerIndex` | Int | 0-based correct option |
| `explanation` | String | Shown after answer |
| `isActive` | Boolean | Exclude from quiz if false |
| `order` | Number | Order within category |

**Query (app):**  
`questions` where `categoryId == ?` and `isActive == true` orderBy `order`

### `users`

Document ID = Firebase Auth `uid`.

| Field | Type | Description |
|-------|------|-------------|
| `uid` | String | Same as document ID |
| `name` | String | From Google profile |
| `email` | String | From Google profile |
| `photoUrl` | String | Profile image URL |
| `quizzesPlayed` | Int | Incremented after each completed quiz |
| `questionsAnswered` | Int | Total questions in finished quizzes |
| `correctAnswers` | Int | Total correct |
| `bestCategory` | String | Category ID heuristic after each quiz |

**Write paths:**

- Create on first Google login (`saveUserToFirestore`) if doc missing.
- Update stats via transaction in `updateQuizStats` after quiz completion (signed-in only).

## Authentication flow (summary)

1. **Credential Manager** obtains Google ID token (`LoginViewModel.WEB_CLIENT_ID` must match Firebase Web client).
2. **Firebase Auth** `signInWithCredential`.
3. **Firestore** user doc created once if absent.

Details: [Authentication](./authentication.md).

## Security rules (recommended)

Public read for quiz content; no client writes to categories/questions. Users should only read/write their own `users/{uid}`.

Example baseline (adjust before production):

```javascript
rules_version = '2';
service cloud.firestore {
  match /databases/{database}/documents {

    match /categories/{categoryId} {
      allow read: if true;
      allow write: if false;
    }

    match /questions/{questionId} {
      allow read: if true;
      allow write: if false;
    }

    match /users/{userId} {
      allow read, write: if request.auth != null && request.auth.uid == userId;
    }
  }
}
```

**Important:** If rules still allow public write on `users`, fix them before release. The app assumes authenticated updates for stats.

## Setup checklist

1. Create Android app in Firebase Console with package `com.peregrine.quizmaster`.
2. Download `google-services.json` into `app/`.
3. Enable **Authentication → Google** sign-in provider.
4. Copy **Web client ID** into `LoginViewModel.WEB_CLIENT_ID`.
5. Create Firestore database and seed `categories` / `questions`.
6. Deploy security rules above (or stricter).
7. Create composite indexes when Firestore shows index URLs in logcat.

## Error handling in app

`FirestoreQuizRepository` catches exceptions and returns empty lists. UI shows “No categories/questions” or connection hints. Consider surfacing distinct errors (permission, offline) later.

## Planned Firebase features

| Feature | Notes |
|---------|--------|
| Leaderboards | Likely collection or aggregated fields; needs rules and anti-cheat design |
| Quiz history | Subcollection `users/{uid}/attempts` or similar |
| Subscriber / no-ads flag | Field on user doc e.g. `isPremium` or `adsDisabled` |
| Remote Config | Toggle ads, minimum app version |

## Related docs

- [Authentication](./authentication.md)
- [Architecture](./architecture.md)
