# Usage

## Overview

Module: `backend`

The server is configured to run on port **8080**.
To change this behavior, edit the configuration file `backend/src/main/resources/application.yaml`.

## Run standalone server

To debug your changes:

```
./gradlew :backend:run
```

## Run SPA application

If you included the Web platform, the backend module provides a few extra Gradle commands:

- `./gradlew :backend:runDevSPA` - Runs your **backend** module with the **web** module included (debug build) to serve content at the root context path.
- `./gradlew :backend:runProdSPA` - Runs your **backend** module with the **web** module included (production build) to serve content at the root context path.
- `./gradlew :backend:assembleSPA` - Assembles your **backend** module with the **web** module included (production build).
