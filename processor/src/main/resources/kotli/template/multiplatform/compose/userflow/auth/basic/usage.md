## Overview

The `app.auth` package provides a comprehensive authentication flow.

The auth features follow clean architecture principles with clear separation of concerns:

- **Domain Layer**: Contains business logic, models, repositories interfaces, and use cases
- **Data Layer**: Implements repositories and provides data sources
- **Presentation Layer**: Contains UI components, view models, and navigation

## Core Components

### AuthRepository

The `AuthRepository` interface defines the core authentication operations:

```kotlin
interface AuthRepository {
    suspend fun getAuthUser(): Flow<AuthUser?>
    suspend fun signInWithEmail(email: String)
    suspend fun verifyEmail(email: String, otp: String)
    suspend fun signInWithGoogle()
    suspend fun signOut()
}
```

### AuthUser

The `AuthUser` data class represents an authenticated user:

```kotlin
data class AuthUser(
    val id: String,
    val email: String? = null,
    val phone: String? = null,
    val avatarUrl: String? = null,
)
```

## Authentication Flows

### Email Authentication

Email authentication uses a two-step process:
1. User enters their email address
2. User receives and enters a one-time password (OTP) for verification

Key components:
- `SignInWithEmailUseCase`: Initiates the email sign-in process
- `VerifyEmailUseCase`: Verifies the OTP
- `SignInWithEmailViewModel`: Manages the email sign-in state
- `SignInWithEmailScreen`: UI for entering email
- `OtpScreen`: UI for entering the OTP

### Google Authentication

Google authentication is implemented using a provider pattern to allow for platform-specific implementations:

Key components:
- `GoogleFlowProvider`: Interface for platform-specific Google auth implementations
- `SupabaseFlowProvider`: Production implementation using Supabase
- `StubFlowProvider`: Test/development implementation
- `SignInWithGoogleUseCase`: Initiates the Google sign-in process
- `SignInWithGoogleViewModel`: Manages the Google sign-in state

### Sign Out

Sign out is implemented as a simple confirmation dialog:

Key components:
- `SignOutUseCase`: Performs the sign-out operation
- `SignOutViewModel`: Manages the sign-out state
- `SignOutDialog`: Confirmation dialog UI

## Integration

The auth module integrates with the application through:

1. **Navigation**: Auth screens are registered in the navigation graph
2. **Dependency Injection**: Auth components are registered in Koin modules
3. **ViewModel Factory**: Auth ViewModels are registered in the ViewModel factory

## Usage

To use the auth module in your app:

1. Start auth flow:
   ```kotlin
   navController.navigate(BasicAuthRoute("Sign in to continue"))
   ```

2. Get auth state:
   ```kotlin
   val getAuthUseCase = get<GetAuthUseCase>()
   val authUserFlow = getAuthUseCase()
   
   // Collect auth state changes
   authUserFlow.collect { authUser ->
       if (authUser != null) {
           // User is authenticated
       } else {
           // User is not authenticated
       }
   }
   ```