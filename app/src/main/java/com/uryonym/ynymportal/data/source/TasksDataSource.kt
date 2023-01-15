package com.uryonym.ynymportal.data.source

import com.uryonym.ynymportal.data.Result
import com.uryonym.ynymportal.data.Task
import kotlinx.coroutines.flow.Flow

interface TasksDataSource {
    fun getTasksStream(): Flow<Result<List<Task>>>

    fun getTaskStream(taskId: String): Flow<Result<Task>>

    suspend fun saveTask(task: Task)
}