package io.github.phobosxiii.db.tables

import models.UserRole
import org.jetbrains.exposed.v1.core.dao.id.LongIdTable

/**
 * Таблица пользователей системы
 */
object UsersTable : LongIdTable("users") {
    val username = varchar("username", 50)

    val role = customEnumeration(
        name = "role",
        sql = "VARCHAR(10)",
        fromDb = { value -> UserRole.valueOf(value as String) },
        toDb = { value -> value.name }
    )
}