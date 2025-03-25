## Overview

The API can be accessed through:
- `shared.data.source.ai.AiSource` - an interface at the app level.
- `shared.data.source.ai.gemini.GeminiAiSource` - a class that implements the interface at the app level.

The API is pre-configured in `app.common.CommonConfig`.

**AiSource** provides the following method:

- `reply(prompt: String): Flow<String>` - Sends a request to the AI and returns a flow of generated replies.

## Configuration

To use the `GeminiAiSource` class, you need a [Gemini API Key](https://ai.google.dev/gemini-api/docs/api-key).  
Obtain the key and configure it in `app.common.CommonConfig`.

## Example

Examples of using the API are available in the package `app.showcases.presentation.dataflow.ai.gemini`.  
The UI flow can be found on the main screen of the app.