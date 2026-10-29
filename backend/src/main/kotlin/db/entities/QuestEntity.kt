package io.github.phobosxiii.db.entities

import io.github.phobosxiii.db.tables.QuestsTable
import org.jetbrains.exposed.v1.core.dao.id.EntityID
import org.jetbrains.exposed.v1.dao.LongEntity
import org.jetbrains.exposed.v1.dao.LongEntityClass

class QuestEntity(id: EntityID<Long>) : LongEntity(id) {
    companion object : LongEntityClass<QuestEntity>(QuestsTable)

    var title by QuestsTable.title
    var description by QuestsTable.description
    var type by QuestsTable.type
    var startDate by QuestsTable.startDate
    var startTime by QuestsTable.startTime
    var createdAt by QuestsTable.createdAt
    var lastModified by QuestsTable.lastModified

    override fun toString(): String {
        return "QuestEntity(title='$title', description='$description', type=$type, startDate=$startDate," +
                " startTime=$startTime, createdAt=$createdAt, lastModified=$lastModified)"
    }
}