## Overview

The client can be obtained from the source `app.common.data.source.supabase.SupabaseSource`.

By default, it is configured via dependency injection (DI) in `app.common.CommonConfig` using the default `projectUrl` and `apiKey`. You should obtain your own credentials and replace the default values accordingly.

Any additional configuration can be performed following the [official Supabase documentation](https://supabase.com/docs).

### Authentication

When both **Supabase** and **Client Auth Flow** are included in the project, the latter will use `app.auth.common.data.repository.SupabaseAuthRepository` as its repository layer implementation.