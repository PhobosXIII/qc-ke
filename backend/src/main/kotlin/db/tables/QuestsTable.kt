package io.github.phobosxiii.db.tables

import models.QuestType
import org.jetbrains.exposed.v1.core.dao.id.LongIdTable

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
}