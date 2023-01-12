package com.uryonym.ynymportal.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "tasks")
data class Task(
    @PrimaryKey @ColumnInfo(name = "id") val id: String = UUID.randomUUID().toString(),
    @ColumnInfo(name = "title") var title: String = "",
    @ColumnInfo(name = "description") var description: String = "",
    @ColumnInfo(name = "is_complete") var isComplete: Boolean = false,
    @ColumnInfo(name = "uid") var uid: String = "",
    @ColumnInfo(name = "task_list_id") var taskListId: String = "",
    @ColumnInfo(name = "created_at") var createdAt: Long = 0,
    @ColumnInfo(name = "updated_at") var updatedAt: Long = 0,
) {
    val isActive
        get() = !isComplete
}
