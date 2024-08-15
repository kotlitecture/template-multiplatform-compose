# Usage

## Overview

- Component package: `app.presentation.passcode`
- DI integration: `app.di.presentation.PasscodeModule`
- Use Cases: `app.presentation.passcode.usecase`

The flow is pre-configured to effectively manage the app lifecycle through `app.presentation.passcode.PasscodeProvider`, which adapts based on the settings defined in `PasscodeStore` once the user activates a passcode. By default, the passcode is hashed and stored locally on the device.

**Passcode settings** can be configured via `PasscodeStore` which is pre-configured at the DI level `PasscodeModule`.

```kotlin
data class PasscodeStore(
    val persistentKey: String = "passcode_config", // the key to store the passcode state locally.
    val passcodeLength: Int = 4, // the length of the passcode which user can set via the default UI.
    val unlockAttemptsCount: Int = 5, // the number of wrong attempts before the lock screen will become permanent (until user reset it or you implement some other behaviour).
    val resumeTimeout: Long = 10.seconds.inWholeMilliseconds, // time to keep the app unlocked in the background.
    val encryptionMethod: (code: String) -> EncryptionMethod = EncryptionMethod::PBKDF2 // method, used to hash the passcode to store it locally. 
)
```

The flow can be utilized in the following scenarios:

## Set passcode

```kotlin
class TemplateViewModel(
    private val navigationState: NavigationState,
) : BaseViewModel() {

    fun onSetPasscode() {
        navigationState.onNext(SetPasscodeDestination)
    }

}
```

Once initiated, the user will be prompted to create and confirm their passcode. The passcode in hashed with `PBKDF2` hashing algorithm by default (which can be changed as everything else of course).

## Reset passcode

```kotlin
class TemplateViewModel(
    private val navigationState: NavigationState,
) : BaseViewModel() {

    fun onSetPasscode() {
        navigationState.onNext(ResetPasscodeDestination)
    }

}
```

The confirmation screen will appear, prompting the user to enter the current passcode to proceed with the reset. 

## Unlock passcode

The behavior is pre-configured through `PasscodeProvider` to block access to the app with a passcode screen whenever the app is opened or restored from the background after a certain period of time.

This behavior can be easily modified through `PasscodeViewModel`.
