## Overview

- Component package: `app.userflow.passcode`
- DI integration: `app.di.state.ProvidesPasscodeState`
- Repository: `app.userflow.passcode.repository.PasscodeRepository`

The flow is pre-configured to effectively manage app lifecycle through `app.userflow.passcode.PasscodeInitializer`, which adapts based on the settings defined in `PasscodeState` once the user activates the passcode.

The flow can be utilized in the following scenarios:

## Set passcode

```kotlin
@HiltViewModel
class TemplateViewModel @Inject constructor(
    private val navigationState: NavigationState,
) : BaseViewModel() {

    fun onSetPasscode() {
        navigationState.onNext(SetPasscodeDestination)
    }

}
```

Once initiated, the user will be prompted to set their passcode, confirm it, and activate biometric authentication (if available). Each of these screens is implemented as separate destinations by default.

## Start app with enabled passcode

The behaviour comes pre-configured in `app.AppNavigationRouter` to set the initial destination as `UnlockPasscodeDestination` if passcode is enabled.

```kotlin
@ViewModelScoped
class AppNavigationRouter @Inject constructor(
    private val passcodeRepository: PasscodeRepository
) {

    suspend fun getStartDestination(): NavigationDestination<*> {
        return when {
            passcodeRepository.isLocked() -> UnlockPasscodeDestination
            else -> ShowcasesDestination
        }
    }

}
```
## Resume app with enabled passcode

The behavior is pre-configured and managed through `app.userflow.passcode.PasscodeInitializer`.

If the `PasscodeState` has the configured property `resumeTimeout`, the `PasscodeInitializer` will remember the last time the app was sent to the background. It will prompt the user to enter the passcode if they return after the `resumeTimeout` has expired.

## Reset passcode from Unlock Screen

If the `PasscodeState` is configured to reset the passcode (`canForgetPasscode = true`), then from the **Unlock Screen**, it will be possible to navigate to the `ResetPasscodeDestination`.

On the `ResetPasscodeScreen`, once the user confirms their action, the flow will clear all saved data related to the **passcode flow itself** and navigate the user to the destination obtained from `AppNavigationRouter#getStartDestination`.

## Reset passcode after wrong attempts

`PasscodeState` comes with a property `unlockAttemptsCount`. Whenever user is trying to enter a wrong passcode to unlock the app, his attempt is registered.
Once the limit is reached, the flow will clear all saved data related to the **passcode flow itself** and navigate the user to the destination obtained from `AppNavigationRouter#getStartDestination`.

```
If specific logic needs to be executed at this point, such as clearing authentication state or user data, it can be implemented within `AppNavigationRouter#getStartDestination`.
```

## Reset passcode manually

`PasscodeRepository` handles all business logic related to the passcode flow.

```kotlin
@HiltViewModel
class TemplateViewModel @Inject constructor(
    private val passcodeRepository: PasscodeRepository
) : BaseViewModel() {

    fun onResetPasscode() {
        launchAsync("reset") {
            passcodeRepository.reset()
        }
    }

}
```

## Navigate to a destination that requires a passcode.

In some scenarios, it can be useful to ask the user to confirm their passcode before proceeding to another screen, such as before changing their existing passcode, email, authentication, or name. In such cases, the helper class `PasscodeFlow` can be used.

```kotlin
@HiltViewModel
class TemplateViewModel @Inject constructor(
    private val passcodeFlow: PasscodeFlow
) : BaseViewModel() {

    fun onChangeEmail() {
        launchAsync("changePasscode") {
            passcodeFlow.navigateWithPasscode(SetPasscodeDestination)
        }
    }

}
```






