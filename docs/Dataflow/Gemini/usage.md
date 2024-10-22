# Usage

## Overview

The API can be accessed through:
- `app.common.data.source.ai.AiSource` - an interface at the app level.
- `app.common.data.source.ai.gemini.GeminiAiSource` - a class that implements the interface at the app level.

The API is pre-configured in `app.di.common.AiSourceModule`.

**AiSource** provides the following method:

- `reply(prompt: String): Flow<String>` - Sends a request to the AI and returns a flow of generated replies.

## Configuration

To use the `GeminiAiSource` class, you need a [Gemini API Key](https://ai.google.dev/gemini-api/docs/api-key).  
Obtain the key and configure it in `app.di.common.AiSourceModule`.

## Example

Examples of using the API are available in the package `app.feature.showcases.presentation.dataflow.ai.gemini`.  
The UI flow can be found on the main screen of the app.
