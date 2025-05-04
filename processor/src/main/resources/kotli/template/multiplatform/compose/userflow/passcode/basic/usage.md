## Overview

- Component package: `app.passcode`
- Integration config: `app.passcode.PasscodeConfig`

The flow is pre-configured to effectively manage the app lifecycle through `app.passcode.presentation.provide.PasscodeProvider`.

**Passcode settings** can be configured via `app.passcode.PasscodeConfig`.

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








