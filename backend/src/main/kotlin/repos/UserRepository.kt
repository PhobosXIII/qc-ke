package io.github.phobosxiii.repos

import models.User
import models.UserRole

interface UserRepository {
    fun organizers(): List<User>
    fun addUser(user: User)
    fun removeUser(id: Long): Boolean
}

class FakeUserRepository : UserRepository {
    private val users = mutableListOf(
        User(id = 1, username = "Player 1", role = UserRole.PLAYER),
        User(id = 2, username = "Player 2", role = UserRole.PLAYER),
        User(id = 3, username = "Org 1", role = UserRole.ORG),
        User(id = 4, username = "Org 2", role = UserRole.ORG),
        User(id = 5, username = "Agent", role = UserRole.AGENT),
        User(id = 6, username = "Admin", role = UserRole.ADMIN),
    )

    override fun organizers(): List<User> = users.filter { it.role == UserRole.ORG }

    override fun addUser(user: User) {
        if (users.find { it.id == user.id } != null) {
            throw IllegalStateException("Cannot duplicate user!")
        }
        users.add(user)
    }

    override fun removeUser(id: Long): Boolean = users.removeIf { it.id == id }

}