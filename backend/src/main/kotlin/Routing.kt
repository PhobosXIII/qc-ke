package io.github.phobosxiii

import io.github.phobosxiii.repos.UserRepository
import io.ktor.http.*
import io.ktor.serialization.*
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.plugins.di.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import models.User

suspend fun Application.configureRouting() {
    val repository = dependencies.resolve<UserRepository>()

    routing {
        staticResources(remotePath = "/static", basePackage = "static")

        get(path = "/") {
            call.respondText("Hello, World!")
        }

        get(path = "/organizers") {
            val orgs = repository.organizers()
            call.respond(orgs)
        }

        route(path = "/users") {
            post {
                try {
                    val user = call.receive<User>()
                    repository.addUser(user)
                    call.respond(HttpStatusCode.NoContent)
                } catch (ex: IllegalStateException) {
                    call.respond(HttpStatusCode.BadRequest)
                } catch (ex: JsonConvertException) {
                    call.respond(HttpStatusCode.BadRequest)
                }
            }

            delete("/{userId}") {
                val id = call.parameters["userId"]?.toLongOrNull()

                if (id == null) {
                    call.respond(HttpStatusCode.BadRequest)
                    return@delete
                }

                if (repository.removeUser(id)) {
                    call.respond(HttpStatusCode.NoContent)
                } else {
                    call.respond(HttpStatusCode.NotFound)
                }
            }
        }
    }
}