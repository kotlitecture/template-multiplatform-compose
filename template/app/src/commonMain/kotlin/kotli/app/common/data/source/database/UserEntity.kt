package kotli.app.common.data.source.database

data class UserEntity(
    var id: Long = 0L,
    var firstName: String?,
    var lastName: String?
)