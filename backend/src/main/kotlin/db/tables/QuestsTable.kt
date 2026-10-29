package io.github.phobosxiii.db.tables

import models.QuestType
import org.jetbrains.exposed.v1.core.dao.id.LongIdTable
import org.jetbrains.exposed.v1.datetime.CurrentTimestamp
import org.jetbrains.exposed.v1.datetime.date
import org.jetbrains.exposed.v1.datetime.time
import org.jetbrains.exposed.v1.datetime.timestamp

/**
 * Таблица квестов
 */
object QuestsTable : LongIdTable("quests") {
    val title = varchar("title", 100)
    val description = text("description")

    val type = customEnumeration(
        name = "type",
        sql = "VARCHAR(3)",
        fromDb = { value -> QuestType.valueOf(value as String) },
        toDb = { value -> value.name }
    )

    val startDate = date("start_date")
    val startTime = time("start_time")
    val createdAt = timestamp("created_at")
        .defaultExpression(CurrentTimestamp)
    val lastModified = timestamp("last_modified")
        .defaultExpression(CurrentTimestamp)
}