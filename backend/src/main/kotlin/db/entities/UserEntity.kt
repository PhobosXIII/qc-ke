package io.github.phobosxiii.db.entities

import io.github.phobosxiii.db.tables.UsersTable
import models.User
import org.jetbrains.exposed.v1.core.dao.id.EntityID
import org.jetbrains.exposed.v1.dao.LongEntity
import org.jetbrains.exposed.v1.dao.LongEntityClass

class UserEntity(id: EntityID<Long>) : LongEntity(id) {
    companion object : LongEntityClass<UserEntity>(UsersTable)

    var username by UsersTable.username
    var role by UsersTable.role

    override fun toString(): String {
        return "UserEntity(username='$username', role=$role)"
    }
}

/**
 * Маппер для преобразования сущности базы данных [UserEntity] в доменную модель [User]
 */
fun UserEntity.toModel(): User {
    return User(
        id = id.value,
        username = username,
        role = role
    )
}
