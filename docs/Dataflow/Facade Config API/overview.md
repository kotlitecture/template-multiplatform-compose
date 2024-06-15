# About

All applications operate with some read-only configurations (feature flags, URLs, etc.) required for the app to function properly in different environments.
 The Config API provides an intuitive facade for managing such configurations easily. This allows you to change the underlying implementation later (e.g., integrating Firebase Remote Config) without impacting the entire codebase.
