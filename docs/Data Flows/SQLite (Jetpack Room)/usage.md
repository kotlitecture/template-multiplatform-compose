# Usage

## Overview

- Component package: `app.common.data.source.database.room`
- Integration config: `app.platform.PlatformConfig`

The integration includes the following components:

- **AppDatabase**: A pre-configured Room database designed to register all entities and DAO objects.
- **RoomSource**: Serves as a holder of the AppDatabase instance and acts as a service locator for all DAO objects.
- **User** and **UserDao**: An example entity and its associated DAO object. These classes serve as templates that can be used to create your own entities and DAOs.

## Create new Entity and DAO

The official guide for defining entities can be found here: [https://developer.android.com/training/data-storage/room/defining-data](https://developer.android.com/training/data-storage/room/defining-data)

Imagine you need to add a new entity called **Address**. Here are the steps to follow.

### 1. Create the `Address` entity class

You can use the `User` class in `app.common.data.source.database.room.entity` as a template.

```kotlin
@Entity(tableName = "address")
data class Address(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    @ColumnInfo(name = "country")
    var country: String? = null,
    @ColumnInfo(name = "city")
    var city: String? = null,
    @ColumnInfo(name = "street")
    var street: String? = null,
)
```

### 2. Create the `AddressDao` interface

You can use the `UserDao` interface in `app.common.data.source.database.room.dao` as a template.

```kotlin
@Dao
interface AddressDao {
    @Insert
    fun create(vararg addresses: Address)
    @Update
    fun update(vararg addresses: Address)
    @Delete
    fun delete(vararg addresses: Address)
    @Query("SELECT * FROM address WHERE id = :id LIMIT 1")
    fun get(id: Long): Address?
    @Query("SELECT * FROM address")
    fun getAll(): List<Address>
    @Query("SELECT * FROM address")
    fun getAllAsFlow(): Flow<Address>
}
```

### 3. Register `Address` and `AddressDao` in `AppDatabase`

```kotlin
@Database(
    entities = [
        Address::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getAddressDao(): AddressDao

}
```

### 4. Add methods into the `DatabaseSource` facade to expose the newly generated DAO.

Follow the existing method patterns and use a **copy-paste** approach to add the required method to `app.common.data.source.database.room.RoomSource`.

## Usage of DAO in your code

In this example, we will directly use `DatabaseSource` from the `ViewModel` to access `AddressDao`. However, it is recommended to create a separate `Repository` layer and call all data sources from there.

```kotlin
class AddressViewModel(
    private val databaseSource: DatabaseSource
) : BaseViewModel() {

    val addresses = mutableStateOf(emptyList<Address>())

    override fun doBind() = async("Get all addresses") {
        databaseSource.getAddressesLive().collectLatest(addresses::value::set)
    }

    fun onCreate(address: Address) = async("onCreate", appState) {
        databaseSource.createAddress(address)
    }

    fun onDelete(address: Address) = async("onRemove", appState) {
        databaseSource.deleteAddress(address)
    }

}
```
