package io.github.phobosxiii

import io.github.phobosxiii.repos.FakeUserRepository
import io.github.phobosxiii.repos.UserRepository
import io.ktor.server.application.*
import io.ktor.server.plugins.di.*

fun Application.configureDependencyInjection() {
    dependencies {
        provide<UserRepository> {
            FakeUserRepository()
        }
    }
}
