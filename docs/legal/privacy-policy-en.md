# Privacy Policy — Kartonki

**Effective date:** 2026-05-03
**Developer contact:** einerin40@gmail.com

Kartonki ("the App") is an Android application for learning foreign words through flashcards and game mechanics. This policy describes what data we collect, why, and how to manage it.

## What we collect

### 1. Anonymous usage analytics (Google Firebase Analytics)

We collect anonymized data about how the App is used to improve its quality:

- In-app events: screen opens, session duration, which word sets are studied, quiz answers (correct/incorrect, response time), deck building and usage, PvP match results, achievements unlocked, reward packs opened
- Device technical parameters: device model, Android version, system language, region (country level), screen resolution, app version
- Anonymous user identifier (Firebase Installation ID), reset on app uninstall and reinstall

**What we do NOT collect:**
- Name, email, phone, or any other personal data
- Content of text input (deck names, search queries)
- Contacts, photos, files, location
- Browsing history of other websites or use of other apps

### 2. Authentication (optional, user choice)

If you choose to sign in with a Google account to participate in online PvP:
- Email and display name are saved for matchmaking identification
- Progress and collection are synced between devices
- Data is stored in Google Firebase Authentication and Firestore Database

If you play without signing in — no personal information is transmitted.

### 3. Crashes and errors

If the app terminates unexpectedly, we record the error type (e.g. `NullPointerException`) and app version. The call stack (memory contents) is not transmitted.

## Why we use this data

- Understand which app features are popular to develop them further
- Identify problematic words and exercises (low answer success rate → improve wordings)
- Diagnose errors and crashes
- Evaluate the quality of translations and quizzes

Data is **not shared** with third parties for commercial purposes, not used for advertising, not sold.

## How data is stored and transmitted

- Analytics are sent to Google Firebase Analytics servers (Google LLC, USA). Event retention period is 14 months, after which they are automatically deleted.
- Network match data and account information are stored in Google Firebase Realtime Database / Firestore.
- Transmission between the app and Google servers uses secure HTTPS.

For more about Google's data processing: [https://policies.google.com/privacy](https://policies.google.com/privacy)

## Your rights

- **Delete account in-app:** Settings → Account → "Delete account". Removes immediately: Firebase profile, online PvP statistics, active matchmaking slots. See [account deletion guide](account-deletion-en.md) for details.
- **Delete account without app access:** email einerin40@gmail.com with the Google account address — we will delete it within 30 days.
- **Delete local data:** uninstall the App — local progress, analytics, and Installation ID are reset. Cloud analytics expires automatically after 14 months.
- **Opt out of analytics:** an "opt out of anonymous analytics" toggle in settings will be added in a future version. To opt out now, uninstall the App.

## Changes to this policy

If we update this policy, the date at the top changes. Significant changes are announced in the App's Google Play listing.

## Contact

Questions and data removal requests: **einerin40@gmail.com**

---

*Russian version: [privacy-policy.md](privacy-policy.md)*
