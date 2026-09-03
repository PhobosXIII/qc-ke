package models

import kotlinx.serialization.Serializable

/**
 * Роль пользователя в системе
 */
@Serializable
enum class UserRole {
    /**
     * Игрок квеста. Может быть как 1 человек, так и команда
     */
    PLAYER,

    /**
     * Организатор квеста, может следить за процессом игры и управлять ей
     */
    ORG,

    /**
     * Агент, может наблюдать за процессом игры, но не управлять ей
     */
    AGENT,

    /**
     * Главный администратор (управляет квестами, пользователями, новостями и т.д.)
     */
    ADMIN
}

/**
 * Пользователь системы
 *
 * @param id идентификатор пользователя
 * @param username имя пользователя
 * @param role роль пользователя: игрок, организатор, агент или администратор
 */
@Serializable
data class User(
    val id: Long,
    val username: String,
    val role: UserRole,
)