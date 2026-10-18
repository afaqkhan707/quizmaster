# Roadmap

Status as of current codebase. Update this file when features ship.

## Completed

- [x] Jetpack Compose UI (Home, Quiz, Result, Login, Splash, Settings)
- [x] Navigation Compose (full flow including settings)
- [x] MVVM + `QuizRepository` / `AuthRepository`
- [x] Firestore categories and questions (`FirestoreQuizRepository`)
- [x] `HomeViewModel` + loading/error states for categories
- [x] `QuizViewModel` with scoring, explanations, retry category id
- [x] Firebase Analytics (SDK dependency)
- [x] Firebase Auth + Google Sign-In (Credential Manager)
- [x] Optional guest mode
- [x] User profile + quiz stats in Firestore (signed-in)
- [x] AdMob SDK + banner (Home) + interstitial (Result) — test units
- [x] Edge-to-edge safe areas and scroll fixes (quiz, home, settings)
- [x] Project documentation in `docs/`

## In progress / next

### Monetization (policy-safe)

- [ ] Remove home banner (or replace with policy-safe placement)
- [ ] Interstitial: preload + show at explicit break (“See my result”)
- [ ] Interstitial frequency cap (not every retry)
- [ ] Rewarded ad: optional hint or explanation (opt-in)
- [ ] `showAds` / premium flag for subscribers

### Firebase & product

- [ ] Firestore security rules deployed and verified in console
- [ ] Distinct error states (offline vs empty vs permission)
- [ ] Quiz history per user
- [ ] Leaderboards
- [ ] Synced stats across devices (already partial via user doc)

### Architecture & quality

- [ ] Hilt (or Koin) for repositories
- [ ] Unit tests for `QuizViewModel` and repositories
- [ ] Centralize brand colors in theme
- [ ] Update root README checklist to match reality

### Play Store

- [ ] Privacy policy (auth, Firestore, ads)
- [ ] Production AdMob units
- [ ] ProGuard / release testing

## Future ideas (not committed)

- Per-question timer
- Daily challenge from Firestore flag
- Dark mode toggle (Settings placeholder exists)
- Play Billing subscription for ad-free + extras
- Remote Config for ad and content toggles

## Related docs

- [AdMob](./admob.md)
- [Firebase](./firebase.md)
- [Authentication](./authentication.md)
