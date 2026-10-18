# Authentication

Sign-in is **optional**. Guests can browse categories and take quizzes. **Signed-in users** get Firestore-backed profile and quiz statistics.

## Modes

| Mode | Firebase Auth | Firestore user doc | Stats saved |
|------|---------------|--------------------|-------------|
| **Guest** | No session | No | No |
| **Google** | `FirebaseUser` | `users/{uid}` | Yes, after each completed quiz |

Guest is not a Firebase anonymous user today — it is simply “no login” and navigate to Home.

## User journey

```text
Splash (2s)
    │
    ├─ Firebase.auth.currentUser != null → Home
    └─ else → Login
              ├─ Continue with Google → Home (user doc created if new)
              └─ Continue as Guest → Home
```

Settings shows guest placeholder or loaded `User` from Firestore. **Sign out** clears Auth and navigates to Login (guest stats were never stored).

## Google Sign-In implementation

| Component | Location |
|-----------|----------|
| UI | `LoginScreen.kt` |
| Logic | `LoginViewModel.kt` |
| Backend | `FirebaseAuthRepository.signInWithGoogle` |

Flow:

1. `CredentialManager` + `GetGoogleIdOption` with `WEB_CLIENT_ID`.
2. Parse `GoogleIdTokenCredential` → ID token.
3. `GoogleAuthProvider.getCredential` → `signInWithCredential`.
4. If no existing Firestore user, `saveUserToFirestore` with name, email, photo.

**Configuration:** `LoginViewModel.WEB_CLIENT_ID` must match Firebase Console → Authentication → Google → **Web client ID**.

## Stats update

Triggered from `QuizScreen` when user completes the last question:

- `QuizViewModel.saveStatsIfLoggedIn()`
- Requires non-null `getCurrentUser()`
- Updates counters and `bestCategory` in a Firestore transaction

Guests: method returns immediately (no uid).

## Settings behavior

| `SettingsViewModel.isGuest` | UI |
|-----------------------------|-----|
| true | “Guest User”, prompt to sign in for stats |
| false | Photo, email, stat cards from Firestore |

Sign out: `authRepository.signOut()` → navigation clears stack to Login.

## Privacy & Play Store

If you ship to Play:

- Disclose Google Sign-In and data stored (email, stats) in privacy policy.
- Link to Firebase/Google data processing where required.

## Planned (product)

| Feature | Auth impact |
|---------|-------------|
| Leaderboards | Require sign-in (or anonymous auth with upgrade) |
| Synced history | Per-uid Firestore subcollection |
| No ads for subscribers | Field on user doc; still signed-in |
| Optional “upgrade guest” | Sign in mid-session; merge not needed if guest had no cloud data |

## Related docs

- [Firebase](./firebase.md)
- [Architecture](./architecture.md)
