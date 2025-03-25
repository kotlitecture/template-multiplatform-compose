## Overview

- Component package: `app.passcode`
- DI integration: `app.di.PasscodeModule`

The flow is pre-configured to effectively manage the app lifecycle through `app.passcode.presentation.provide.PasscodeProvider`.

**Passcode settings** can be configured via `app.di.PasscodeModule` which is pre-configured at the DI level `PasscodeModule`.

```kotlin
val passcodeModule = module {
    single<PasscodeRepository> {
        PasscodeRepositoryImpl(
            passcodeLength = 4,
            unlockAttemptsCount = 5,
            persistentKey = "passcode_config",
            resumeTimeout = 10.seconds.inWholeMilliseconds,
            encryptionSource = get(),
            settingsSource = get(),
        )
    }
}
```








