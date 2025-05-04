# Usage

## Overview

- Component package: `app.common.data.source.database.sqldelight`
- Integration config: `app.platform.PlatformConfig`

The integration includes the following components:

- **AppDatabase**: An SQLite database object generated based on the SQLDelight scripts included in the project.
- **SqlDelightSource**: Serves as a holder of the `AppDatabase` instance and acts as a service locator for all DAO objects.
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

### 2. Add methods into the `DatabaseSource` facade to expose the newly generated DAO.

Follow the existing method patterns and use a **copy-paste** approach to add the required method to `app.common.data.source.database.sqldelight.SqlDelightSource`. 

### 3. Start using it from your code :)

Once the project is recompiled, you can access the generated entity and DAO layer from your code.

```kotlin
class EditAddressViewModel(
    private val databaseSource: DatabaseSource
) : BaseViewModel() {

    fun onAdd() = async {
        databaseSource.insertAddress("Country", "City", "Street")
    }

    fun onDelete(address: Address) = async {
        databaseSource.deleteAddress(address.id)
    }
}
```
