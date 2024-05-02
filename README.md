# Compose Multiplatform Configurable Template

Supported platforms:
- Android
- iOS
- Web
- Desktop (Windows, MacOS, Linux)

The template follows the general principals:

- The underlying architecture is minimalistic, pre-configured, and complies with [the latest recommended guidelines](https://developer.android.com/modern-android-development).
- Third-party dependencies, components, DevOps practices, and configurations are optional and can be included or excluded through an online service [Kotli](https://kotlitecture.com).
- All out-of-the-box solutions are designed to accelerate the development of complex and production-ready applications within days, prioritizing simplicity and efficiency during the implementation and support phases.

# Architecture

// TODO DIAGRAM

The overall architecture is built on:
- [JetBrains Compose Multiplatform](https://www.jetbrains.com/lp/compose-multiplatform/)
- [Jetpack Compose](https://developer.android.com/develop/ui/compose)
- [Jetpack Navigation](https://developer.android.com/guide/navigation)
- [Jetpack Lifecycle + ViewModel](https://developer.android.com/topic/libraries/architecture/lifecycle)
- [Material 3 Design](https://m3.material.io)
- [Koin Dependency Injection](https://insert-koin.io)

Application logic is implemented in the app module and contains only app-specific behavior.

All common logic is part of the shared group, which is split into three modules:

- **core** - architectural solutions to integrate app components with each other.
- **data** - data sources to use in the app.
- **design** - the design system of the app (fonts, themes, UI components, etc.).

These modules are used only at the app level. This approach lets you develop all three components independently and create a more complex app structure. For example, app-specific features can be implemented as separate modules, having the same shared dependencies.

## Module - core

Provides architectural solutions to implement user flows and integrate all components with each other in a lifecycle-aware manner.

It includes:

- **MVVM pattern implementation** - based on the Jetpack ViewModel and Jetpack Lifecycle components.
- **Navigation implementation** - based on the Jetpack Navigation component.

The included solutions are not mandatory to follow, as all required dependencies are properly included to enable you to use your own patterns with Jetpack components.

However, the provided implementations are very intuitive to use and cover all possible cases of communication between components in various real-life scenarios.

Feel free to choose what fits your needs best.

## Module - data

Provides a fundamental implementation of commonly used data sources in different apps. During project setup via [Kotli](https://kotlitecture.com), only the required data sources will be included.

All data sources have been configured to access the necessary data layer in a flexible and convenient manner.

## Module - design

Provides pre-configured themes, fonts, and UI components to establish the initial [Design System](https://en.m.wikipedia.org/wiki/Design_system) of the entire app.

The default module implementation is based on the [Google Material 3 Design](https://m3.material.io), which offers all fundamental UI components and guidelines out of the box, enabling the creation of your own Design System with ease.

In addition to the Material 3 library, the module implements several components and containers used in different user flows.

The main idea of this module is to create a **Design System** that can be used by any UI feature of the app without dependency on the underlying UI kit. 

## Module - app

The Application module itself contains:

- Logic to properly connect all included components together with the help of Dependency Injection (Koin, by default).
- Showcases to demonstrate some features included during [project setup](https://kotlitecture.com/project).

Once you download and import the initial project structure into your IDE, the project is ready to run on a device, enabling you to understand the included functionality and start adding the required features.

## Project Documentation

Once you've configured your project through [Kotli](https://kotlitecture.com/project) and downloaded the generated source codes, this project become fully yours and is not bound to the service. Each project includes a README.MD file in its root with the following helpful details:

- A link to the initial template used to prepare the project structure (GitHub page of the template, similar to this one).
- A link to the architecture ([Kotli](https://kotlitecture.com/project) project) used to prepare and download these sources.
- A list of all features included in the project during its [setup](https://kotlitecture.com/project). Each feature includes additional documentation within the project's docs directory, making it easy to check what is included, find official links, and understand how to use and configure each functionality if needed.

All documentation related to features can also be found and accessed online, up-to-date, once you open the link to your Kotli project.

## Project Showcases

When a project is configured and downloaded via [Kotli](https://kotlitecture.com/project), it also provides showcases of all included features. Furthermore, the screen with showcases is configured as the initial screen when running the downloaded template.

# Usage

!IMPORTANT! The given template is a [Kotli Template](https://kotlitecture.github.io/engine/template_overview).

To generate the required project structure, use online service [Kotli](https://kotlitecture.com/project) (it's free and only requires an internet connection).

Once you configure the necessary features and generate the archive with source codes, you'll have a ready-to-use and working project structure that can be imported into your IDE to begin adding the required business logic.

By default, the template will also include all necessary showcases to make understanding of the included features easy.

Run your project to check what is included and how it works, and once everything is clear, remove the package with showcases and any references to it.

# Features

All these features are optional, will be updated over time, and can be included in the generated structure during [project setup](https://kotlitecture.com).

The generated project will include a similar table in its README.MD file, but with only the configured features (direct and transitive).

// TODO