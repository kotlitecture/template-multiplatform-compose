# Usage

## Overview

- Component package: `app.data.source.database.sqldelight`
- DI integration: `app.di.datasource.ProvidesSqlDelightSource`

The integration includes the following components:

- **AppDatabase**: An SQLite database object generated based on the SQLDelight scripts included in the project.
- **AppSqlDelightSource**: Serves as a holder of the `AppDatabase` instance and acts as a service locator for all DAO objects.
- **User.sq**: An example script that generates the `User` entity and the DAO layer to work with it. All **SQLDelight scripts** are located in the `app/src/commonMain/sqldelight` directory.

## Create new Entity and DAO

SQLDelight generates all entities and DAO objects based on the SQL scripts.

The official guide can be found here: [https://cashapp.github.io/sqldelight/2.0.2/multiplatform_sqlite/#defining-the-schema](https://cashapp.github.io/sqldelight/2.0.2/multiplatform_sqlite/#defining-the-schema).

Imagine you need to add a new entity called **Address** and a **DAO** layer to work with it. Here are the steps to follow:

### 1. Create the `Address.sq` script in the `app/src/commonMain/sqldelight` directory

```
You can use the `User.sq` script as a template.
```

```sqldelight
CREATE TABLE IF NOT EXISTS address (
  id INTEGER PRIMARY KEY NOT NULL,
  country TEXT,
  city TEXT,
  street TEXT
);

count:
SELECT count(*) FROM address;

getAll:
SELECT * FROM address
ORDER BY id DESC;

getAllPaginated:
SELECT *
FROM address
ORDER BY id DESC
LIMIT :limit OFFSET :offset;

insert:
INSERT INTO address(country, city, street)
VALUES (?, ?, ?);

insertAddress:
INSERT INTO address
VALUES ?;

update:
UPDATE address
SET country = ?, city = ?, street = ?
WHERE id = ?;

delete:
DELETE FROM address WHERE id = ?;
```

### 2. Start using it from your code :)

Once the project is recompiled, you can access the generated entity and DAO layer from your code.

```kotlin
class EditAddressViewModel(
    private val databaseSource: AppSqlDelightSource
) : BaseViewModel() {

    fun onAdd() = launchAsync {
        val database = databaseSource.getDatabase()
        database.addressQueries.insert("Country", "City", "Street")
    }

    fun onDelete(address: Address) = launchAsync {
        val database = databaseSource.getDatabase()
        database.addressQueries.delete(address.id)
    }
}
```
