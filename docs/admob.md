# AdMob

Monetization uses **Google AdMob** via `play-services-ads`. Test ad unit IDs are in code until you replace them for production.

## App configuration

| Item | Location |
|------|----------|
| AdMob **App ID** | `AndroidManifest.xml` → `com.google.android.gms.ads.APPLICATION_ID` |
| SDK init | `MainActivity.onCreate` → `MobileAds.initialize` |

Current manifest App ID: `ca-app-pub-6128087307903805~6833448688` (your publisher app — keep consistent with AdMob console).

## Ad formats in project

| Format | File | Unit ID (current) | Where shown |
|--------|------|-------------------|-------------|
| **Banner** | `ui/ads/BannerAdView.kt` | Test: `ca-app-pub-3940256099942544/6300978111` | Bottom of `HomeScreen` |
| **Interstitial** | `ui/result/ResultScreen.kt` | Test: `ca-app-pub-3940256099942544/1033173712` | Loads when Result screen opens |
| **Rewarded** | — | Not implemented | Planned (optional hints / bonuses) |

Replace test IDs with real ad units from [AdMob console](https://admob.google.com/) before release.

## Policy-aligned placement (Google guidance)

Official help:

- [Banner guidance](https://support.google.com/admob/answer/6128877)
- [Interstitial disallowed patterns](https://support.google.com/admob/answer/6201362)
- [Rewarded policies](https://support.google.com/admob/answer/7313578)

### Do show ads

| Placement | Format | Reason |
|-----------|--------|--------|
| After quiz completes (natural break) | Interstitial | Between “playing” and “results” |
| Optional bonus (hint, extra explanation) | Rewarded | User opt-in, clear reward text |
| Static low-interaction screens (optional) | Banner | Only if far from buttons and nav |

### Do not show ads

| Placement | Reason |
|-----------|--------|
| Splash / cold start | Interstitial on launch is disallowed |
| Login / sign-in buttons nearby | Accidental clicks |
| During active quiz (questions + answers) | Continuous gameplay / interaction |
| On app exit | Disallowed |
| After every tap / every retry | Too many interstitials |
| Before user sees result content (surprise) | Poor UX; policy risk |

### Current implementation notes

1. **Home banner** — Fixed bottom bar with nav bar padding. Policy risk: proximity to category taps and system nav. **Planned: remove banner** and rely on fewer, well-timed full-screen ads.
2. **Result interstitial** — Fires in `LaunchedEffect` when Result opens. Acceptable break timing, but score may be hidden until ad closes. **Planned:** preload on last question; show on “See my result” or after dismiss with score visible immediately after.
3. **Frequency** — Cap interstitials (e.g. one per completed quiz, not on every Retry in a row).

## Subscriber / signed-in “no ads” (planned)

Product direction:

- Optional sign-in for stats, leaderboards, sync.
- **Subscribers or premium flag** → skip banner, interstitial, and rewarded prompts (or only show rewarded if user opts in).

Implementation sketch:

```kotlin
// Future: read from Firestore user doc or Play Billing
val showAds = !user.isPremium && !user.adsDisabled
```

Gate `BannerAdView` and `InterstitialAd.load` behind `showAds`.

## Rewarded ads (planned)

Good fits for QuizMaster:

| Reward | Must be |
|--------|---------|
| Hint for current question | In-app only, opt-in button |
| Longer explanation | Non-monetary |
| Cosmetic badge / 2× stat credit | Non-transferable |

Not allowed: cash, gift cards, paying users to click banners.

UI pattern: **“Watch ad for hint”** — skipping must not block finishing the quiz.

## Testing

- Use Google **test ad unit IDs** during development (current code).
- Add test device ID in AdMob if needed for real units during QA.
- Verify behavior with gesture navigation and 3-button nav (insets).

## Production checklist

- [ ] Create production ad units (banner, interstitial, rewarded if used)
- [ ] Replace test IDs in `BannerAdView.kt` and `ResultScreen.kt`
- [ ] Confirm manifest App ID matches AdMob app
- [ ] Review placement against policy links above
- [ ] Add ads disclosure in Play Store listing and privacy policy
- [ ] Implement frequency cap and premium `showAds` flag

## Related docs

- [Navigation & UI](./navigation-and-ui.md) (banner layout on Home)
- [Roadmap](./roadmap.md)
