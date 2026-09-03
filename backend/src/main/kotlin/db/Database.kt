package io.github.phobosxiii.db

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import io.github.phobosxiii.db.entities.UserEntity
import io.github.phobosxiii.db.tables.UsersTable
import io.ktor.server.application.*
import models.UserRole
import org.jetbrains.exposed.v1.core.StdOutSqlLogger
import org.jetbrains.exposed.v1.jdbc.Database
import org.jetbrains.exposed.v1.jdbc.SchemaUtils
import org.jetbrains.exposed.v1.jdbc.transactions.transaction


/**
 * Соединение с БД в зависимости от окружения (разработка или прод)
 */
fun Application.configureDb() {
    val env = System.getenv("QC_APP_ENV") ?: "dev"
    if (env == "prod") {
        val config = HikariConfig().apply {
            driverClassName = "org.postgresql.Driver"
            jdbcUrl = "jdbc:postgresql://localhost:5432/qc_db"
            username = System.getenv("QC_DB_USER") ?: "postgres"
            password = System.getenv("QC_DB_PASSWORD") ?: "secret"
            maximumPoolSize = 10
        }
        val dataSource = HikariDataSource(config)
        Database.connect(dataSource)
    } else {
        Database.connect(url = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1", driver = "org.h2.Driver")
    }

    transaction {
        addLogger(StdOutSqlLogger)
        SchemaUtils.create(UsersTable)

        val user1 = UserEntity.new {
            username = "Admin"
            role = UserRole.ADMIN
        }

        val user2 = UserEntity.new {
            username = "Вася"
            role = UserRole.PLAYER
        }
    }
}
