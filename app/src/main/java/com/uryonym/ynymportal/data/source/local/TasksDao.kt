package com.uryonym.ynymportal.data.source.local

import androidx.room.Dao
import androidx.room.Query
import com.uryonym.ynymportal.data.Task
import kotlinx.coroutines.flow.Flow

@Dao
interface TasksDao {
    @Query("select * from tasks")
    fun observeTasks(): Flow<List<Task>>

    @Query("select * from tasks where id = :taskId")
    fun observeTaskById(id: String): Flow<Task>
}